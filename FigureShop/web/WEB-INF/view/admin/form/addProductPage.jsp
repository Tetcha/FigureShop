<%@page import="constants.Router" %> 
<%@page import="category.daos.CategoryDao"%> 
<%@page import="category.models.Category" %> 
<%@page import="java.util.ArrayList" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%      CategoryDao categoryDao = new CategoryDao();
    ArrayList<Category> categoryList = categoryDao.getAllCategory();
    request.setCharacterEncoding("UTF-8");
    String imageHead = "https://";
    String pattern = "product.hstatic.net";
    String preImage = (String) request.getAttribute("prevImage");
%>

<div class="p-10">
    <form
        action="<%=Router.ADMIN_ADD_PRODUCT_CONTROLLER%>"
        enctype="multipart/form-data"
        method="POST"
        class="space-y-8 divide-y divide-gray-200"
        >
        <div class="space-y-8 divide-y divide-gray-200 sm:space-y-5">
            <div>
                <div>
                    <h3 class="text-lg leading-6 font-medium text-gray-900">
                        Add new product
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
                                value="${requestScope.name}"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                            <p class="text-sm text-left text-red-600">
                                ${requestScope.nameError}
                            </p>
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
                                type="number"
                                name="quantity"
                                id="quantity"
                                value="${requestScope.quantity}"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                            <p class="text-sm text-left text-red-600">
                                ${requestScope.quantityError}
                            </p>
                        </div>
                    </div>
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
                                type="number"
                                name="price"
                                id="price"
                                value="${requestScope.price}"
                                class="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                />
                            <p class="text-sm text-left text-red-600">
                                ${requestScope.priceError}
                            </p>
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
                                rows="3"
                                class="max-w-lg shadow-sm block w-full focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm border border-gray-300 rounded-md"
                                >${requestScope.description}</textarea
                            >
                            <p class="text-sm text-left text-red-600">
                                ${requestScope.descriptionError}
                            </p>
                        </div>
                    </div>
                    <div
                        class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5"
                        >
                        <label
                            for="category"
                            class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2"
                            >
                            Category
                        </label>
                        <div class="mt-1 sm:mt-0 sm:col-span-2">
                            <select
                                id="category"
                                name="category"
                                autocomplete="category"
                                class="max-w-lg block focus:ring-indigo-500 focus:border-indigo-500 w-full shadow-sm sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                                >
                                <%for (int i = 0; i < categoryList.size(); i++) {%>
                                <option value="<%= categoryList.get(i).getId()%>">
                                    <%= categoryList.get(i).getName()%>
                                </option>
                                <%}%>
                            </select>
                            <p class="text-sm text-left text-red-600">
                                ${requestScope.categoryError}
                            </p>
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
                                            for="imageInputFile"
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
                                    <input
                                        id="defaultImage"
                                        name="prevImage"
                                        value="<%= preImage%>"
                                        type="text"
                                        class="hidden"
                                        />
                                </div>
                            </div>
                            <p id="imageError" class="text-sm text-left text-red-600">
                                ${requestScope.imageError}
                            </p>
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
                            <img class="w-40" id="imagePreview" />
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
</div></Category
>
