package order.controller;

import constants.Message;
import constants.Notification;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import order.constants.OrderStatus;
import order.daos.OrderDao;
import product.daos.ProductDao;
import utils.GetParam;
import utils.Helper;
import user.models.User;
import product.models.Product;

/**
 *
 * @author locnh
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/" + Router.CHECKOUT_CONTROLLER})
public class CheckoutController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        OrderDao orderDao = new OrderDao();
        ProductDao productDao = new ProductDao();
        HttpSession session = request.getSession();
        String[] fields = {"phoneError", "consigneeNameError", "addressError", "address", "phone", "consigneeName"};

        // check params
        String consigneeName = GetParam.getStringParam(request, "consigneeName", "Consignee name", 5, 255, null);
        String address = GetParam.getStringParam(request, "address", "Address", 5, 255, null);
        String phone = GetParam.getPhoneParams(request, "phone", "Phone number");

        if (consigneeName == null || address == null || phone == null) {
            Helper.setFieldsToSession(request, fields);
            return false;
        }

        // get products from cart
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        if (products == null || products.isEmpty()) {
            Helper.setFieldsToSession(request, fields);
            session.setAttribute("emptyMessage", Message.EMPTY_CART_MESSAGE.getContent());
            return false;
        }

        // get current userId
        User user = (User) session.getAttribute("user");
        Float totalPrice = 0f;
        boolean isValid = true;
        String quantityMessage = "Not enough quantity: <br>";
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
            Product storeProduct = productDao.getProductById(product.getId());
            if (storeProduct.getQuantity() < product.getQuantity()) {
                isValid = false;
                quantityMessage += product.getName() + " (" + storeProduct.getQuantity() + ") <br>";
            }
        }

        if (!isValid) {
            session.setAttribute("notEnoughQuantityError", quantityMessage);
            Helper.setFieldsToSession(request, fields);
            return false;
        }

        // save to db
        if (!orderDao.addNewOrder(products, OrderStatus.WAITING.ordinal(), user.getId(), consigneeName, address, phone, totalPrice)) {
            throw new Exception();
        }

        for (Product product : products) {
            Product storeProduct = productDao.getProductById(product.getId());
            productDao.updateProductQuantity(storeProduct.getQuantity() - product.getQuantity(), product.getId());
        }

        // update products in cart
        products.clear();
        session.setAttribute("products", products);
        session.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.SUCCESS);
        session.setAttribute(Notification.AttrType.notiMessage.name(), Message.SUCCESS_MESSAGE.getContent());
        session.setAttribute(Notification.AttrType.notiDescription.name(), Message.CHECKOUT_SUCCESS_DESCRIPTION.getContent());
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!Helper.protectedRouter(request, response, 0, Router.LOGIN_PAGE)) {
                return;
            }
            if (!processRequest(request, response)) {
                // forward on 400
                response.sendRedirect(Router.CART_CONTROLLER);
                return;
            }
            // forward on 200
            response.sendRedirect(Router.HOME_CONTROLLER);
        } catch (Exception e) {
            System.out.println(e);
            // forward on 500
            Helper.setAttribute(request, StatusCode.INTERNAL_SERVER_ERROR.getValue(),
                    Message.INTERNAL_ERROR_TITLE.getContent(),
                    Message.INTERNAL_ERROR_MESSAGE.getContent());
            request.getRequestDispatcher(Router.ERROR).forward(request, response);
        }
    }

}
