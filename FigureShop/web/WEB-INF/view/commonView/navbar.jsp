<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%> <% String avatarUrl = (String)
session.getAttribute("avatarUrl");%> <%@page import="constants.Router"%>

  <div class="relative bg-gray-800">
    <div
      class="flex justify-between items-center max-w-7xl mx-auto px-4 py-3 sm:px-6 md:justify-start md:space-x-10 lg:px-8"
    >
      <div class="flex justify-start lg:w-0 lg:flex-1">
          <a href="<%=Router.HOME_CONTROLLER%>">
          <img class="h-8 w-auto sm:h-10" src="asset/images/logo.png" alt="" />
        </a>
      </div>
      <div class="-mr-2 -my-2 md:hidden">
        <button
          type="button"
          class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
          aria-expanded="false"
          id="openNavPopupButton"
        >
          <span class="sr-only">Open menu</span>
          <svg
            class="h-6 w-6"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            aria-hidden="true"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M4 6h16M4 12h16M4 18h16"
            />
          </svg>
        </button>
      </div>

      <div class="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
        <a
          href="<%=Router.LOGIN_CONTROLLER %>"
          class="whitespace-nowrap text-base font-medium text-gray-100 hover:text-indigo-500"
        >
          Sign in
        </a>
        <a
          href="<%=Router.REGISTER_CONTROLLER%>"
          class="ml-8 whitespace-nowrap inline-flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700"
        >
          Sign up
        </a>
      </div>
    </div>

    <div
      id="navPopupMobile"
      class="absolute z-30 top-0 inset-x-0 p-2 transition transform origin-top-right md:hidden hidden"
    >
      <div
        class="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 bg-white divide-y-2 divide-gray-50"
      >
        <div class="pt-5 pb-6 px-5">
          <div class="flex items-center justify-between">
            <a href="<%=Router.HOME_CONTROLLER%>">
              <img
                class="h-8 w-auto"
                src="asset/images/logo.png"
                alt="Workflow"
              />
            </a>
            <div class="-mr-2">
              <button
                type="button"
                class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
                id="xButton"
              >
                <span class="sr-only">Close menu</span>
                <!-- Heroicon name: outline/x -->
                <svg
                  class="h-6 w-6"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                  aria-hidden="true"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M6 18L18 6M6 6l12 12"
                  />
                </svg>
              </button>
            </div>
          </div>
          <div class="mt-6">
            <nav class="grid grid-cols-1 gap-7">
              <a
                href="#"
                class="-m-3 p-3 flex items-center rounded-lg hover:bg-gray-50"
              >
                <div
                  class="flex-shrink-0 flex items-center justify-center h-10 w-10 rounded-md bg-indigo-600 text-white"
                >
                  <svg
                    class="h-6 w-6"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M20 13V6a2 2 0 00-2-2H6a2 2 0 00-2 2v7m16 0v5a2 2 0 01-2 2H6a2 2 0 01-2-2v-5m16 0h-2.586a1 1 0 00-.707.293l-2.414 2.414a1 1 0 01-.707.293h-3.172a1 1 0 01-.707-.293l-2.414-2.414A1 1 0 006.586 13H4"
                    />
                  </svg>
                </div>
                <div class="ml-4 text-base font-medium text-gray-900">
                  Inbox
                </div>
              </a>

              <a
                href="#"
                class="-m-3 p-3 flex items-center rounded-lg hover:bg-gray-50"
              >
                <div
                  class="flex-shrink-0 flex items-center justify-center h-10 w-10 rounded-md bg-indigo-600 text-white"
                >
                  <!-- Heroicon name: outline/annotation -->
                  <svg
                    class="h-6 w-6"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z"
                    />
                  </svg>
                </div>
                <div class="ml-4 text-base font-medium text-gray-900">
                  Messaging
                </div>
              </a>
            </nav>
          </div>
        </div>
        <div class="py-6 px-5">
          <div class="mt-6">
            <a
              href="<%=Router.REGISTER_CONTROLLER%>"
              class="w-full flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700"
            >
              Sign up
            </a>
            <p class="mt-6 text-center text-base font-medium text-gray-500">
              Existing customer?
              <a href="<%=Router.LOGIN_CONTROLLER%>" class="text-gray-900">
                Sign in
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>

