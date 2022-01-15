<%@page import="constants.Router"%> 
<%@page import="category.models.Category"%>
<%@page import="category.daos.CategoryDao"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<li class="flex py-6 sm:py-10">
    <div class="flex-shrink-0">
        <img
            src="${param.avatar}"
            alt="Front of men&#039;s Basic Tee in sienna."
            class="w-24 h-24 rounded-md object-center object-cover sm:w-48 sm:h-48"
            />
    </div>

    <div class="ml-4 flex-1 flex flex-col justify-between sm:ml-6">
        <div class="relative pr-9 sm:grid sm:grid-cols-1 sm:gap-x-6 sm:pr-0">
            <div>
                <div class="flex justify-between">
                    <h3 class="text-sm">
                        <a href="#" class="font-medium text-gray-700 hover:text-gray-800">
                            ${param.name}
                        </a>
                    </h3>
                </div>
                <div class="mt-1 flex text-sm">
                    <p class="text-gray-500">${param.category}</p>
                </div>
                <p class="mt-1 text-sm font-medium text-gray-900">${param.price}đ</p>
                <div class="flex mt-5">
                    <div
                        class="flex font-bold items-center justify-center w-7 h-7 text-white bg-indigo-600 rounded-sm"
                        >
                        <form
                            action="<%= Router.CART_PRODUCT_QUANTITY_CONTROLLER%>"
                            method="get"
                            >
                            <button type="submit">
                                <span class="-translate-y-1/2">-</span>
                            </button>

                            <input
                                type="text"
                                class="hidden"
                                name="productIndex"
                                value="${param.index}"
                                />
                            <input
                                type="number"
                                class="hidden"
                                name="isIncreased"
                                value="0"
                                />
                        </form>
                    </div>
                    <div
                        class="flex font-bold items-center justify-center w-7 h-7 text-black px-5 rounded-sm"
                        >
                        ${param.quantity}
                    </div>
                    <div
                        class="flex font-bold items-center justify-center w-7 h-7 text-white bg-indigo-600 rounded-sm"
                        >
                        <form
                            action="<%= Router.CART_PRODUCT_QUANTITY_CONTROLLER%>"
                            method="get"
                            >
                            <button type="submit">
                                <span class="-translate-y-1/2">+</span>
                            </button>

                            <input
                                type="text"
                                class="hidden"
                                name="productIndex"
                                value="${param.index}"
                                />
                            <input
                                type="number"
                                class="hidden"
                                name="isIncreased"
                                value="1"
                                />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form action="<%= Router.CART_REMOVE_PRODUCT_CONTROLLER%>" method="get">
        <input
            type="text"
            class="hidden"
            name="productId"
            value="${param.id}"
            />
        <button type="submit">
            <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-6 w-6"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                >
                <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M6 18L18 6M6 6l12 12"
                    />
            </svg>
        </button>
    </form>
</li>
