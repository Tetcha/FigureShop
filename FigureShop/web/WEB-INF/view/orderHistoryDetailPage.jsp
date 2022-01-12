<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>History detail</title>
    <jsp:include page="./commonView/init.jsp"></jsp:include>
  </head>
  <body>
    <div class="bg-white">
      <jsp:include page="./commonView/navbar.jsp"></jsp:include>
      <div
        class="max-w-3xl mx-auto px-4 py-16 sm:px-6 sm:pt-24 sm:pb-32 lg:px-8"
      >
        <div class="max-w-xl">
          <h1 class="text-3xl font-extrabold tracking-tight text-gray-900">
            Your detail
          </h1>
          <p class="mt-2 text-sm text-gray-500">
            Check the status of recent orders, manage returns, and discover
            similar products.
          </p>
        </div>
        <div
          class="bg-gray-100 mt-5 rounded-lg py-6 px-4 sm:px-6 sm:flex sm:items-center sm:justify-between sm:space-x-6 lg:space-x-8"
        >
          <dl
            class="flex divide-gray-200 space-y-6 text-sm text-gray-600 flex-auto sm:divide-y-0 sm:space-y-0 sm:grid sm:grid-cols-4 sm:gap-x-6 w-full lg:flex-none lg:gap-x-8"
          >
            <div class="flex justify-between sm:block">
              <dt class="font-medium text-gray-900">Date</dt>
              <dd class="sm:mt-1">
                <time datetime="2021-01-22">January 22, 2021</time>
              </dd>
            </div>
            <div class="flex justify-between pt-6 sm:block sm:pt-0">
              <dt class="font-medium text-gray-900">Receiver's number</dt>
              <dd class="sm:mt-1">WU88191111</dd>
            </div>
            <div class="flex justify-between pt-6 sm:block sm:pt-0">
              <dt class="font-medium text-gray-900">Address</dt>
              <dd class="sm:mt-1">197 haong huu nam</dd>
            </div>
            <div class="flex justify-between pt-6 sm:block sm:pt-0 mt-5">
              <dt class="font-medium text-gray-900">Total</dt>
              <dd class="sm:mt-1">444$</dd>
            </div>
          </dl>
        </div>
        <div class="mt-12 space-y-16 sm:mt-16">
          <section aria-labelledby="4376-heading">
            <div
              class="space-y-1 md:flex md:items-baseline md:space-y-0 md:space-x-4"
            >
              <h2
                id="4376-heading"
                class="text-lg font-medium text-gray-900 md:flex-shrink-0"
              >
                Order #4376
              </h2>
              <div
                class="space-y-5 md:flex-1 md:min-w-0 sm:flex sm:items-baseline sm:justify-between sm:space-y-0"
              >
                <p class="text-sm font-medium text-gray-500">
                  Delivered on January 22, 2021
                </p>
              </div>
            </div>

            <!-- order history detail -->
            <div
              class="mt-6 -mb-6 flow-root border-t border-gray-200 divide-y divide-gray-200"
            >
              <jsp:include page="./components/orderHistoryDetailItem.jsp">
                <jsp:param name="name" value="day la ten san pham" />
                <jsp:param name="category" value="big figure" />
                <jsp:param name="price" value="99" />
                <jsp:param name="quantity" value="10" />
                <jsp:param
                  name="avatar"
                  value="https://scontent.fdad2-1.fna.fbcdn.net/v/t1.6435-9/205956104_2751433955079159_2840020984542922686_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=bv5YGoahtv0AX_Fc75P&_nc_ht=scontent.fdad2-1.fna&oh=00_AT9ggUtj2s8jYvn06kxXdZOx-pWlH_iJsDgampsexLrv6w&oe=62049A68"
                />
              </jsp:include>

              <!-- More products... -->
            </div>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
