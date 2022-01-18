$(document).ready(function () {
  const timeout = 3000;
  $("#closeNotificationButton").click(function (e) {
    e.preventDefault();
    $("#notification").addClass("hidden");
  });

  setTimeout(() => {
    $("#notification").addClass("hidden");
  }, timeout);
});
