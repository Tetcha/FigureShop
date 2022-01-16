<!DOCTYPE html>
<html lang="en" class="h-full bg-gray-100">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <jsp:include page="../../common/init.jsp" />
  </head>
  <body class="h-full">
    <div>
      <!-- side bar -->
      <jsp:include page="./adminSideBar.jsp" />
      <!-- end side bar -->
      <div class="md:pl-64 flex flex-col flex-1">
        <main class="flex-1">
          <!-- start content -->
          <jsp:include page="${param.body}" />
          <!-- end content -->
        </main>
      </div>
    </div>
  </body>
</html>
