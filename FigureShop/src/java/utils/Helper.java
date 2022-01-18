package utils;

//import daos.UserDAO;
import constants.Notification;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import user.models.User;

public class Helper {

    /**
     * Ensure that access only to authorized users
     */
    public static boolean protectedRouter(HttpServletRequest request, HttpServletResponse response, int isAdmin, String page) throws Exception {
        if (!isLogin(request) || !correctRole(request, isAdmin)) {
            request.setAttribute(Notification.AttrType.notiStatus.name(), Notification.Status.WARNING);
            request.setAttribute(Notification.AttrType.notiMessage.name(), "Action is not allow, please login first");
            request.setAttribute(Notification.AttrType.notiDescription.name(), "Day la description");
            request.getRequestDispatcher(page).forward(request, response);

            return false;
        }

        return true;
    }

    /**
     * Check that user's role is valid or invalid
     */
    public static boolean correctRole(HttpServletRequest request, int isAdmin) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        return user != null && user.getIsAdmin() == isAdmin;
    }

    /**
     * Check that user is login or not
     */
    public static boolean isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        User user = (User) session.getAttribute("user");

        return user != null;
    }

    //get file name of image
    public static String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }

    //set attribute for error page
    public static void setAttribute(HttpServletRequest request, Integer errorStatus, String errorTitle, String errorDescription) {
        request.setAttribute("errorStatus", errorStatus);
        request.setAttribute("errorTitle", errorTitle);
        request.setAttribute("errorDescription", errorDescription);
    }
}
