package constants;

/**
 *
 * @author locnh
 */
public enum Message {

    // login
    LOGIN_ERROR_MESSAGE("Username or password is not correct"),
    NOT_LOGIN_MESSAGE("Permission Denied"),
    NOT_LOGIN_DESCRIPTION("Action is not allow, please login first"),
    // register
    EXISTED_EMAIL_MESSAGE("Email already existed"),
    CONFIRM_PASSWORD_ERROR_MESSAGE("Confirm password should be same with password"),
    REGISTER_SUCCESS_MESSAGE("Register successful"),
    // product
    ADD_PRODUCT_SUCCESS_DESCRIPTION("Add product successful"),
    UPDATE_PRODUCT_SUCCESS_DESCRIPTION("Update product successful"),
    ADD_TO_CARD_SUCCESS_MESSAGE("Add product to cart successful"),
    PRICE_ERROR_MESSAGE("Min price cannot greater than max price"),
    EMPTY_CART_MESSAGE("There is no product in your cart yet"),
    DULICATE_NAME_MESSAGE("This product's name is already existed"),
    NOT_ENOUGH_QUANTITY_MESSAGE("Products do not have enough quantity"),
    DELETE_ERROR_MESSAGE("Delete fail"),
    DELETE_SUCCESS("Delete success"),
    DELETE_ERROR_DESCRIPTION("This product has already existed in some orders"),
    //order
    UPDATE_STATUS_SUCCESS_DESCRIPTION("Update order's status successful"),
    EMPTY_MESSAGE("There is no order yet"),
    CHECKOUT_SUCCESS_DESCRIPTION("Checkout successful"),
    //common
    SUCCESS_MESSAGE("Success"),
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
