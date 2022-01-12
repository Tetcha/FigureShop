<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
    contentType="text/html" pageEncoding="UTF-8"%>



    <li class="flex py-6 sm:py-10">
        <div class="flex-shrink-0">
            <img
                src="${param.avatar}"
                alt="Front of men&#039;s Basic Tee in sienna."
                class="w-24 h-24 rounded-md object-center object-cover sm:w-48 sm:h-48"
                />
        </div>

        <div class="ml-4 flex-1 flex flex-col justify-between sm:ml-6">
            <div
                class="relative pr-9 sm:grid sm:grid-cols-2 sm:gap-x-6 sm:pr-0"
                >
                <div>
                    <div class="flex justify-between">
                        <h3 class="text-sm">
                            <a
                                href="#"
                                class="font-medium text-gray-700 hover:text-gray-800"
                                >
                                ${param.name}
                            </a>
                        </h3>
                    </div>
                    <div class="mt-1 flex text-sm">
                        <p class="text-gray-500">${param.category}</p>
                    </div>
                    <p class="mt-1 text-sm font-medium text-gray-900">
                        $${param.price}
                    </p>
                </div>

                <div class="mt-4 sm:mt-0 sm:pr-9">
                    <label for="quantity-0" class="sr-only"
                           >Quantity, Basic Tee</label
                    >
                    <select
                        id="quantity-0"
                        name="quantity-0"
                        class="max-w-full rounded-md border border-gray-300 py-1.5 text-base leading-5 font-medium text-gray-700 text-left shadow-sm focus:outline-none focus:ring-1 focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        >
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="8">9</option>
                        <option value="8">10</option>
                    </select>

                    <div class="absolute top-0 right-0">
                        <button
                            type="button"
                            class="-m-2 p-2 inline-flex text-gray-400 hover:text-gray-500"
                            >
                            <span class="sr-only">Remove</span>
                            <svg
                                class="h-5 w-5"
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                                fill="currentColor"
                                aria-hidden="true"
                                >
                                <path
                                    fill-rule="evenodd"
                                    d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                    clip-rule="evenodd"
                                    />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>

<!--            <p class="mt-4 flex text-sm text-gray-700 space-x-2">
                <svg
                    class="flex-shrink-0 h-5 w-5 text-green-500"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fill-rule="evenodd"
                        d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                        clip-rule="evenodd"
                        />
                </svg>
                <span>In stock</span>
            </p>-->
        </div>
    </li>