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
      <jsp:include page="./commonView/navbar.jsp"></jsp:include>

      <jsp:include page="./welcomeBanner.jsp"></jsp:include>

      <jsp:include page="./welcomeFilter.jsp"></jsp:include>

      <jsp:include page="./welcomeCategory.jsp"></jsp:include>
    </div>
  </body>
</html>
