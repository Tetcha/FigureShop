package user.controllers;

import constants.Router;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author locnh
 */
@WebServlet(name = "LogoutController", urlPatterns = {"/" + Router.LOGOUT_CONTROLLER})
public class LogoutController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Remove session
            HttpSession session = request.getSession();
            session.setAttribute("user", null);
        } finally {
            // forward on success
            response.sendRedirect(Router.HOME_CONTROLLER);
        }
    }

}
