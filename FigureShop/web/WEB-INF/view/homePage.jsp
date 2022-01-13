<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome to figure shop</title>
    <jsp:include page="./commonView/init.jsp"></jsp:include>
  </head>
  <body>
    <div class="bg-white">
      <div>
        <jsp:include page="./commonView/navbar.jsp"></jsp:include>
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
                <div
                  class="absolute inset-0 bg-indigo-700 mix-blend-multiply"
                ></div>
              </div>
              <div
                class="relative px-4 py-16 sm:px-6 sm:py-24 lg:py-32 lg:px-8"
              >
                <h1
                  class="text-center text-4xl font-extrabold tracking-tight sm:text-5xl lg:text-6xl"
                >
                  <span class="block text-white">Every Figure have</span>
                  <span class="block text-indigo-200">Spirit of Joy</span>
                </h1>
                <p
                  class="mt-6 max-w-lg mx-auto text-center text-xl text-indigo-200 sm:max-w-3xl"
                >
                  We will bring you quality and diverse products. Let's take next step for your needs
                </p>
                <div
                  class="mt-10 max-w-sm mx-auto sm:max-w-none sm:flex sm:justify-center"
                >
                  <a
                    href="#"
                    class="flex items-center justify-center px-1 py-3 border border-transparent text-base font-medium rounded-md shadow-sm text-indigo-700 bg-white hover:bg-indigo-50 sm:px-8"
                  >
                    Shop now
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="bg-gray-50">
        <div class="max-w-7xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:px-8">
          <div class="sm:flex sm:items-baseline sm:justify-between">
            <h2 class="text-2xl font-extrabold tracking-tight text-gray-900">
              Shop by Category
            </h2>
            <a
              href="#"
              class="hidden text-sm font-semibold text-indigo-600 hover:text-indigo-500 sm:block"
              >Browse all categories<span aria-hidden="true"> &rarr;</span></a
            >
          </div>

          <div
            class="mt-6 grid grid-cols-1 gap-y-6 sm:grid-cols-2 sm:grid-rows-2 sm:gap-x-6 lg:gap-8"
          >
            <div
              class="group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:aspect-h-1 sm:aspect-w-1 sm:row-span-2"
            >
              <img
                src="https://tailwindui.com/img/ecommerce-images/home-page-03-featured-category.jpg"
                alt="Two models wearing women's black cotton crewneck tee and off-white cotton crewneck tee."
                class="object-center object-cover group-hover:opacity-75"
              />
              <div
                aria-hidden="true"
                class="bg-gradient-to-b from-transparent to-black opacity-50"
              ></div>
              <div class="p-6 flex items-end">
                <div>
                  <h3 class="font-semibold text-white">
                    <a href="#">
                      <span class="absolute inset-0"></span>
                      New Arrivals
                    </a>
                  </h3>
                  <p aria-hidden="true" class="mt-1 text-sm text-white">
                    Shop now
                  </p>
                </div>
              </div>
            </div>
            <div
              class="group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:relative sm:aspect-none sm:h-full"
            >
              <img
                src="https://tailwindui.com/img/ecommerce-images/home-page-03-category-01.jpg"
                alt="Wooden shelf with gray and olive drab green baseball caps, next to wooden clothes hanger with sweaters."
                class="object-center object-cover group-hover:opacity-75 sm:absolute sm:inset-0 sm:w-full sm:h-full"
              />
              <div
                aria-hidden="true"
                class="bg-gradient-to-b from-transparent to-black opacity-50 sm:absolute sm:inset-0"
              ></div>
              <div class="p-6 flex items-end sm:absolute sm:inset-0">
                <div>
                  <h3 class="font-semibold text-white">
                    <a href="#">
                      <span class="absolute inset-0"></span>
                      Accessories
                    </a>
                  </h3>
                  <p aria-hidden="true" class="mt-1 text-sm text-white">
                    Shop now
                  </p>
                </div>
              </div>
            </div>
            <div
              class="group aspect-w-2 aspect-h-1 rounded-lg overflow-hidden sm:relative sm:aspect-none sm:h-full"
            >
              <img
                src="https://tailwindui.com/img/ecommerce-images/home-page-03-category-02.jpg"
                alt="Walnut desk organizer set with white modular trays, next to porcelain mug on wooden desk."
                class="object-center object-cover group-hover:opacity-75 sm:absolute sm:inset-0 sm:w-full sm:h-full"
              />
              <div
                aria-hidden="true"
                class="bg-gradient-to-b from-transparent to-black opacity-50 sm:absolute sm:inset-0"
              ></div>
              <div class="p-6 flex items-end sm:absolute sm:inset-0">
                <div>
                  <h3 class="font-semibold text-white">
                    <a href="#">
                      <span class="absolute inset-0"></span>
                      Workspace
                    </a>
                  </h3>
                  <p aria-hidden="true" class="mt-1 text-sm text-white">
                    Shop now
                  </p>
                </div>
              </div>
            </div>
          </div>

          <div class="mt-6 sm:hidden">
            <a
              href="#"
              class="block text-sm font-semibold text-indigo-600 hover:text-indigo-500"
              >Browse all categories<span aria-hidden="true"> &rarr;</span></a
            >
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
