<%@page import="constants.Router"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>BFF Shop</title>
        <jsp:include page="../common/init.jsp"></jsp:include>
    </head>
</head>
<body>
    <div class="flex flex-col w-screen h-screen">
        <jsp:include page="../common/navbar.jsp"></jsp:include>
    <div
        class="relative flex-1 flex flex-col justify-center  bg-white lg:py-12 lg:bg-gradient-to-b lg:from-gray-50 lg:to-gray-100 sm:px-6 lg:px-8"
        >
        <div class="sm:mx-auto sm:w-full sm:max-w-md">
  
            <h2
                class="mt-6 text-4xl font-extrabold text-center text-gray-900 hello"
                >
               Log in
            </h2>
        </div>

        <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
            <div class="px-4 py-8 bg-white lg:shadow-xl sm:rounded-xl sm:px-10">
                <form class="space-y-6" action="<%=Router.LOGIN_CONTROLLER%>" method="POST">
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
                                autocomplete="current-password"
                                required
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                        </div>
                    </div>
                    <p class="text-sm text-left text-red-600">
                        ${requestScope.errorMessage}
                    </p>



                    <div>
                        <button
                            type="submit"
                            class="flex justify-center w-full px-4 py-2 text-sm font-medium text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                            >
                            Sign in
                        </button>
                    </div>
                    <div class="flex justify-end">
                        <div class="self-end mt-4 text-sm">
                            Don't have account yet?
                            <a
                                href="<%=Router.REGISTER_CONTROLLER%>"
                                class="font-semibold text-indigo-600 underline hover:text-indigo-500"
                                >
                                Register
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
    
</body>
</html>