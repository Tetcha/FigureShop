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
import user.daos.UserDao;
import utils.GetParam;
import user.models.User;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/" + Router.REGISTER_CONTROLLER})
public class RegisterController extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        UserDao userDao = new UserDao();
        boolean isValid = true;

        // validate param
        String email = GetParam.getEmailParams(request, "email", "Email");
        String fullName = GetParam.getStringParam(request, "fullName", "Full name", 5, 50, null);
        String password = GetParam.getStringParam(request, "password", "Password", 5, 50, null);
        String confirmPassword = GetParam.getStringParam(request, "confirmPassword", "Confirm Password", 5, 50, null);

        if (email == null || password == null || confirmPassword == null || fullName == null) {
            isValid = false;
        }

        //Checking existed email
        User existedEmail = userDao.getUserByEmail(email);
        if (existedEmail != null) {
            request.setAttribute("email", email);
            request.setAttribute("emailError", Message.EXISTED_EMAIL_MESSAGE.getContent());
            isValid = false;
        }

        //Checking confirm password is correct
        if (confirmPassword != null && password != null && !password.equals(confirmPassword)) {
            request.setAttribute("confirmPasswordError", Message.CONFIRM_PASSWORD_ERROR_MESSAGE.getContent());
            isValid = false;
        }

        if (!isValid) {
            return false;
        }

        // save to db
        User user = new User(fullName, email, password, 0);
        userDao.addNewUser(user);
        request.setAttribute("successMessage", Message.REGISTER_SUCCESS_MESSAGE.getContent());
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(Router.REGISTER_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if (!processRequest(request, response)) {
                // forward on 400
                request.getRequestDispatcher(Router.REGISTER_PAGE).forward(request, response);
                return;
            }
            // forward on 200
            response.sendRedirect(Router.LOGIN_CONTROLLER);
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
