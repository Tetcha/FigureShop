<%@page import="java.util.Locale"%>
<%@page import="order.models.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Oder history</title>
        <jsp:include page="./commonView/init.jsp"/>
        </head>
        <body>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
            Locale vi = new Locale("vi", "VN");
            NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vi);
            request.setCharacterEncoding("UTF-8");
        %>
        <div class="flex flex-col w-screen h-screen">
            <jsp:include page="./commonView/navbar.jsp"/>
                <div class="bg-white p-10 flex-1">
                    <h2 class="font-bold text-2xl mb-5">Order history</h2>
                    <ul
                        role="list"
                        class="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3"
                        >
                    <%for (int i = 0; i < orders.size(); i++) {%>
                        <jsp:include page="./components/orderHistoryItem.jsp">
                            <jsp:param name="id" value="<%= orders.get(i).getId()%>" />
                            <jsp:param name="totalPrice" value="<%= orders.get(i).getTotalPrice()%>" />
                            <jsp:param name="address" value="<%= orders.get(i).getAddress()%>" />
                            <jsp:param name="phone" value="<%= orders.get(i).getPhoneNumber()%>" />
                            <jsp:param name="status" value="<%= orders.get(i).getStatus()%>" />
                        </jsp:include>
                    <%}%>
                </ul>
            </div>
        </div>
    </body>
</html>
