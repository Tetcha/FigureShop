package user.controllers;

import constants.Message;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.daos.UserDao;
import utils.GetParam;
import user.dtos.User;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "LoginController", urlPatterns = {"/" + Router.LOGIN_CONTROLLER})
public class LoginController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        UserDao userDao = new UserDao();

        //validate param
        String email = GetParam.getEmailParams(request, "email", "Email");
        String password = GetParam.getStringParam(request, "password", "Password", 6, 50, null);

        if (email == null || password == null) {
            return false;
        }

        // checking existed user and correct password
        User existedUser = userDao.getUserByEmail(email);
        if (existedUser == null || !existedUser.getPassword().equals(password)) {
            return false;
        }

        // handle on login
        HttpSession session = request.getSession();
        session.setAttribute("user", existedUser);
        return true;
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(Router.LOGIN_PAGE).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (!processRequest(request, response)) {
                // forward on 400
                request.setAttribute("errorMessage", Message.LOGIN_ERROR_MESSAGE.getContent());
                request.getRequestDispatcher(Router.LOGIN_PAGE).forward(request, response);
                return;
            }
            // forward on 200
            response.sendRedirect(Router.HOME_PAGE);
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
