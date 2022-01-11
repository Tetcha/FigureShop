$(document).ready(function () {
  const navPopupElement = $("#navPopupMobile");
  $("#xButton").click(function (e) {
    e.preventDefault();
    navPopupElement.addClass("hidden");
  });

  $("#openNavPopupButton").click(function (e) {
    e.preventDefault();
    navPopupElement.removeClass("hidden");
  });
});
