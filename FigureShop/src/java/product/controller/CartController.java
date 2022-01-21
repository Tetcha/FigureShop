package product.controller;

import constants.Message;
import constants.Router;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.models.Product;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "CartController", urlPatterns = {"/" + Router.CART_CONTROLLER})
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String[] errors = {"consigneeNameError", "addressError", "phoneError", "notEnoughQuantityError", "emptyMessage", "phone", "address", "consigneeName"};

        Helper.resetErrorMessage(request, errors);

        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
        if (products != null) {
            if (!products.isEmpty()) {
                request.setAttribute("products", products);
            } else {
                request.setAttribute("emptyMessage", Message.EMPTY_CART_MESSAGE.getContent());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher(Router.CART_PAGE).forward(request, response);
    }

}
