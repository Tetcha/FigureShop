<%@page import="java.util.Locale"%>
<%@page import="product.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
    String imageHead = "https://";
    String pattern = "product.hstatic.net";
    Locale vi = new Locale("vi", "VN");
    NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vi);
%>

<div class="bg-white flex-1 h-screen">
    <jsp:include page="../../common/filter.jsp">
        <jsp:param name="type" value="1" />
    </jsp:include>
    <div class="max-w-7xl mx-auto px-9">
        <div class="flex flex-col">
            <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
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
                                        Quantity
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                        >
                                        Price
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                                        >
                                        Category
                                    </th>
                                    <th scope="col" class="relative px-6 py-3">
                                        <span class="sr-only">Edit</span>
                                    </th>
                                </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200">
                                <%for (int i = 0; i < products.size(); i++) {%>
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="flex items-center">
                                            <div class="flex-shrink-0 h-10 w-10">
                                                <img
                                                    class="h-10 w-10 rounded-full"
                                                    src="<%= products.get(i).getImage().startsWith(pattern) ? imageHead + products.get(i).getImage() : products.get(i).getImage()%>"
                                                    alt=""
                                                    />
                                            </div>
                                            <div class="ml-4">
                                                <div class="text-sm font-medium text-gray-900">
                                                    <%= products.get(i).getName()%>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                            <diRegional Paradigm Technicianv class="text-sm text-gray-900">
                                <%= products.get(i).getQuantity()%>
                                </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <%=vndFormat.format(products.get(i).getPrice())%>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    <%= products.get(i).getCategoryId()%>
                                </td>
                                <td
                                    class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"
                                    >
                                    <a href="#" class="text-indigo-600 hover:text-indigo-900"
                                       >Edit</a
                                    >
                                </td>
                                </tr>
                                <%}%>
                                <!-- More people... -->
                                </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../product/adminProductPagination.jsp"></jsp:include>
    </div>
</div>
