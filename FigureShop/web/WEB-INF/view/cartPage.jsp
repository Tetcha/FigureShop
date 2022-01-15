<%@page import="constants.Router"%>
<%@page import="java.util.Locale"%>
<%@page import="user.models.User"%>
<%@page import="category.models.Category"%>
<%@page import="product.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="category.daos.CategoryDao"%>
<%@page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Your cart</title>
        <jsp:include page="./commonView/init.jsp"></jsp:include>
        </head>
        <body>
        <%
            String imageHead = "https://";
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
            if (products == null) {
                products = new ArrayList<Product>();
            }
            User user = (User) session.getAttribute("user");
            String userName = "";
            String userAddress = "";
            String userPhone = "";
            if (user != null) {
                if (user.getFullName() != null) {
                    userName = user.getFullName();
                }
                if (user.getAddress() != null) {
                    userAddress = user.getAddress();
                }
                if (user.getPhone() != null) {
                    userPhone = user.getPhone();
                }

            }
            Locale vi = new Locale("vi", "VN");
            NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vi);
            request.setCharacterEncoding("UTF-8");
        %>
        <jsp:include page="./commonView/navbar.jsp"></jsp:include>
            <div class="bg-white">
                <div
                    class="max-w-2xl mx-auto pt-16 pb-24 px-4 sm:px-6 lg:max-w-7xl lg:px-8"
                    >
                    <h1
                        class="text-3xl font-extrabold tracking-tight text-gray-900 sm:text-4xl"
                        >
                        Shopping Cart
                    </h1>
                    <div
                        class="mt-12 lg:grid lg:grid-cols-12 lg:gap-x-12 lg:items-start xl:gap-x-16"
                        >
                        <section aria-labelledby="cart-heading" class="lg:col-span-7">
                            <h2 id="cart-heading" class="sr-only">
                                Items in your shopping cart
                            </h2>

                            <ul
                                role="list"
                                class="border-t border-b border-gray-200 divide-y divide-gray-200"
                                >

                            <%for (int i = 0; i < products.size(); i++) {%>
                            <jsp:include page="./components/orderItem.jsp">
                                <jsp:param
                                    name="avatar"
                                value="<%=  imageHead + products.get(i).getImage()%>"
                                    />
                                <jsp:param name="name" value="<%= products.get(i).getName()%>" />
                                <jsp:param name="price" value="<%=vndFormat.format(products.get(i).getPrice())%>" />
                                <jsp:param name="category" value="<%= products.get(i).getCategoryId()%>" />
                                <jsp:param name="quantity" value="<%= products.get(i).getQuantity()%>" />
                                <jsp:param name="index" value="<%= i%>" />
                                <jsp:param name="id" value="<%= products.get(i).getId()%>" />
                            </jsp:include>
                            <%}%>
                        </ul>
                    </section>

                    <!-- Order summary -->
                    <section
                        aria-labelledby="summary-heading"
                        class="mt-16 bg-gray-50 rounded-lg px-4 py-6 sm:p-6 lg:p-8 lg:mt-0 lg:col-span-5"
                        >
                        <h2 id="summary-heading" class="text-lg font-medium text-gray-900">
                            Order summary
                        </h2>

                        <dl class="mt-6 space-y-6">
                            <% float total = 0; %>
                            <%for (int i = 0; i < products.size(); i++) {%>
                            <% total = total + (float) products.get(i).getPrice();%>
                            <div class="flex items-start justify-between">
                                <dt class="text-sm text-gray-600"><%= products.get(i).getName()%></dt>
                                <dd class="text-sm font-medium text-gray-900"><%=vndFormat.format(products.get(i).getPrice())%></dd>
                            </div>
                            <%}%>
                            <div class="flex items-start justify-between">
                                <dt class="text-sm text-gray-600 font-semibold">Total</dt>
                                <dd class="text-sm font-medium text-gray-900"><%=vndFormat.format(total)%></dd>
                            </div>
                        </dl>
                        <div class="relative mt-5">
                            <div class="absolute inset-0 flex items-center" aria-hidden="true">
                                <div class="w-full border-t border-gray-300"></div>
                            </div>
                            <div class="relative flex justify-center">
                                <span class="px-2 bg-gray-50 text-sm text-gray-500">
                                    Shipment detail
                                </span>
                            </div>
                        </div>
                        <form method="post" action="<%= Router.CHECKOUT_CONTROLLER%>" class="flex flex-col">
                            <div class="mt-5">
                                <label
                                    for="email"
                                    class="block text-sm font-medium text-gray-700"
                                    >
                                    Address
                                </label>
                                <div class="mt-1">
                                    <input
                                        id="address"
                                        name="address"
                                        placeholder="<%= userAddress%>"
                                        type="text"
                                        required
                                        value ="<%= userAddress%>"
                                        class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                        />
                                </div>
                            </div>
                            <div class="mt-5">
                                <label
                                    for="phone"
                                    class="block text-sm font-medium text-gray-700"
                                    >
                                    Phone
                                </label>
                                <div class="mt-1">
                                    <input
                                        id="phone"
                                        name="phone"
                                        placeholder="<%= userPhone%>"
                                        type="text"
                                        required
                                        value ="<%= userPhone%>"
                                        class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                        />
                                </div>
                            </div>
                            <div class="mt-5">
                                <label
                                    for="consigneeName"
                                    class="block text-sm font-medium text-gray-700"
                                    >
                                    Consignee name
                                </label>
                                <div class="mt-1">
                                    <input
                                        id="consigneeName"
                                        name="consigneeName"
                                        placeholder="<%= userName%>"
                                        type="text"
                                        required
                                        value="<%= userName%>"
                                        class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                        />
                                </div>
                            </div>
                             <div class="mt-6">
                            <button
                                type="submit"
                                class="w-full bg-indigo-600 border border-transparent rounded-md shadow-sm py-3 px-4 text-base font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500"
                                >
                                Checkout
                            </button>
                        </div>
                        </form>
                       
                    </section>
                    </form>
                </div>
            </div>
    </body>
</html>
