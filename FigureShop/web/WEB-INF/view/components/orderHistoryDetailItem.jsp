<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
    contentType="text/html" pageEncoding="UTF-8"%>



    <div class="py-6 sm:flex">
        <div
            class="flex space-x-4 sm:min-w-0 sm:flex-1 sm:space-x-6 lg:space-x-8"
            >
            <img
                src="${param.avatar}"
                alt="Brass puzzle in the shape of a jack with overlapping rounded posts."
                class="flex-none w-20 h-20 rounded-md object-center object-cover sm:w-48 sm:h-48"
                />
            <div class="pt-1.5 min-w-0 flex-1 sm:pt-0">
                <h3 class="text-sm font-medium text-gray-900">
                    <a href="#">${param.name}</a>
                </h3>
                <p class="text-sm text-gray-500 truncate">
                    <span>${param.category}</span>
                    
                    <span>x ${param.quantity}</span>
                </p>
                <p class="mt-1 font-medium text-gray-900">$${param.price}</p>
            </div>
        </div>
        
    </div>