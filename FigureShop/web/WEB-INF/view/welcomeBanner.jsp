<%@page import="constants.Router"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<!-- Hero card -->
<div class="relative mt-10">
  <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
    <div class="relative shadow-xl sm:rounded-2xl sm:overflow-hidden">
      <div class="absolute inset-0">
        <img
          class="h-full w-full object-cover"
          src="asset/images/banner.png"
          alt="banner"
        />
        <div class="absolute inset-0 bg-indigo-700 mix-blend-multiply"></div>
      </div>
      <div class="relative px-4 py-16 sm:px-6 sm:py-24 lg:py-32 lg:px-8">
        <h1
          class="text-center text-4xl font-extrabold tracking-tight sm:text-5xl lg:text-6xl"
        >
          <span class="block text-white">Every Figure have</span>
          <span class="block text-indigo-200">Spirit of Joy</span>
        </h1>
        <p
          class="mt-6 max-w-lg mx-auto text-center text-xl text-indigo-200 sm:max-w-3xl"
        >
          We will bring you quality and diverse products. Let's take next step
          for your needs
        </p>
        <div
          class="mt-10 max-w-sm mx-auto sm:max-w-none sm:flex sm:justify-center"
        >
          <a
              href="<%=Router.PRODUCT_FILTER_CONTROLLER%>?name=&from=0&to=99999999&categoryId=&page=1"
            class="flex items-center justify-center px-1 py-3 border border-transparent text-base font-medium rounded-md shadow-sm text-indigo-700 bg-white hover:bg-indigo-50 sm:px-8"
          >
            Shop now
          </a>
        </div>
      </div>
    </div>
  </div>
</div>
