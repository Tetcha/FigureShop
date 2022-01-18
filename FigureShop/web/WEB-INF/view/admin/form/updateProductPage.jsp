<%@page import="constants.Router"%>
<%@page import="product.models.Product"%>
<%@page import="category.daos.CategoryDao"%>
<%@page import="category.models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CategoryDao categoryDao = new CategoryDao();
    ArrayList<Category> categoryList = categoryDao.getAllCategory();
    Product product = (Product) request.getAttribute("product");
    String imageHead = "https://";
    String pattern = "product.hstatic.net";
    request.setCharacterEncoding("UTF-8");
%>
<div class="p-10">
    <form method="post" enctype="multipart/form-data" action="<%= Router.ADMIN_UPDATE_PRODUCT_CONTROLLER%>" class="space-y-8 divide-y divide-gray-200">
        <div class="space-y-8 divide-y divide-gray-200 sm:space-y-5">
            <div>
                <div>
                    <h3 class="text-lg leading-6 font-medium text-gray-900">
                        Update product
                    </h3>
                    <p class="mt-1 max-w-2xl text-sm text-gray-500">
                        This information will be displayed publicly so be careful what you
                        share.
                    </p>
                </div>

                <div class="mt-6 sm:mt-5 space-y-6 sm:space-y-5">
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="name"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Name
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <input
                                type="text"
                                name="name"
                                id="name"
                                value="<%= product.getName()%>"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="quantity"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Quantity
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <input
                                min="0"
                                type="number"
                                name="quantity"
                                value="<%= product.getQuantity()%>"
                                id="quantity"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                        </div>
                    </div>
                    <input
                        type="text"
                        name="id"
                        value="<%= product.getId()%>"
                        class="hidden"
                        />
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="price"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Price
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <input
                                min="0"
                                type="number"
                                name="price"
                                value="<%= product.getPrice()%>"
                                id="price"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="description"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Description
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <textarea
                                id="description"
                                name="description"
                                rows="5"
                                class="max-w-lg shadow-sm block w-full focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm border border-gray-300 rounded-md"
                                ><%= product.getDescription()%></textarea>
                            <p class="mt-2 text-sm text-gray-500">
                                Write a few sentences about product.
                            </p>
                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="country"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Category
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <select
                                id="type"
                                name="type"
                                class="max-w-lg block focus:ring-indigo-500 focus:border-indigo-500 w-full shadow-sm sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                >
                                <%for (int i = 0; i < categoryList.size(); i++) {%>
                                <c:choose>
                                    <c:when test="<%= categoryList.get(i).getId().equals(product.getCategoryId())%>">
                                        <option selected value="<%= categoryList.get(i).getId()%>"><%= categoryList.get(i).getName()%></option>
                                    </c:when>    
                                    <c:otherwise>
                                        <option value="<%= categoryList.get(i).getId()%>"><%= categoryList.get(i).getName()%></option>
                                    </c:otherwise>
                                </c:choose>

                                <%}%>
                            </select>

                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="image"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Cover photo
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <div
                                class="max-w-lg flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md"
                                >
                                <div class="space-y-1 text-center">
                                    <svg
                                        class="mx-auto h-12 w-12 text-gray-400"
                                        stroke="currentColor"
                                        fill="none"
                                        viewBox="0 0 48 48"
                                        aria-hidden="true"
                                        >
                                    <path
                                        d="M28 8H12a4 4 0 00-4 4v20m32-12v8m0 0v8a4 4 0 01-4 4H12a4 4 0 01-4-4v-4m32-4l-3.172-3.172a4 4 0 00-5.656 0L28 28M8 32l9.172-9.172a4 4 0 015.656 0L28 28m0 0l4 4m4-24h8m-4-4v8m-12 4h.02"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        />
                                    </svg>
                                    <div class="flex text-sm text-gray-600">
                                        <label
                                            for="image"
                                            class="relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500"
                                            >
                                            <span>Upload a file</span>
                                            <input
                                                id="imageInputFile"
                                                name="image"
                                                type="file"
                                                class="sr-only"
                                                />
                                        </label>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <img class="w-40" src="<%= product.getImage().startsWith(pattern) ? imageHead + product.getImage() : product.getImage()%>"  id="imagePreview"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="pt-5">
            <div class="flex justify-end">
                <button
                    type="submit"
                    class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
                    Add product to shop
                </button>
            </div>
        </div>
    </form>
</div>
