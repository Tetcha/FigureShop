package product.controller;

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
import product.daos.ProductDao;
import utils.GetParam;
import product.dtos.Product;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "CartRemoveProductController", urlPatterns = {"/" + Router.CART_REMOVE_PRODUCT_CONTROLLER})
public class CartRemoveProductController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ProductDao productDao = new ProductDao();

        // get productId
        String productId = GetParam.getStringParam(request, "productId", "Product", 0, 40, null);

        // find product by given id
        Product product = productDao.getProductById(productId);

        // get the products from cart
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        // check existed product
        if (product == null || products.isEmpty()) {
            return false;
        }

        // remove product from cart
        for (Product pro : products) {
            if (pro.getId().equals(productId)) {
                products.remove(pro);
                break;
            }
        }

        // set products to session
        session.setAttribute("products", products);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!processRequest(request, response)) {
                // forward on 404
                Helper.setAttribute(request, StatusCode.NOT_FOUND.getValue(),
                        Message.NOT_FOUND_ERROR_TITLE.getContent(),
                        Message.NOT_FOUND_ERROR_MESSAGE.getContent());
                request.getRequestDispatcher(Router.ERROR).forward(request, response);
                return;
            }
            // forward on 200
            response.sendRedirect(Router.CART_CONTROLLER);
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
