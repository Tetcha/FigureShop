package admin.controller;

import category.daos.CategoryDao;
import category.models.Category;
import constants.Router;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.daos.ProductDao;
import product.models.Product;
import utils.GetParam;
import utils.Helper;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminProductController", urlPatterns = {"/" + Router.ADMIN_PRODUCT_CONTROLLER})
public class AdminProductController extends HttpServlet {

    private final int LIMIT = 9;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();

        Helper.resetNoti(request);

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
            return;
        }

        // get products
        ArrayList<Product> products = productDao.getProducts(name, categoryId, minPrice, maxPrice, page, LIMIT);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().length() > 30) {
                products.get(i).setName(products.get(i).getName().substring(0, 26) + "...");
            }
        }
        int resultSize = productDao.filterAllProducts(name, categoryId, minPrice, maxPrice).size();
        int maxPage = resultSize / LIMIT;

        if (resultSize % LIMIT > 0) {
            maxPage = maxPage + 1;
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            Category category = categoryDao.getCategoryByID(product.getCategoryId());
            product.setCategoryId(category.getName());
        }

        // send products
        request.setAttribute("products", products);
        request.setAttribute("maxPage", maxPage);
        return;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.getRequestDispatcher(Router.ADMIN_PRODUCT_PAGE).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
