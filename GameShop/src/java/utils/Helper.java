package utils;

//import daos.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import user.dtos.User;

public class Helper {

    /**
     * Ensure that access only to authorized users
     */
    public static boolean protectedRouter(HttpServletRequest request, HttpServletResponse response, int minRole,
            int maxRole, String page) throws Exception {

        if (!isLogin(request) || !correctRole(request, minRole, maxRole)) {
            request.setAttribute("errorMessage", "Action is not allow, please login first");
            request.getRequestDispatcher(page).forward(request, response);

            return false;
        }

        return true;
    }

    /**
     * Check that user's role is valid or invalid
     */
    public static boolean correctRole(HttpServletRequest request, int minRole, int maxRole) {
        HttpSession session = request.getSession(false);
        Integer roleR = (Integer) session.getAttribute("userRole");

        return roleR != null && roleR >= minRole && roleR <= maxRole;
    }

    /**
     * Check that user is login or not
     */
    public static boolean isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        String userId = (String) session.getAttribute("userId");

        return userId != null;
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

//    // set attribute user
//    public static void sendUserResponse(HttpServletRequest request) throws Exception {
//        HttpSession session = request.getSession();
//        String userId = (String) session.getAttribute("userId");
//        UserDAO userDao = new UserDAO();
//
//        User user = userDao.getUserById(userId);
//        request.setAttribute("user", user);
//    }
}
