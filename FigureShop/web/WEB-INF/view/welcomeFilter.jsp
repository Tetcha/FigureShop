<%@page import="category.daos.CategoryDao" %>
    <%@page import="category.models.Category" %>
        <%@page import="java.util.ArrayList" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <%@page contentType="text/html" pageEncoding="UTF-8" %>
                    <% CategoryDao categoryDao=new CategoryDao(); ArrayList<Category> categoryList =
                        categoryDao.getAllCategory();

                        %>

                        <div class="bg-white">
                            <div class="max-w-7xl mx-auto py-5 px-4 sm:px-6 lg:px-8">
                                <div class="sm:flex sm:items-baseline sm:justify-between">
                                    <h2 class="text-2xl font-extrabold tracking-tight text-gray-900">
                                        Search product :
                                    </h2>
                                </div>
                                <div class="flex flex-col">
                                    <div class="flex mt-5 gap-10">
                                        <div>
                                            <label for="from" class="block text-sm font-medium text-gray-700">From
                                                price</label>
                                            <div class="mt-1 relative rounded-md shadow-sm">
                                                <input type="text" name="from" id="from"
                                                    class="focus:ring-indigo-500 focus:border-indigo-500 block w-full pl-2 pr-2 sm:text-sm border-gray-300 rounded-md"
                                                    placeholder="0.00" aria-describedby="price-currency" />
                                                <div
                                                    class="absolute inset-y-0 right-0 pr-3 flex items-center pointer-events-none">
                                                    <span class="text-gray-500 sm:text-sm" id="price-currency">đ
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <label for="to" class="block text-sm font-medium text-gray-700">To
                                                price</label>
                                            <div class="mt-1 relative rounded-md shadow-sm">
                                                <input type="text" name="to" id="to"
                                                    class="focus:ring-indigo-500 focus:border-indigo-500 block w-full pl-2 pr-2 sm:text-sm border-gray-300 rounded-md"
                                                    placeholder="0.00" aria-describedby="price-currency" />
                                                <div
                                                    class="absolute inset-y-0 right-0 pr-3 flex items-center pointer-events-none">
                                                    <span class="text-gray-500 sm:text-sm" id="price-currency">đ
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <label for="category"
                                                class="block text-sm font-medium text-gray-700">Category</label>
                                            <select id="category" name="category"
                                                class="mt-1 block w-52 pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md">
                                                <c:forEach items="<%= categoryList%>" var="category">
                                                    <option>${category.getName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <a href="#" class="flex items-end">
                                            <button type="button"
                                                class="inline-flex h-fit items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                                                Search
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>