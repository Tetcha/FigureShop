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
import product.daos.ProductDao;
import utils.GetParam;
import product.models.Product;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "ProductFilterController", urlPatterns = {"/" + Router.PRODUCT_FILTER_CONTROLLER})
public class ProductFilterController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        ProductDao productDao = new ProductDao();
        final int LIMIT = 20;
        // get params
        String name = GetParam.getStringParam(request, "name", "Name", 0, 255, "");
        String categoryId = GetParam.getStringParam(request, "categoryId", "Category", 0, 40, "");
        Float minPrice = GetParam.getFloatParams(request, "from", "min price", 0, Float.MAX_VALUE, 0.0f);
        Float maxPrice = GetParam.getFloatParams(request, "to", "max price", 0, Float.MAX_VALUE, Float.MAX_VALUE);
        Integer page = GetParam.getIntParams(request, "page", "Page", 1, Integer.MAX_VALUE, 1);

        request.setAttribute("name", name);
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("maxPrice", maxPrice);

        if (categoryId.equals("all")) {
            categoryId = "";
        }

        if (minPrice == null || maxPrice == null || page == null) {
            return false;
        }

        // check price
        if (minPrice > maxPrice) {
            request.setAttribute("priceError", Message.PRICE_ERROR_MESSAGE.getContent());
            return false;
        }

        // get products
        ArrayList<Product> products = productDao.getProducts(name, categoryId, minPrice, maxPrice, page, LIMIT);
        int resultSize = productDao.filterAllProducts(name, categoryId, minPrice, maxPrice).size();
        int maxPage = resultSize / LIMIT;
        if (resultSize % LIMIT > 0) {
            maxPage = maxPage + 1;
        }

        // send products
        request.setAttribute("products", products);
        request.setAttribute("maxPage", maxPage);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!processRequest(request, response)) {
                // forward on 400
                ArrayList<Product> products = new ArrayList<Product>();
                request.setAttribute("products", products);
                request.setAttribute("maxPage", 1);
                request.getRequestDispatcher(Router.PRODUCT_FILTER_PAGE).forward(request, response);
                return;
            }
            // forward on 200
            request.getRequestDispatcher(Router.PRODUCT_FILTER_PAGE).forward(request, response);
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
