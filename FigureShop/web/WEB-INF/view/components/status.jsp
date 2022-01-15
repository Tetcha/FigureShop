<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${param.status=='0'}">
    <span
        class="flex-shrink-0 inline-block px-2 py-0.5 text-yellow-800 text-xs font-medium bg-yellow-100 rounded-full"
        >Waiting</span
    >
</c:if>

<c:if test="${param.status=='1'}">
    <span
        class="flex-shrink-0 inline-block px-2 py-0.5 text-green-800 text-xs font-medium bg-green-100 rounded-full"
        >Confirm</span
    >
</c:if>

<c:if test="${param.status=='2'}">
    <span
        class="flex-shrink-0 inline-block px-2 py-0.5 text-green-800 text-xs font-medium bg-green-100 rounded-full"
        >Done</span
    >
</c:if>

<c:if test="${param.status=='3'}">
    <span
        class="flex-shrink-0 inline-block px-2 py-0.5 text-red-800 text-xs font-medium bg-red-100 rounded-full"
        >Cancel</span
    >
</c:if>