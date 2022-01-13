package constants;

public class Router {

    // user
    public static final String LOGIN_CONTROLLER = "login";
    public static final String LOGIN_PAGE = "/WEB-INF/view/loginPage.jsp";
    public static final String LOGOUT_CONTROLLER = "logout";
    public static final String REGISTER_CONTROLLER = "register";
    public static final String REGISTER_PAGE = "/WEB-INF/view/registerPage.jsp";

    // product
    public static final String PRODUCT_DETAIL_PAGE = "WEB-INF/view/productDetailPage.jsp";
    public static final String PRODUCT_DETAIL_CONTROLLER = "product";
    public static final String PRODUCT_FILTER_CONTROLLER = "filter";
    public static final String PRODUCTS_PAGE = "WEB-INF/view/products.jsp";
    public static final String CART_PRODUCT_QUANTITY_CONTROLLER = "changeQuantity";
    public static final String CART_REMOVE_PRODUCT_CONTROLLER = "remove";
    public static final String CART_CONTROLLER = "cart";
    public static final String CART_PAGE = "WEB-INF/view/cartPage.jsp";

    // order
    public static final String ORDER_HISTORY_CONTROLLER = "orders";
    public static final String ORDER_HISTORY_PAGE = "WEB-INF/view/orderHistoryPage.jsp";
    public static final String ORDER_HISTORY_DETAIL_PAGE = "WEB-INF/view/orderHistoryDetailPage.jsp";
    public static final String ORDER_HISTORY_DETAIL_CONTROLLER = "orderHistory";
    public static final String CHECKOUT_CONTROLLER = "checkout";

    // common
    public static final String ERROR = "/WEB-INF/view/commonView/errorPage.jsp";
    public static final String HOME_PAGE = "/WEB-INF/view/homePage.jsp";
    public static final String HOME_CONTROLLER = "home";

    // jsp file mapping
    public static final String ADD_PRODUCT_PAGE = "WEB-INF/view/addNewProductPage.jsp";
    public static final String UPDATE_PRODUCT_PAGE = "WEB-INF/view/updateProductPage.jsp";
    public static final String ADD_CATEGORY_PAGE = "WEB-INF/view/addCategoryPage.jsp";
    public static final String ADMIN_ORDER_PAGE = "WEB-INF/view/adminOrderPage.jsp";
    public static final String ADMIN_ORDERITEM_PAGE = "WEB-INF/view/adminOrderItem.jsp";
    public static final String CATEGORY_SHOWCASE_PAGE = "WEB-INF/view/categoryShowcasePage.jsp";
    public static final String ADMIN_VIEW_PRODUCT_PAGE = "WEB-INF/view/adminViewProduct.jsp";

    // router mapping
    public static final String ADD_PRODUCT_CONTROLLER = "addProduct";
    public static final String UPDATE_PRODUCT_CONTROLLER = "updateProduct";
    public static final String ADD_CATEGORY_CONTROLLER = "addCategory";
    public static final String SHOW_PRODUCT_IN_CATEGORY_CONTROLLER = "categoryProducts";
    public static final String CANCEL_ORDER_CONTROLLER = "cancelOrder";
    public static final String ADMIN_ORDER_CONTROLLER = "adminOrder";
    public static final String ORDER_STATUS_CONTROLLER = "orderStatus";
    public static final String ADMIN_VIEW_PRODUCT_CONTROLLER = "AdminViewProduct";
}
