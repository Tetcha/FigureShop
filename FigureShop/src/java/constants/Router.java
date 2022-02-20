package constants;

public class Router {

    // user
    public static final String LOGIN_CONTROLLER = "login";
    public static final String LOGIN_PAGE = "/WEB-INF/view/auth/loginPage.jsp";
    public static final String LOGOUT_CONTROLLER = "logout";
    public static final String REGISTER_CONTROLLER = "register";
    public static final String REGISTER_PAGE = "/WEB-INF/view/auth/registerPage.jsp";

    // product
    public static final String PRODUCT_DETAIL_PAGE = "WEB-INF/view/product/productDetailPage.jsp";
    public static final String PRODUCT_DETAIL_CONTROLLER = "product";
    public static final String PRODUCT_FILTER_CONTROLLER = "filter";
    public static final String PRODUCT_FILTER_PAGE = "WEB-INF/view/product/productFilter.jsp";
    public static final String CART_PRODUCT_QUANTITY_CONTROLLER = "changeQuantity";
    public static final String CART_REMOVE_PRODUCT_CONTROLLER = "remove";
    public static final String CART_CONTROLLER = "cart";
    public static final String CART_PAGE = "WEB-INF/view/cart/cartPage.jsp";

    // order
    public static final String ORDER_HISTORY_CONTROLLER = "orders";
    public static final String ORDER_HISTORY_PAGE = "WEB-INF/view/order/orderHistoryPage.jsp";
    public static final String ORDER_HISTORY_DETAIL_PAGE = "WEB-INF/view/order/orderHistoryDetailPage.jsp";
    public static final String ORDER_HISTORY_DETAIL_CONTROLLER = "orderHistory";
    public static final String CHECKOUT_CONTROLLER = "checkout";

    // common
    public static final String ERROR = "/WEB-INF/view/common/errorPage.jsp";
    public static final String HOME_PAGE = "/WEB-INF/view/home/homePage.jsp";
    public static final String HOME_CONTROLLER = "home";

    // admin
    public static final String ADMIN_ORDERS_CONTROLLER = "viewOrders";
    public static final String ADMIN_ORDERS_PAGE = "WEB-INF/view/admin/order/adminOrderPageMap.jsp";
    public static final String ADMIN_UPDATE_ORDER_CONTROLLER = "updateStatus";

    public static final String ADMIN_USER_CONTROLLER = "adminUser";
    public static final String ADMIN_USER_PAGE = "WEB-INF/view/admin/user/adminUserPageMap.jsp";

    public static final String ADMIN_ADD_PRODUCT_CONTROLLER = "addProduct";
    public static final String ADMIN_ADD_PRODUCT_PAGE = "WEB-INF/view/admin/form/addProductPageMap.jsp";

    public static final String ADMIN_UPDATE_PRODUCT_CONTROLLER = "updateProduct";
    public static final String ADMIN_UPDATE_PRODUCT_PAGE = "WEB-INF/view/admin/form/updateProductPageMap.jsp";

    public static final String ADMIN_PRODUCT_PAGE = "WEB-INF/view/admin/product/adminProductPageMap.jsp";
    public static final String ADMIN_PRODUCT_CONTROLLER = "adminProduct";

    public static final String ADMIN_DELETE_PRODCUT_CONTROLLER = "deleteProduct";

}
