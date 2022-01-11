package utils;

import java.util.regex.Pattern;

public class Validator {

    public static String getEmail(String value) {
        Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");

        boolean ismatched = regex.matcher(value).matches();
        if (!ismatched) {
            return " is not correct format. Please enter a valid email.";
        }
        return "";
    }

    public static String getPhone(String value) {
        if ("".equals(value)) {
            return "";
        }
        Pattern regex = Pattern.compile("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$");

        boolean ismatched = regex.matcher(value).matches();
        if (!ismatched) {
            return " is not correct format. Please enter a valid phone number.";
        }
        return "";
    }

}
