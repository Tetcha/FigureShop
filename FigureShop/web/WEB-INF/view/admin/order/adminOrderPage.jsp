<%@page import="orderitem.dtos.OrderItemDto"%>
<%@page import="order.models.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="constants.Router"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String fromDate = (String) request.getAttribute("fromDate");
    String toDate = (String) request.getAttribute("toDate");
    int currentPage = (Integer) request.getAttribute("page");
    int maxPage = (int) request.getAttribute("maxPage");
    ArrayList<OrderItemDto> currentShow = (ArrayList<OrderItemDto>) request.getAttribute("currentShow");
    Order currentOrderShow = (Order) request.getAttribute("currentOrderShow");
    ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
    // handle on login
   
    session.setAttribute("prevUrl", request.getQueryString());
    
%>
<div class="flex p-5 gap-5 h-screen overflow-hidden">
    <div class="flex flex-col max-w-3xl">
        <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
            <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                <form method="get" action="<%= Router.ADMIN_ORDERS_CONTROLLER%>" class="flex flex-row gap-10 mb-5">
                    <div class="flex flex-col gap-3">
                        <label for="fromDate" class="capitalize font-semibold">from</label>
                        <input value="<%= fromDate%>" name="fromDate" type="date" class="rounded-sm" />
                    </div>
                    <div class="flex flex-col gap-3">
                        <label for="toDate" class="capitalize font-semibold">to</label>
                        <input value="<%= toDate%>" name="toDate" type="date" class="rounded-sm" />
                    </div>
                    <input name="page" value="1" type="number" class="hidden" />
                    <div class="flex flex-col justify-end">
                        <button
                            type="submit"
                            class="px-5 py-3 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                            >
                            Search
                        </button>
                    </div>
                </form>
                <div
                    class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg"
                    >
                    <table class="min-w-full divide-y divide-gray-200">
                        <thead class="bg-gray-50">
                            <tr>
                                <th
                                    scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                    >
                                    Name
                                </th>
                                <th
                                    scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                    >
                                    Date
                                </th>
                                <th
                                    scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                    >
                                    Total price
                                </th>
                                <th
                                    scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                    >
                                    Status
                                </th>
                                <th scope="col" class="relative px-6 py-3">
                                    <span class="sr-only">Edit</span>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Odd row -->
                            <%
                                String bgWhite = "bg-white";
                                String bgGray = "bg-gray-200";
                            %>
                            <%for (int i = 0; i < orders.size(); i++) {%>
                            <tr class="<%= i % 2 == 0 ? bgWhite : bgGray%>">
                                <td
                                    class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"
                                    >
                                    <%= orders.get(i).getConsigneeName()%>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    <%= orders.get(i).getCreatedDate()%>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    <%= orders.get(i).getTotalPrice()%>đ
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    <jsp:include page="../../components/status.jsp">
                                        <jsp:param name="status" value="<%= orders.get(i).getStatus()%>"/>
                                    </jsp:include>
                                </td>
                                <td
                                    class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"
                                    >
                                    <a href="<%= Router.ADMIN_ORDERS_CONTROLLER%>?fromDate=<%= fromDate%>&toDate=<%= toDate%>&page=<%= currentPage%>&currentShow=<%= orders.get(i).getId()%>" class="text-indigo-600 hover:text-indigo-900"
                                       >Edit</a
                                    >
                                </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>

                </div>
                <jsp:include page="./orderPagination.jsp"></jsp:include>   
                </div>
            </div>
        </div>
        <!-- summary -->
        <div class="flex-1 overflow-auto">
            <div class="overflow-y-auto" role="dialog" aria-modal="true">
                <div class="flex min-h-screen text-center sm:block" style="font-size: 0">
                    <div
                        class="flex text-base text-left transform transition w-full sm:inline-block max-w-3xl sm:align-middle"
                        >
                        <form
                            action="<%= Router.ADMIN_UPDATE_ORDER_STATUS_CONTROLLER%>"
                        method="GET"
                        class="w-full relative flex flex-col bg-white overflow-hidden sm:pb-6 sm:rounded-lg pt-5"
                        >
                        <div class="flex items-center justify-between px-4 sm:px-6 lg:px-8">
                            <h2 class="text-lg font-medium text-gray-900">Shopping Cart</h2>
                        </div>

                        <section aria-labelledby="cart-heading">
                            <h2 id="cart-heading" class="sr-only">
                                Items in your shopping cart
                            </h2>

                            <ul
                                role="list"
                                class="divide-y divide-gray-200 px-4 sm:px-6 lg:px-8"
                                >
                                <%
                                    float totalPrice = 0;
                                %>
                                <%for (int i = 0; i < currentShow.size(); i++) {%>
                                <%
                                    OrderItemDto item = currentShow.get(i);
                                    totalPrice += item.getPrice() * item.getQuantity();
                                %>
                                <li class="py-8 flex text-sm sm:items-center">
                                    <img
                                        src="https://<%= item.getImage()%>"
                                        alt="Front of zip tote bag with white canvas, black canvas straps and handle, and black zipper pulls."
                                        class="flex-none w-20 h-1w-20 rounded-lg border border-gray-200"
                                        />
                                    <div
                                        class="ml-4 flex-auto grid gap-y-3 gap-x-5 grid-rows-1 grid-cols-1 items-start sm:ml-6 sm:flex sm:gap-0 sm:items-center"
                                        >
                                        <div class="flex-auto row-end-1 sm:pr-6">
                                            <h3 class="font-medium text-gray-900">
                                                <a href="#"><%= item.getName()%></a>
                                                <span class="text-gray-500" >x<%= item.getQuantity()%></span>
                                            </h3>
                                        </div>
                                        <p
                                            class="row-end-2 row-span-2 font-medium text-gray-900 sm:ml-6 sm:order-1 sm:flex-none sm:w-1/3 sm:text-right"
                                            >
                                            <%= item.getPrice()%>đ
                                        </p>
                                    </div>
                                </li>
                                <%}%>

                                <!-- More products... -->
                            </ul>
                        </section>

                        <section
                            aria-labelledby="summary-heading"
                            class="mt-auto sm:px-6 lg:px-8"
                            >
                            <div class="bg-gray-200 p-6 sm:p-8 sm:rounded-lg">
                                <h2 id="summary-heading" class="sr-only">Order summary</h2>
                                <div class="flow-root">
                                    <dl class="-my-4 text-sm divide-y divide-gray-200">
                                        <div class="py-4 flex items-center justify-between">
                                            <dt class="text-base font-medium text-gray-900">
                                                Order total
                                            </dt>
                                            <dd class="text-base font-medium text-gray-900">
                                                <%= totalPrice%>đ
                                            </dd>
                                        </div>
                                    </dl>
                                </div>
                            </div>
                        </section>
                        <!-- devide line -->
                        <div class="relative py-3">
                            <div
                                class="absolute inset-0 flex items-center"
                                aria-hidden="true"
                                >
                                <div class="w-full border-t border-gray-300"></div>
                            </div>
                            <div class="relative flex justify-center">
                                <span class="px-2 bg-white text-sm text-gray-500">
                                    Order details
                                </span>
                            </div>
                        </div>
                        <!-- shipment detail -->
                        <div class="flex flex-col gap-5 px-8">
                            <!-- email field -->
                            <div class="">
                                <label
                                    for="consigneeName"
                                    class="block text-sm font-medium text-gray-700"
                                    >Email</label
                                >
                                <div class="mt-1">
                                    <input
                                        type="text"
                                        name="consigneeName"
                                        id="consigneeName"
                                        value="<%= currentOrderShow.getConsigneeName()%>"
                                        class="shadow-sm w-full focus:ring-indigo-500 focus:border-indigo-500 block sm:text-sm border-gray-300 rounded-md"
                                        placeholder=""
                                        />
                                </div>
                            </div>
                            <!-- address field -->
                            <div class="">
                                <label
                                    for="address"
                                    class="block text-sm font-medium text-gray-700"
                                    >Address</label
                                >
                                <div class="mt-1">
                                    <input
                                        type="text"
                                        name="address"
                                        id="address"
                                        value="<%= currentOrderShow.getAddress()%>"
                                        class="shadow-sm focus:ring-indigo-500 focus:border-indigo-500 block w-full sm:text-sm border-gray-300 rounded-md"
                                        placeholder=""
                                        />
                                </div>
                            </div>
                            <!-- phone number field -->
                            <div class="">
                                <label
                                    for="phone"
                                    class="block text-sm font-medium text-gray-700"
                                    >Phone number</label
                                >
                                <div class="mt-1">
                                    <input
                                        type="text"
                                        name="phone"
                                        id="phone"
                                        value="<%= currentOrderShow.getPhoneNumber()%>"
                                        class="shadow-sm focus:ring-indigo-500 focus:border-indigo-500 block w-full sm:text-sm border-gray-300 rounded-md"
                                        placeholder=""
                                        />
                                </div>
                            </div>
                            <input
                                type="text"
                                name="id"
                                value="<%= currentOrderShow.getId()%>"
                                class="hidden"
                                />
                            <!-- status field -->
                            <div class="">
                                <label
                                    for="status"
                                    class="block text-sm font-medium text-gray-700"
                                    >Status</label
                                >
                                <select
                                    id="status"
                                    name="status"
                                    class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md"
                                    >

                                    <c:choose>
                                        <c:when test="<%= currentOrderShow.getStatus() == 0%>">
                                            <option  selected>Waiting</option>
                                        </c:when> 
                                        <c:otherwise>
                                            <option >Waiting</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="<%= currentOrderShow.getStatus() == 1%>">
                                            <option  selected>Confirm</option>
                                        </c:when> 
                                        <c:otherwise>
                                            <option >Confirm</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="<%= currentOrderShow.getStatus() == 2%>">
                                            <option  selected>Done</option>
                                        </c:when> 
                                        <c:otherwise>
                                            <option >Done</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="<%= currentOrderShow.getStatus() == 3%>">
                                            <option  selected>Cancel</option>
                                        </c:when> 
                                        <c:otherwise>
                                            <option >Cancel</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                        <div class="mt-8 flex justify-end px-4 sm:px-6 lg:px-8">
                            <button
                                type="submit"
                                class="bg-indigo-600 border border-transparent rounded-md shadow-sm py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500"
                                >
                                Update payment
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
