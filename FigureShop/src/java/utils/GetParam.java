package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class GetParam {

    /**
     * Get string from request parameter and validate it, if it invalid, return
     * default value
     */
    public static String getStringParam(HttpServletRequest request, String field, String label, int min, int max,
            String defaultValue) {

        String value = (String) request.getParameter(field);
        //check empty string, if empty then return to default value
        if (value == null || value.trim().isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", label + " is required");
                return null;
            }

            return defaultValue;
        }

        //check min and max of string
        if (value.trim().length() > max) {
            request.setAttribute(field + "Error", label + " is less than or equal " + max + " character(s)");
            return null;
        }
        if (value.trim().length() < min) {
            request.setAttribute(field + "Error", label + " is greater than or equal " + min + " character(s)");
            return null;
        }
        return value.trim();
    }

    /**
     * Get Integer from request parameter and validate it, if it invalid, return
     * default value
     */
    public static Integer getIntParams(HttpServletRequest request, String field, String label, int min, int max,
            Integer defaultValue) {

        String value = (String) request.getParameter(field);
        Integer realValue;

        //check empty string, if empty then return to default value
        if (value == null || value.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", label + " is required");
                return null;
            }
            return defaultValue;
        }

        try {
            realValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            request.setAttribute(field + "Error",
                    label + " must be a number and less than or equal " + Integer.MAX_VALUE);
            return null;
        }
        if (realValue > max) {
            request.setAttribute(field + "Error", label + " is less than or equal " + max);
            return null;
        }
        if (realValue < min) {
            request.setAttribute(field + "Error", label + " is greater than or equal " + min);
            return null;
        }

        return realValue;
    }

    /**
     * Get Float from request parameter and validate it, if it invalid, return
     * default value
     */
    public static Float getFloatParams(HttpServletRequest request, String field, String label, float min, float max,
            Float defaultValue) {

        String value = (String) request.getParameter(field);
        Float realValue;

        //check empty string, if empty then return to default value
        if (value == null || value.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(field + "Error", label + " is required");
                return null;
            }
            return defaultValue;
        }

        try {
            realValue = Float.parseFloat(value);
        } catch (NumberFormatException e) {
            request.setAttribute(field + "Error",
                    label + " must be a number and less than or equal " + Float.MAX_VALUE);
            return null;
        }
        if (realValue > max) {
            request.setAttribute(field + "Error", label + " is less than or equal " + max);
            return null;
        }
        if (realValue < min) {
            request.setAttribute(field + "Error", label + " is greater than or equal " + min);
            return null;
        }

        return realValue;
    }

    /**
     * Get email from request parameter and validate it
     */
    public static String getEmailParams(HttpServletRequest request, String field, String label) {
        String value = getStringParam(request, field, label, 11, 50, null);

        if (value == null) {
            return null;
        }

        String errorMessage = Validator.getEmail(value);
        if (!errorMessage.isEmpty()) {
            request.setAttribute(field + "Error", label + errorMessage);
            return null;
        }
        return value;
    }

    /**
     * Get phone from request parameter and validate it
     */
    public static String getPhoneParams(HttpServletRequest request, String field, String label) {
        String value = getStringParam(request, field, label, 6, 20, null);

        if (value == null) {
            return null;
        }

        String errorMessage = Validator.getPhone(value);
        if (!errorMessage.isEmpty()) {
            request.setAttribute(field + "Error", label + errorMessage);
            return null;
        }
        return value;
    }

    public static String getFileParam(HttpServletRequest request, String field, String label, long maxSize) throws IOException, ServletException {
        //get upload file;
        Part filePart = request.getPart(field);
        if (filePart == null) {
            return null;
        }
        if (Helper.getFileName(filePart).equals("")) {
            request.setAttribute(field + "Error", label + " is required");
            return null;
        }
        //upload dir where save the image in server
        String uploadDir = "asset/productImages";
        //get absolute path to project
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        //path to save file
        String fullSavePath = null;
        if (appPath.endsWith("/")) {
            fullSavePath = appPath + uploadDir;
        } else {
            fullSavePath = appPath + "/" + uploadDir;
        }

        //create if the folder is not existed
        File fileSaveDir = new File(fullSavePath);

        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        //check size
        if (filePart.getSize() > maxSize) {
            request.setAttribute(field + "Error", label + " is too large");
            return null;
        }

        String fileName = UUID.randomUUID().toString() + Helper.getFileName(filePart);

        //absolute path to image
        String filePath = null;
        if (fileName != null && fileName.length() > 0) {
            filePath = fullSavePath + File.separator + fileName;
            // save to file
            filePart.write(filePath);
        }
        return uploadDir + "/" + fileName;

    }

    public static Date getDateParams(HttpServletRequest request, String field, String label) {
        String value = getStringParam(request, field, label, 8, 10, null);

        if (value == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            Date date = format.parse(value);
            return date;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
