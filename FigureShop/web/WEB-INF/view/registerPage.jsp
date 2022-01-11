
<%@page import="constants.Router"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>BFF Shop</title>
        <link rel="stylesheet" href="asset/styles.css" type="text/css" />
         <jsp:include page="./commonView/navbar.jsp"></jsp:include>
    </head>
</head>
<body>
    <div
        class="flex flex-col justify-center min-h-screen py-12 bg-white lg:bg-gradient-to-b lg:from-gray-50 lg:to-gray-100 sm:px-6 lg:px-8"
        >
        <div class="sm:mx-auto sm:w-full sm:max-w-md">
          
            <h2 class="mt-6 text-4xl font-extrabold text-center text-gray-900">
                Register
            </h2>
        </div>
        <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
            <div class="px-4 py-8 bg-white lg:shadow-xl sm:rounded-xl sm:px-10">
                <form class="space-y-6" action="<%=Router.REGISTER_CONTROLLER%>" method="POST">
                    <div>
                        <label
                            for="email"
                            class="block text-sm font-medium text-gray-700"
                            >
                            Email
                        </label>
                        <div class="mt-1">
                            <input
                                id="email"
                                name="email"
                                type="email"
                                autocomplete="email"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.emailError}
                            </p>
                        </div>
                    </div>
                    <div>
                        <label
                            for="email"
                            class="block text-sm font-medium text-gray-700"
                            >
                            User name
                        </label>
                        <div class="mt-1">
                            <input
                                id="username"
                                name="username"
                                type="text"
                                autocomplete="email"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.usernameError}
                            </p>
                        </div>
                    </div>
                    <div>
                        <label
                            for="email"
                            class="block text-sm font-medium text-gray-700"
                            >
                            Full name
                        </label>
                        <div class="mt-1">
                            <input
                                id="fullName"
                                name="fullName"
                                type="text"
                                autocomplete="email"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.fullNameError}
                            </p>
                        </div>
                    </div>
                    <div>
                        <label
                            for="password"
                            class="block text-sm font-medium text-gray-700"
                            >
                            Password
                        </label>
                        <div class="mt-1">
                            <input
                                id="password"
                                name="password"
                                type="password"
                                autocomplete="email"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.passwordError}
                            </p>
                        </div>
                    </div>
                    <div>
                        <label
                            for="password"
                            class="block text-sm font-medium text-gray-700"
                            >
                            Confirm password
                        </label>
                        <div class="mt-1">
                            <input
                                id="confirmPassword"
                                name="confirmPassword"
                                type="password"
                                autocomplete="current-password"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />

                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.confirmPasswordError}
                            </p>
                        </div>
                    </div>
                    <div>
                        <button
                            type="submit"
                            class="flex justify-center w-full px-4 py-2 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                            >
                            Register
                        </button>
                    </div>
                    <div class="flex justify-end">
                        <div class="self-end mt-4 text-sm">
                            Already have an account?
                            <a
                                href="<%=Router.LOGIN_CONTROLLER%>"
                                class="font-semibold text-indigo-600 underline hover:text-indigo-500"
                                >
                                Login
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>