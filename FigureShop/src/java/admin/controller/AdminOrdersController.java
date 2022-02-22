package admin.controller;

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
import order.dtos.OrderWithEmailDto;
import utils.GetParam;
import order.models.Order;
import orderitem.daos.OrderItemDao;
import orderitem.dtos.OrderItemDto;
import user.daos.UserDao;
import utils.Helper;
import user.models.User;

/**
 *
 * @author locnh
 */
@WebServlet(name = "ViewOrderController", urlPatterns = {"/" + Router.ADMIN_ORDERS_CONTROLLER})
public class AdminOrdersController extends HttpServlet {

    private static final int LIMIT = 11;

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        UserDao userDao = new UserDao();
        HttpSession session = request.getSession();
        String[] errors = {"addressError", "consigneeNameError", "phoneError"};

        Helper.resetNoti(request);
        Helper.resetErrorMessage(request, errors);

        // get param
        String fromDate = GetParam.getStringParam(request, "fromDate", "from date", 7, 12, null);
        String toDate = GetParam.getStringParam(request, "toDate", "to date", 7, 12, null);
        Integer page = GetParam.getIntParams(request, "page", "Page", 1, Integer.MAX_VALUE, 1);
        String currentOrderId = GetParam.getStringParam(request, "currentShow", "current show", 0, 40, null);
        String email = GetParam.getEmailParams(request, "email", "User's email");

        if (fromDate == null) {
            fromDate = "2000-01-01";
        }

        if (toDate == null) {
            toDate = "2077-01-01";
        }

        if (email == null) {
            email = "%%";
        } else {
            email = "%" + email + "%";
        }

        ArrayList<String> ids = userDao.getUserIdByEmail(email);

        // get orders
        ArrayList<Order> orders = new ArrayList<>();
        for (String id : ids) {
            ArrayList<Order> order = orderDao.getOrdersForAdmin(fromDate, toDate, page, id, LIMIT);
            for (Order element : order) {
                orders.add(element);
            }
        }

        ArrayList<Order> allOrders = orderDao.getOrders();

        if (currentOrderId == null && orders.size() > 0) {
            currentOrderId = orders.get(0).getId();
        }
        ArrayList<OrderItemDto> currentShow = orderItemDao.getOrderItemDtoByOrderId(currentOrderId);
        OrderWithEmailDto currentOrderShow = null;
        for (Order order : orders) {
            if (order.getId().equals(currentOrderId)) {
                currentOrderShow = new OrderWithEmailDto(order.getId(),
                        order.getUser(), order.getAddress(), order.getPhoneNumber(),
                        order.getConsigneeName(), order.getStatus(), order.getCreatedDate(), order.getTotalPrice());
                User user = userDao.getUserById(order.getUser().getId());
                currentOrderShow.setEmail(user.getEmail());
            }
        }

        Integer maxPage = allOrders.size() / LIMIT;
        if (allOrders.size() % LIMIT != 0) {
            maxPage++;
        }

        String quantityMessage = (String) session.getAttribute("quantityError");
        session.setAttribute("quantityError", null);

        request.setAttribute("orders", orders);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("currentShow", currentShow);
        request.setAttribute("currentOrderShow", currentOrderShow);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("page", page);
        request.setAttribute("email", email);
        request.setAttribute("quantityError", quantityMessage);
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
            request.getRequestDispatcher(Router.ADMIN_ORDERS_PAGE).forward(request, response);
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
