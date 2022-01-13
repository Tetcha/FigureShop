package common;

import category.daos.CategoryDao;
import category.models.Category;
import constants.Router;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "HomeController", urlPatterns = {"/" + Router.HOME_CONTROLLER})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Router.HOME_PAGE).forward(request, response);

    }
}
