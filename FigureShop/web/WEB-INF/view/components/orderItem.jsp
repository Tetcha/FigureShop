<%@page import="category.models.Category"%> <%@page
import="category.daos.CategoryDao"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@page contentType="text/html"
pageEncoding="UTF-8"%>

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
            <span class="-translate-y-1/2"> - </span>
          </div>
          <div
            class="flex font-bold items-center justify-center w-7 h-7 text-black px-5 rounded-sm"
          >
            ${param.quantity}
          </div>
          <div
            class="flex font-bold items-center justify-center w-7 h-7 text-white bg-indigo-600 rounded-sm"
          >
            <span class="-translate-y-1/2"> + </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</li>
