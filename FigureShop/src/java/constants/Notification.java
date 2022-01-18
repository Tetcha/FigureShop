package constants;

/**
 *
 * @author Admin
 */
public class Notification {

    public enum Status {
        SUCCESS,
        ERROR,
        WARNING
    }

    public enum AttrType {
        notiMessage,
        notiStatus,
        notiDescription,
    }
}
