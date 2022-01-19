package common.filter;

import constants.Message;
import constants.Router;
import constants.StatusCode;
import java.io.IOException;
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
@WebFilter(filterName = "UserFilter", urlPatterns = {"/" + Router.CHECKOUT_CONTROLLER, "/" + Router.ORDER_HISTORY_CONTROLLER, "/" + Router.ORDER_HISTORY_DETAIL_CONTROLLER})
public class UserFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            if (!Helper.protectedRouter(req, res, 0, Router.LOGIN_PAGE)) {
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
