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
import orderitem.daos.OrderItemDao;
import user.models.User;
import order.models.Order;
import orderitem.dtos.OrderItemDto;
import utils.GetParam;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "OrderHistoryDetailController", urlPatterns = {"/" + Router.ORDER_HISTORY_DETAIL_CONTROLLER})
public class OrderHistoryDetailController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        //Get current user
        User user = (User) session.getAttribute("user");

        //Get user's order
        ArrayList<Order> orders = orderDao.getOrdersByUserId(user.getId());

        //Get orderId
        String orderId = GetParam.getStringParam(request, "orderId", "Order id", 0, 40, null);

        //Check params
        if (orderId == null) {
            return false;
        }

        //Check userId and orderId that matched
        Order currentOrder = null;
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                currentOrder = order;
                break;
            }
        }
        if (currentOrder == null) {
            return false;
        }

        // Get list of orderItemDtos
        ArrayList<OrderItemDto> orderItemDtos = orderItemDao.getOrderItemDtoByOrderId(orderId);

        //send request
        request.setAttribute("orderItems", orderItemDtos);
        request.setAttribute("order", currentOrder);
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
            request.getRequestDispatcher(Router.ORDER_HISTORY_DETAIL_PAGE).forward(request, response);
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
