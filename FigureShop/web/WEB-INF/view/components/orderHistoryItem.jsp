<%@page import="constants.Router"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>

<li class="col-span-1 bg-white rounded-lg shadow-xl divide-y divide-gray-200">
  <div class="w-full flex items-center justify-between p-6 space-x-6">
    <div class="flex-1 truncate">
      <div class="flex items-center space-x-3">
        <h3 class="text-gray-900 text-sm font-medium truncate">
          ID : #${param.id}
        </h3>
        <jsp:include page="./status.jsp">
          <jsp:param name="status" value="${param.status}" />
        </jsp:include>
      </div>
      <p class="mt-1 text-gray-500 text-sm truncate">
        Total price : ${param.totalPrice}đ
      </p>
      <p class="mt-1 text-gray-500 text-sm truncate">
        Address : ${param.address}
      </p>
      <p class="mt-1 text-gray-500 text-sm truncate">
        Phone number : ${param.phone}
      </p>
    </div>
  </div>
  <div>
    <div class="-mt-px flex divide-x divide-gray-200">
      <div class="w-0 flex-1 flex">
        <a
            href="<%= Router.ORDER_HISTORY_DETAIL_CONTROLLER %>?orderId=${param.id}"
          class="relative -mr-px w-0 flex-1 inline-flex items-center justify-center py-4 text-sm text-gray-700 font-medium border border-transparent rounded-bl-lg hover:text-gray-500"
        >
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
              d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
            />
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
            />
          </svg>
          <span class="ml-3">View</span>
        </a>
      </div>
    </div>
  </div>
</li>
