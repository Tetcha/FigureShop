<%@page import="constants.Router"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="bg-white">
    <div class="max-w-7xl mx-auto py-5 px-4 sm:py-5 sm:px-6 lg:px-8">
        <div class="sm:flex sm:items-baseline sm:justify-between">
            <h2 class="text-2xl font-extrabold tracking-tight text-gray-900">
                Shop by Category
            </h2>
        </div>

        <div class="mt-6 grid grid-cols-1 gap-y-6 sm:grid-cols-2 sm:grid-rows-2 sm:gap-x-6 lg:gap-8">
            <div
                class="relative group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:aspect-h-1 sm:aspect-w-1 sm:row-span-2">
                <img src="./asset/images/category_OnePiece.jpg" alt="OnePiece"
                     class="object-center width-auto sm:h-full object-cover group-hover:opacity-75" />
                <div aria-hidden="true" class="bg-gradient-to-b from-transparent to-black opacity-50"></div>
                <div class="p-6 flex items-end">
                    <div>
                        <h3 class="font-semibold text-white">
                            <a href="<%=Router.PRODUCT_FILTER_CONTROLLER%>?name=&from=0&to=99999999&categoryId=c944a88f-5ee6-4dfc-9022-1aad795998d4&page=1">
                                <span class="absolute inset-0"></span>
                                One Piece
                            </a>
                        </h3>
                        <p aria-hidden="true" class="mt-1 text-sm text-white">Shop now</p>
                    </div>
                </div>
            </div>
            <div class="group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:relative sm:aspect-none ">
                <img src="./asset/images/category_Naruto.jpg" alt="Naruto"
                     class="object-center object-cover group-hover:opacity-75 sm:absolute sm:inset-0 sm:w-full sm:h-full" />
                <div aria-hidden="true"
                     class="bg-gradient-to-b from-transparent to-black opacity-50 sm:absolute sm:inset-0"></div>
                <div class="p-6 flex items-end sm:absolute sm:inset-0">
                    <div>
                        <h3 class="font-semibold text-white">
                            <a href="<%=Router.PRODUCT_FILTER_CONTROLLER%>?name=&from=0&to=99999999&categoryId=5a863c08-19d6-49fe-b07e-bb2b25cd1b6d&page=1">
                                <span class="absolute inset-0"></span>
                                Naruto
                            </a>
                        </h3>
                        <p aria-hidden="true" class="mt-1 text-sm text-white">Shop now</p>
                    </div>
                </div>
            </div>
            <div
                class="group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:relative sm:aspect-none sm:h-full">
                <img src="./asset/images/category_HonkaiImpact.jpg" alt="HonkaiImpact"
                     class="object-center object-cover group-hover:opacity-75 sm:absolute sm:inset-0 sm:w-full " />
                <div aria-hidden="true"
                     class="bg-gradient-to-b from-transparent to-black opacity-50 sm:absolute sm:inset-0"></div>
                <div class="p-6 flex items-end sm:absolute sm:inset-0">
                    <div>
                        <h3 class="font-semibold text-white">
                            <a href="<%=Router.PRODUCT_FILTER_CONTROLLER%>?name=&from=0&to=99999999&categoryId=55d2db37-c0bc-4598-8965-fd1fe9048918&page=1">
                                <span class="absolute inset-0"></span>
                                Honkai Impact
                            </a>
                        </h3>
                        <p aria-hidden="true" class="mt-1 text-sm text-white">Shop now</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="mt-6 sm:hidden">
            <a href="#" class="block text-sm font-semibold text-indigo-600 hover:text-indigo-500">Browse all
                categories<span aria-hidden="true"> &rarr;</span></a>
        </div>
    </div>
</div>