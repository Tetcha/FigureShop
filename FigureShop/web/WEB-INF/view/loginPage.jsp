<%@page import="constant.Router"%>
<%@page import="daos.UserDAO"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
          <title>Login</title>
        <link rel="stylesheet" href="asset/styles.css" type="text/css" />

        <jsp:include page="./commonView/Navbar.jsp">
            <jsp:param name="title" value="Sannin SC |  Add Room" />
        </jsp:include>
    </head>
</head>
<body>
    <%
        User user =(User) request.getAttribute("user");
    %>


    <div class="flex flex-col items-center justify-center flex-1 h-screen bg-gradient-to-b from-gray-50 to-gray-100">
        <form
            action="<%=Router.PROFILE_CONTROLLER%>"
            method="POST"
            class="w-full max-w-3xl overflow-hidden bg-white sm:shadow sm:rounded-lg sm:w-180"
            enctype="multipart/form-data"
            >
            <div class="px-4 py-5 sm:px-6">
                <h3 class="text-lg font-medium leading-6 text-gray-900">
                    Applicant Information
                </h3>
                <p class="max-w-2xl mt-1 text-sm text-gray-500">Personal details.</p>
            </div>
            <div class="px-4 py-5 border-t border-gray-200 sm:p-0">
                <dl class="sm:divide-y sm:divide-gray-200">
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>username</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <p><%= user.getUsername()%></p>
                        </dd>
                    </div>
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>email</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <input
                                id="email"
                                name="email"
                                type="email"
                                autocomplete="email"
                                required
                                value="<%= user.getEmail() == null ? "" : user.getEmail()%>"
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.emailError}
                            </p>
                        </dd>
                    </div>
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>Full name</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <input
                                id="fullName"
                                name="fullName"
                                type="text"
                                required
                                value="<%= user.getFullName() == null ? "" : user.getFullName()%>"
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.fullNameError}
                            </p>
                        </dd>
                    </div>
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>Address</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <input
                                id="address"
                                name="address"
                                type="text"
                                value="<%= user.getAddress() == null ? "" : user.getAddress()%>"
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.addressError}
                            </p>
                        </dd>
                    </div>
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>Phone</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <input
                                id="phone"
                                name="phone"
                                type="text"
                                value="<%= user.getPhone() == null ? "" : user.getPhone()%>"
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.phoneError}
                            </p>
                        </dd>
                    </div>
                    <div class="py-4 sm:py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="flex items-center text-sm font-medium text-gray-500">
                            <p>Avatar</p>
                        </dt>
                        <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                            <!-- <input
                                id="avatar"
                                name="avatar"
                                type="text"
                                value="<%= user.getAvatar() == null ? "" : user.getAvatar()%>"
                                class="block w-full px-3 py-2 placeholder-gray-400 border border-gray-300 rounded-md shadow-sm appearance-none focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                             /> -->
                            <input
                                type="file"
                                id="avatar"
                                name="avatar"
                                />
                            <p class="mt-2 text-sm text-red-600" id="email-error">
                                ${requestScope.avatarError}
                            </p>
                        </dd>
                    </div>
                </dl>
                <p class="mt-2 mr-5 text-sm font-semibold text-right text-green-600" id="successMessage">
                    ${requestScope.successMessage}
                </p>
            </div>
            <div class="flex justify-end px-4 py-5 sm:px-6">
                <a
                    href="<%=Router.CHANGE_PASSWORD_CONTROLLER%>"
                    class="inline-flex items-center px-3 py-2 mr-5 text-sm font-medium leading-4 text-white bg-red-500 border border-transparent rounded-md shadow-sm hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
                    Change password
                </a>
                <input
                    type="submit"
                    class="inline-flex items-center px-3 py-2 text-sm font-medium leading-4 text-white bg-indigo-600 border border-transparent rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    value="Save"
                    >
            </div>
        </form>
    </div>
</body>
</html>