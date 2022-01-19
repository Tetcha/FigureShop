package admin.controller;

import constants.Message;
import constants.Notification;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orderitem.daos.OrderItemDao;
import utils.GetParam;
import orderitem.models.OrderItem;
import product.daos.ProductDao;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "DeleteProductController", urlPatterns = {"/" + Router.ADMIN_DELETE_PRODCUT_CONTROLLER})
public class DeleteProductController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        OrderItemDao orderItemDao = new OrderItemDao();
        ProductDao productDao = new ProductDao();
        HttpSession session = request.getSession();

        // get param
        String id = GetParam.getStringParam(request, "id", "Product", 0, 40, null);
        if (id == null) {
            return false;
        }

        OrderItem orderItem = orderItemDao.getOrderItemByProductId(id);
        if (orderItem != null) {
            session.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.ERROR);
            session.setAttribute(Notification.AttrType.notiMessage.name(), Message.DELETE_ERROR_MESSAGE.getContent());
            session.setAttribute(Notification.AttrType.notiDescription.name(), Message.DELETE_ERROR_DESCRIPTION.getContent());
            return false;
        }

        productDao.deleteProductById(id);
        session.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.SUCCESS);
        session.setAttribute(Notification.AttrType.notiMessage.name(), Message.SUCCESS_MESSAGE.getContent());
        session.setAttribute(Notification.AttrType.notiDescription.name(), Message.DELETE_PRODUCT_DESCRIPTION.getContent());
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String prevUrl = (String) session.getAttribute("prevUrl");
            if (!processRequest(request, response)) {
                // forward on 400
                response.sendRedirect(Router.ADMIN_PRODUCT_CONTROLLER + "?" + prevUrl);
                return;
            }
            // forward on 200
            response.sendRedirect(Router.ADMIN_PRODUCT_CONTROLLER + "?" + prevUrl);
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
