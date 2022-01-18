package common.controller;

import constants.Router;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author locnh
 */
@WebServlet(name = "HomeController", urlPatterns = {"/" + Router.HOME_CONTROLLER})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Router.HOME_PAGE).forward(request, response);

    }
}
