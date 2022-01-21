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
@WebServlet(name = "UpdateProductController", urlPatterns = {"/" + Router.ADMIN_UPDATE_PRODUCT_CONTROLLER})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)
public class UpdateProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>POST</code> methods.
     */
    protected int postHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDao productDao = new ProductDao();
        // get the current product
        String productId = GetParam.getStringParam(request, "id", "Product's id", 0, 40, null);
        if (productId == null) {
            return 0;
        }
        Product product = productDao.getProductById(productId);
        // check existed product
        if (product == null) {
            return 0;
        }
        // validate params
        String name = GetParam.getStringParam(request, "name", "Product's name", 3, 255, null);
        String imageUrl = GetParam.getFileParam(request, "image", "Product's image", 1080 * 1080);
        String prevImage = GetParam.getStringParam(request, "prevImage", "prevImage's name", 5, 255, null);
        Integer quantity = GetParam.getIntParams(request, "quantity", "Quantity", 0, Integer.MAX_VALUE, null);
        Float price = GetParam.getFloatParams(request, "price", "Price", 0, Float.MAX_VALUE, null);
        String description = GetParam.getStringParam(request, "description", "Description", 3, 255, null);
        String categoryId = GetParam.getStringParam(request, "type", "Type", 0, 40, null);
        if (imageUrl != null) {
            prevImage = imageUrl;
        }
        if (imageUrl == null && prevImage != null) {
            imageUrl = prevImage;
            request.setAttribute("imageError", null);
        }

        if (name == null || (imageUrl == null && prevImage == null) || quantity == null || price == null || description == null || categoryId == null) {
            return 1;
        }

        // update to database
        productDao.updateProduct(productId, name, imageUrl, quantity, price, description, categoryId);

        request.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.SUCCESS);
        request.setAttribute(Notification.AttrType.notiMessage.name(), Message.SUCCESS_MESSAGE.getContent());
        request.setAttribute(Notification.AttrType.notiDescription.name(), Message.UPDATE_PRODUCT_SUCCESS_DESCRIPTION.getContent());
        return 2;
    }

    protected boolean getHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        ProductDao productDao = new ProductDao();

        // get the current product
        String productId = GetParam.getStringParam(request, "id", "ProductId", 0, 40, null);
        Product product = productDao.getProductById(productId);

        // check existed product
        if (product == null) {
            return false;
        }

        request.setAttribute("product", product);

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!getHandler(request, response)) {
                // forward on 404
                Helper.setAttribute(request, StatusCode.NOT_FOUND.getValue(),
                        Message.NOT_FOUND_ERROR_TITLE.getContent(),
                        Message.NOT_FOUND_ERROR_MESSAGE.getContent());
                request.getRequestDispatcher(Router.ERROR).forward(request, response);
                return;
            }
            // forward on 200
            request.getRequestDispatcher(Router.ADMIN_UPDATE_PRODUCT_PAGE).forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            // forward on 500
            Helper.setAttribute(request, StatusCode.INTERNAL_SERVER_ERROR.getValue(),
                    Message.INTERNAL_ERROR_TITLE.getContent(),
                    Message.INTERNAL_ERROR_MESSAGE.getContent());
            request.getRequestDispatcher(Router.ERROR).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int result = postHandler(request, response);
            if (result == 0) {
                //forward on 404
                Helper.setAttribute(request, StatusCode.NOT_FOUND.getValue(),
                        Message.NOT_FOUND_ERROR_TITLE.getContent(),
                        Message.NOT_FOUND_ERROR_MESSAGE.getContent());
                request.getRequestDispatcher(Router.ERROR).forward(request, response);
                return;
            }
            if (result == 1) {
                //forward on 400
                this.doGet(request, response);
                return;
            }
            // forward on 200
            this.doGet(request, response);
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
