package constants;

/**
 *
 * @author locnh
 */
public enum Message {

    // login
    LOGIN_ERROR_MESSAGE("Username or password is not correct"),
    // register
    EXISTED_EMAIL_MESSAGE("Email already existed"),
    CONFIRM_PASSWORD_ERROR_MESSAGE("Confirm password should be same with password"),
    REGISTER_SUCCESS_MESSAGE("Register successful"),
    // product
    ADD_TO_CARD_SUCCESS_MESSAGE("Add product to cart successful"),
    PRICE_ERROR_MESSAGE("Min price cannot greater than max price"),
    EMPTY_CART_MESSAGE("There is no product in your cart yet"),
    DULICATE_NAME_MESSAGE("This product's name is already existed"),
    NOT_ENOUGH_QUANTITY_MESSAGE("Products do not have enough quantity"),
    //order
    EMPTY_MESSAGE("There is no order yet"),
    //common
    INTERNAL_ERROR_TITLE("Something failed"),
    INTERNAL_ERROR_MESSAGE("Please try again later"),
    NOT_FOUND_ERROR_TITLE("Not found"),
    NOT_FOUND_ERROR_MESSAGE("The requested URL was not found on this server");

    private String content;

    private Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
