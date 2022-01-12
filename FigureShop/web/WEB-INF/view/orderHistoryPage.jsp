<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Oder history</title>
        <jsp:include page="./commonView/init.jsp"></jsp:include>
        </head>
        <body>
            <div class="flex flex-col w-screen h-screen">
            <jsp:include page="./commonView/navbar.jsp"></jsp:include>
                <div class="bg-white p-10 flex-1">
                    <h2 class="font-bold text-2xl mb-5">Order history</h2>
                    <ul
                        role="list"
                        class="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3"
                        >

                    <jsp:include page="./components/orderHistoryItem.jsp">
                        <jsp:param name="id" value="001" />
                        <jsp:param name="totalPrice" value="30" />
                        <jsp:param name="address" value="197 hoang huu nam" />
                        <jsp:param name="phone" value="0869025867" />
                        <jsp:param name="status" value="success" />
                    </jsp:include>

                </ul>
            </div>
        </div>
    </body>
</html>
