<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Your cart</title>
    <jsp:include page="./commonView/init.jsp"></jsp:include>
  </head>
  <body>
    <jsp:include page="./commonView/navbar.jsp"></jsp:include>
    <div class="bg-white">
      <div
        class="max-w-2xl mx-auto pt-16 pb-24 px-4 sm:px-6 lg:max-w-7xl lg:px-8"
      >
        <h1
          class="text-3xl font-extrabold tracking-tight text-gray-900 sm:text-4xl"
        >
          Shopping Cart
        </h1>
        <form
          class="mt-12 lg:grid lg:grid-cols-12 lg:gap-x-12 lg:items-start xl:gap-x-16"
        >
          <section aria-labelledby="cart-heading" class="lg:col-span-7">
            <h2 id="cart-heading" class="sr-only">
              Items in your shopping cart
            </h2>

            <ul
              role="list"
              class="border-t border-b border-gray-200 divide-y divide-gray-200"
            >
                
              <!-- start an orderitem -->
               <jsp:include page="./components/orderItem.jsp">
                   <jsp:param name="avatar" value="https://tailwindui.com/img/ecommerce-images/shopping-cart-page-01-product-01.jpg" />
                   <jsp:param name="name" value="test product" />
                   <jsp:param name="price" value="19" />
                   <jsp:param name="category" value="big figure" />
               </jsp:include>
            </ul>
          </section>

          <!-- Order summary -->
          <section
            aria-labelledby="summary-heading"
            class="mt-16 bg-gray-50 rounded-lg px-4 py-6 sm:p-6 lg:p-8 lg:mt-0 lg:col-span-5"
          >
            <h2 id="summary-heading" class="text-lg font-medium text-gray-900">
              Order summary
            </h2>

            <dl class="mt-6 space-y-4">
              <div class="flex items-center justify-between">
                <dt class="text-sm text-gray-600">Figure 1</dt>
                <dd class="text-sm font-medium text-gray-900">$99.00</dd>
              </div>
              <div class="flex items-center justify-between">
                <dt class="text-sm text-gray-600">Figure 2</dt>
                <dd class="text-sm font-medium text-gray-900">$99.00</dd>
              </div>
              <div class="flex items-center justify-between">
                <dt class="text-sm text-gray-600">Figure 3</dt>
                <dd class="text-sm font-medium text-gray-900">$99.00</dd>
              </div>

              <div
                class="border-t border-gray-200 pt-4 flex items-center justify-between"
              >
                <dt class="text-base font-medium text-gray-900">Order total</dt>
                <dd class="text-base font-medium text-gray-900">$112.32</dd>
              </div>
            </dl>
            <div class="flex flex-col">
              <div class="mt-5">
                <label
                  for="email"
                  class="block text-sm font-medium text-gray-700"
                >
                  Address
                </label>
                <div class="mt-1">
                  <input
                    id="address"
                    name="address"
                    type="text"
                    required
                    class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </div>
              </div>
              <div class="mt-5">
                <label
                  for="phone"
                  class="block text-sm font-medium text-gray-700"
                >
                  Phone
                </label>
                <div class="mt-1">
                  <input
                    id="phone"
                    name="phone"
                    type="text"
                    required
                    class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                  />
                </div>
              </div>
            </div>
            <div class="mt-6">
              <button
                type="submit"
                class="w-full bg-indigo-600 border border-transparent rounded-md shadow-sm py-3 px-4 text-base font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500"
              >
                Checkout
              </button>
            </div>
          </section>
        </form>
      </div>
    </div>
  </body>
</html>
