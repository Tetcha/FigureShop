package constants;

/**
 *
 * @author locnh
 */
public enum Message {
    LOGIN_ERROR_MESSAGE("Username or password is not correct"),
    INTERNAL_ERROR_TITLE("Something failed"),
    INTERNAL_ERROR_MESSAGE("Please try again later"),
    SUCCESS_MESSAGE("Register successful");

    private String content;

    private Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
