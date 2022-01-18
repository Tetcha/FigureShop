package order.controller;

import constants.Message;
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
import utils.GetParam;
import product.models.Product;
import utils.Helper;
import user.models.User;

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
        HttpSession session = request.getSession();

        // check params
        String consigneeName = GetParam.getStringParam(request, "consigneeName", "Consignee name", 5, 255, null);
        String address = GetParam.getStringParam(request, "address", "Address", 5, 255, null);
        String phone = GetParam.getPhoneParams(request, "phone", "Phone number");

        if (consigneeName == null || address == null || phone == null) {
            String nameError = (String) request.getAttribute("consigneeNameError");
            String addressError = (String) request.getAttribute("addressError");
            String phoneError = (String) request.getAttribute("phoneError");

            session.setAttribute("phoneError", phoneError);
            session.setAttribute("nameError", nameError);
            session.setAttribute("addressError", addressError);
            return false;
        }

        // get products from cart
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        if (products == null || products.isEmpty()) {
            session.setAttribute("emptyMessage", Message.EMPTY_CART_MESSAGE.getContent());
            return false;
        }

        // get current userId
        User user = (User) session.getAttribute("user");
        Float totalPrice = 0f;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }

        // save to db
        if (!orderDao.addNewOrder(products, OrderStatus.WAITING.ordinal(), user.getId(), consigneeName, address, phone, totalPrice)) {
            throw new Exception();
        }

        // update products in cart
        products.clear();
        session.setAttribute("products", products);
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
