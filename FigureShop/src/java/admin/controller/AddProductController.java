package admin.controller;

import constants.Message;
import constants.Notification;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(name = "AddProductController", urlPatterns = {"/" + Router.ADMIN_ADD_PRODUCT_CONTROLLER})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)
public class AddProductController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDao productDao = new ProductDao();
        boolean isTrue = true;

        //validate param
        String name = GetParam.getStringParam(request, "name", "Product's name", 5, 255, null);
        String image = GetParam.getFileParam(request, "image", "Product's image", 1080 * 1080);
        Integer quantity = GetParam.getIntParams(request, "quantity", "Quantity", 0, Integer.MAX_VALUE, null);
        Float price = GetParam.getFloatParams(request, "price", "Price", 0, Float.MAX_VALUE, null);
        String description = GetParam.getStringParam(request, "description", "Description", 5, Integer.MAX_VALUE, null);
        String categoryId = GetParam.getStringParam(request, "category", "Category", 0, 40, null);

        //check params
        if (name == null || image == null || quantity == null || price == null || description == null || categoryId == null) {
            isTrue = false;
        }

        // check duplicated name
        if (name != null && productDao.getProductByName(name) != null) {
            request.setAttribute("nameError", Message.DULICATE_NAME_MESSAGE.getContent());
            isTrue = false;
        }

        //check error occur
        if (!isTrue) {
            return false;
        }

        //add new product to database
        Product product = new Product(name, image, quantity, price, description, categoryId);
        productDao.addNewProduct(product);

        request.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.SUCCESS);
        request.setAttribute(Notification.AttrType.notiMessage.name(), Message.SUCCESS_MESSAGE.getContent());
        request.setAttribute(Notification.AttrType.notiDescription.name(), Message.ADD_PRODUCT_SUCCESS_DESCRIPTION.getContent());
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Router.ADMIN_ADD_PRODUCT_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!processRequest(request, response)) {
                // forward on 400
                request.getRequestDispatcher(Router.ADMIN_ADD_PRODUCT_PAGE).forward(request, response);
                return;
            }
            // forward on 200
            request.getRequestDispatcher(Router.ADMIN_ADD_PRODUCT_PAGE).forward(request, response);
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
