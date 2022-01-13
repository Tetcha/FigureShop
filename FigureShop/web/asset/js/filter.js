$(document).ready(function () {
  const fromElement = $("#fromFilter");
  const toElement = $("#toFilter");
  const nameElement = $("#nameFilter");
  let selectedVal = "";
  $("#categoryFilter").change(function (e) {
    e.preventDefault();
    selectedVal = $("#categoryFilter option:selected").val();
  });
  const baseUrl = "http://localhost:8080/FigureShop";
  $("#filterSearchButton").click(function (e) {
    e.preventDefault();

    let fromValue = fromElement.val();
    if (!fromValue) fromValue = "0";

    let toValue = toElement.val();
    if (!toValue) toValue = "99999999";

    const nameValue = nameElement.val();

    window.location.href = `${baseUrl}/filter?name=${nameValue}&from=${fromValue}&to=${toValue}&categoryId=${selectedVal}&page=${1}`;
  });
});
