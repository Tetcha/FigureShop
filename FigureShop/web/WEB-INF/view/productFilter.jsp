<%@page import="java.util.Locale" %>
<%@page import="constants.Router" %>
<%@page import="java.util.ArrayList" %>
<%@page import="product.models.Product" %>
<%@page import="category.daos.CategoryDao" %>
<%@page import="java.text.NumberFormat" %>
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
        <jsp:include page="./commonView/navbar.jsp"></jsp:include>
            <div class="mt-5">
            <jsp:include page="./welcomeFilter.jsp"></jsp:include>
            </div>

        <c:forEach var="product" items="${requestScope.products}">
        <div>${product.getName()}</div>
    </c:forEach>
    <% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
        Locale vi = new Locale("vi", "VN");
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vi);
    %>

    <div class="bg-white">
        <div class="max-w-2xl mx-auto py-6 px-4 sm:py-7 sm:px-6 lg:max-w-7xl lg:px-8">
            <h2 class="text-2xl font-extrabold tracking-tight text-gray-900">Result :</h2>

            <div
                class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">

                <%for (int i = 0; i < products.size(); i++) {%>


                <div class="group relative">
                    <div
                        class="w-full min-h-80 bg-gray-200 aspect-w-1 aspect-h-1 rounded-md overflow-hidden group-hover:opacity-75 lg:h-80 lg:aspect-none">
                        <a
                            href="<%=Router.PRODUCT_DETAIL_CONTROLLER%>?id=<%=products.get(i).getId()%>">
                            <img src="https://<%= products.get(i).getImage()%>"
                                 alt="Front of men&#039;s Basic Tee in black."
                                 class="w-full h-full object-center object-cover lg:w-full lg:h-full">
                        </a>
                    </div>
                    <div class="mt-4 flex justify-between">
                        <div>
                            <h3 class="text-sm text-gray-700">
                                <a
                                    href="<%=Router.PRODUCT_DETAIL_CONTROLLER%>?id=<%=products.get(i).getId()%>">
                                    <span aria-hidden="true"
                                          class="absolute inset-0"></span>
                                    <%= products.get(i).getName()%>
                                </a>
                            </h3>
                            <p class="mt-1 text-sm text-gray-500">
                                <%= products.get(i).getCategoryId()%>
                            </p>
                            <p class="text-sm font-medium text-gray-900">$
                                <%=products.get(i).getPrice()%>
                            </p>
                        </div>

                    </div>
                </div>
                <%}%>
            </div>
            <div class="w-full flex justify-end mt-6">
                <jsp:include page="./components/pagination.jsp"></jsp:include>
            </div>
        </div>
    </div>

</body>

</html>