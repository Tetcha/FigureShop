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
import product.models.Product;
import utils.GetParam;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "ProductQuantityController", urlPatterns = {"/" + Router.CART_PRODUCT_QUANTITY_CONTROLLER})
public class CartProductQuantityController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        //get list of products
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        //get index of product
        Integer index = GetParam.getIntParams(request, "productIndex", "Product's index", 0, Integer.MAX_VALUE, null);

        //check option increase or descrease
        Integer isIncreased = GetParam.getIntParams(request, "isIncreased", "Is increased", 0, 1, null);

        // check params
        if (products == null || index == null || isIncreased == null) {
            return false;
        }

        // decrease
        if (isIncreased == 0) {
            int newQuantity = products.get(index).getQuantity() - 1;
            if (newQuantity == 0) { // remove if quantity = 0
                products.remove((int) index);
            } else {
                products.get(index).setQuantity(newQuantity);
            }
        } else { // increase
            products.get(index).setQuantity(products.get(index).getQuantity() + 1);
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
                // forward on 400
                request.getRequestDispatcher(Router.CART_PAGE).forward(request, response);
                return;
            }
            // forward on 200
            request.getRequestDispatcher(Router.CART_PAGE).forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // forward on 500
            Helper.setAttribute(request, StatusCode.INTERNAL_SERVER_ERROR.getValue(),
                    Message.INTERNAL_ERROR_TITLE.getContent(),
                    Message.INTERNAL_ERROR_MESSAGE.getContent());
            request.getRequestDispatcher(Router.ERROR).forward(request, response);
        }
    }

}
