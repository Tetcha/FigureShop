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
import order.daos.OrderDao;
import order.models.Order;
import utils.Helper;
import user.models.User;

/**
 *
 * @author locnh
 */
@WebServlet(name = "OrderHistoryController", urlPatterns = {"/" + Router.ORDER_HISTORY_CONTROLLER})
public class OrderHistoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        OrderDao orderDao = new OrderDao();

        // get current userId
        User user = (User) session.getAttribute("user");
        // get user's orders
        ArrayList<Order> orders = orderDao.getOrdersByUserId(user.getId());

        // check empty
        if (orders == null) {
            request.setAttribute("emptyMessage", Message.EMPTY_MESSAGE);
            return;
        }
        // send to request
        request.setAttribute("orders", orders);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            // forward on 200
            request.getRequestDispatcher(Router.ORDER_HISTORY_PAGE).forward(request, response);
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
