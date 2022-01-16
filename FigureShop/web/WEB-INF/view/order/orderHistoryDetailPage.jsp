<%@page import="java.util.Locale" %>
<%@page import="orderitem.dtos.OrderItemDto" %>
<%@page import="java.util.ArrayList" %>
<%@page import="order.models.Order" %>
<%@page import="java.text.NumberFormat" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>History detail</title>
        <jsp:include page="../common/init.jsp"></jsp:include>
        </head>

        <body>
        <% Order currentOrder = (Order) request.getAttribute("order");
            ArrayList<OrderItemDto> orderItems
                    = (ArrayList<OrderItemDto>) request.getAttribute("orderItems");
            Locale vi = new Locale("vi", "VN");
            NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vi);
            request.setCharacterEncoding("UTF-8");
            String imageHead = "https://";
            String pattern = "product.hstatic.net";
        %>
        <div class="bg-white">
            <jsp:include page="../common/navbar.jsp"></jsp:include>
                <div class="max-w-3xl mx-auto px-4 py-16 sm:px-6 sm:pt-24 sm:pb-32 lg:px-8">
                    <div class="max-w-xl">
                        <h1 class="text-3xl font-extrabold tracking-tight text-gray-900">
                            Your detail
                        </h1>
                        <p class="mt-2 text-sm text-gray-500">
                            Check the status of recent orders, manage returns, and discover
                            similar products.
                        </p>
                    </div>
                    <div
                        class="bg-gray-100 mt-5 rounded-lg py-6 px-4 sm:px-6 sm:flex sm:items-center sm:justify-between sm:space-x-6 lg:space-x-8">
                        <dl
                            class="flex flex-wrap gap-4 divide-gray-200 space-y-6 text-sm text-gray-600 flex-auto sm:divide-y-0 sm:space-y-2 sm:grid sm:grid-cols-3 w-full  ">
                            <div class="flex justify-between sm:block">
                                <dt class="font-medium text-gray-900">Date</dt>
                                <dd class="sm:mt-1">
                                    <time datetime="2021-01-22">
                                    <%= currentOrder.getCreatedDate()%>
                                </time>
                            </dd>
                        </div>
                        <div class="flex justify-between pt-6 sm:block sm:pt-0">
                            <dt class="font-medium text-gray-900">Receiver's name</dt>
                            <dd class="sm:mt-1">
                                <%= currentOrder.getConsigneeName()%>
                            </dd>
                        </div>
                        <div class="flex justify-between pt-6 sm:block sm:pt-0">
                            <dt class="font-medium text-gray-900">Phone number</dt>
                            <dd class="sm:mt-1">
                                <%= currentOrder.getPhoneNumber()%>
                            </dd>
                        </div>
                        <div class="flex justify-between pt-6 sm:block sm:pt-0">
                            <dt class="font-medium text-gray-900">Address</dt>
                            <dd class="sm:mt-1">
                                <%= currentOrder.getAddress()%>
                            </dd>
                        </div>
                        <div class="flex justify-between pt-6 sm:block sm:pt-0 mt-5">
                            <dt class="font-medium text-gray-900">Total</dt>
                            <dd class="sm:mt-1">
                                <%= vndFormat.format(currentOrder.getTotalPrice())%>
                            </dd>
                        </div>
                    </dl>
                </div>
                <div class="mt-12 space-y-16 sm:mt-16">
                    <section aria-labelledby="4376-heading">
                        <div
                            class="space-y-1 md:flex md:items-baseline md:space-y-0 md:space-x-4">
                            <h2 id="4376-heading"
                                class="text-lg font-medium text-gray-900 md:flex-shrink-0">
                                Order #<%= currentOrder.getId()%>
                            </h2>
                            <jsp:include page="../components/status.jsp">
                                <jsp:param name="status"
                                value="<%= currentOrder.getStatus()%>" />
                            </jsp:include>
                        </div>

                        <!-- order history detail -->
                        <div
                            class="mt-6 -mb-6 flow-root border-t border-gray-200 divide-y divide-gray-200">
                            <%for (int i = 0; i < orderItems.size(); i++) {%>
                            <jsp:include
                                page="../components/orderHistoryDetailItem.jsp">
                                <jsp:param name="name"
                                value="<%= orderItems.get(i).getName()%>" />
                                <jsp:param name="category"
                                value="<%= orderItems.get(i).getName()%>" />
                                <jsp:param name="price"
                                value="<%= vndFormat.format(orderItems.get(i).getPrice())%>" />
                                <jsp:param name="quantity"
                                value="<%= orderItems.get(i).getQuantity()%>" />
                                <jsp:param name="avatar"
                                value="<%= orderItems.get(i).getImage().startsWith(pattern) ? imageHead + orderItems.get(i).getImage() : orderItems.get(i).getImage()%>" />
                            </jsp:include>
                            <%}%>

                            <!-- More products... -->
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </body>

</html>