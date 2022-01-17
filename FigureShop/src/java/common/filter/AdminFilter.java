package common.filter;

import constants.Message;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Helper;

/**
 *
 * @author locnh
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/" + Router.ADMIN_ADD_PRODUCT_CONTROLLER,
    "/" + Router.ADMIN_ORDERS_CONTROLLER, "/" + Router.ADMIN_PRODUCT_CONTROLLER, "/" + Router.ADMIN_UPDATE_ORDER_CONTROLLER,
    "/" + Router.ADMIN_UPDATE_PRODUCT_CONTROLLER, "/" + Router.ADMIN_USER_CONTROLLER, "/" + Router.ADMIN_VIEW_PRODUCT_CONTROLLER})
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            if (!Helper.protectedRouter(req, res, 1, Router.ERROR)) {
                return;
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println(e);
            // forward on 500
            Helper.setAttribute(req, StatusCode.INTERNAL_SERVER_ERROR.getValue(),
                    Message.INTERNAL_ERROR_TITLE.getContent(),
                    Message.INTERNAL_ERROR_MESSAGE.getContent());
            request.getRequestDispatcher(Router.ERROR).forward(request, response);
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }

}
