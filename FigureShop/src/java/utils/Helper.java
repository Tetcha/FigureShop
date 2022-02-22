package utils;

import constants.Message;
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
            request.setAttribute(Notification.AttrType.notiMessage.name(), Message.NOT_LOGIN_MESSAGE.getContent());
            request.setAttribute(Notification.AttrType.notiDescription.name(), Message.NOT_LOGIN_DESCRIPTION.getContent());
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

    public static void resetNoti(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // get noti
        Notification.Status notiStatus = (Notification.Status) session.getAttribute(Notification.AttrType.notiStatus.name());
        String notiMessage = (String) session.getAttribute(Notification.AttrType.notiMessage.name());
        String notiDescription = (String) session.getAttribute(Notification.AttrType.notiDescription.name());

        // reset
        session.setAttribute(Notification.AttrType.notiStatus.name(), null);
        session.setAttribute(Notification.AttrType.notiMessage.name(), null);
        session.setAttribute(Notification.AttrType.notiDescription.name(), null);

        // set noti
        request.setAttribute(Notification.AttrType.notiStatus.name(), notiStatus);
        request.setAttribute(Notification.AttrType.notiMessage.name(), notiMessage);
        request.setAttribute(Notification.AttrType.notiDescription.name(), notiDescription);
    }

    public static void resetErrorMessage(HttpServletRequest request, String[] errors) {
        HttpSession session = request.getSession();
        for (int i = 0; i < errors.length; i++) {
            String value = (String) session.getAttribute(errors[i]);
            session.setAttribute(errors[i], null);
            request.setAttribute(errors[i], value);
        }
    }

    public static void setFieldsToSession(HttpServletRequest request, String[] fields) {
        HttpSession session = request.getSession();
        for (int i = 0; i < fields.length; i++) {
            String value = (String) request.getAttribute(fields[i]);
            session.setAttribute(fields[i], value);
        }
    }
}
