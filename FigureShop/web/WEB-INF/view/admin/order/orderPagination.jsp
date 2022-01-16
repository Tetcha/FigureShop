<%@page import="constants.Router"%>
<%@page import="utils.GetParam"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int pageNumber = GetParam.getIntParams(request, "page", "Page", 1, Integer.MAX_VALUE, 1);
    int maxPage = (int) request.getAttribute("maxPage");
    String fromDate = (String)request.getAttribute("fromDate");
    String toDate = (String)request.getAttribute("toDate");
    
    String selectedClass = "z-10 bg-indigo-50 border-indigo-500 text-indigo-600 relative inline-flex items-center px-4 py-2 border text-sm font-medium";
    String unSelectedClass = "bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 border text-sm font-medium";
    boolean isHavePriviosPage = false;
    boolean isHaveNextPage = false;
    if (pageNumber - 1 > 0) {
        isHavePriviosPage = true;

    }
    if (pageNumber + 1 <= maxPage) {
        isHaveNextPage = true;
    }
%>


<div >
    <nav
        class="relative mt-5 z-0 inline-flex rounded-md shadow-sm -space-x-px"
        aria-label="Pagination"
        >
        <a
            href="<%= Router.ADMIN_ORDERS_CONTROLLER %>?fromDate=<%= fromDate%>&toDate=<%= toDate%>&page=<%= isHavePriviosPage ? pageNumber - 1 : 1%>&currentShow="
            class="relative inline-flex items-center px-2 py-2 rounded-l-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50"
            >
            <span class="sr-only">Previous</span>
            <svg
                class="h-5 w-5"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 20 20"
                fill="currentColor"
                aria-hidden="true"
                >
                <path
                    fill-rule="evenodd"
                    d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                    clip-rule="evenodd"
                    />
            </svg>
        </a>
        <%for (int i = 1; i <= maxPage; i++) {%>
        <a
            href="<%= Router.ADMIN_ORDERS_CONTROLLER %>?fromDate=<%= fromDate%>&toDate=<%= toDate%>&page=<%= i%>&currentShow="
            aria-current="page"
            class="<%= i == pageNumber ? selectedClass : unSelectedClass%>"
            >
            <%= i%>
        </a>

        <%}%>


        <a
            href="<%= Router.ADMIN_ORDERS_CONTROLLER %>?fromDate=<%= fromDate%>&toDate=<%= toDate%>&page=<%= isHaveNextPage ? pageNumber + 1 : maxPage%>&currentShow="
            class="relative inline-flex items-center px-2 py-2 rounded-r-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50"
            >
            <span class="sr-only">Next</span>
            <svg
                class="h-5 w-5"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 20 20"
                fill="currentColor"
                aria-hidden="true"
                >
                <path
                    fill-rule="evenodd"
                    d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                    clip-rule="evenodd"
                    />
            </svg>
        </a>
    </nav>

</div>