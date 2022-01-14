$(document).ready(function () {
  const fromElement = $("#fromFilter");
  const fromText = $("#fromFilterText");
  const toElement = $("#toFilter");
  const toText = $("#toFilterText");
  const nameElement = $("#nameFilter");

  let selectedVal = "";
  $("#categoryFilter").change(function (e) {
    e.preventDefault();
    selectedVal = $("#categoryFilter option:selected").val();
  });
  const baseUrl = "http://localhost:8080/FigureShop";
  $("#filterSearchButton").click(function (e) {
    e.preventDefault();
    const canMove = true;
    let fromValue = fromElement.val();
    let toValue = toElement.val();
    console.log(isNaN(fromValue));
    if (isNaN(fromValue)) {
      fromText.append("From value should be a valid number");
      canMove = false;
    }
    if (isNaN(toValue)) {
      fromText.append("To value should be a valid number");
      canMove = false;
    }

    if (!toValue) toValue = "99999999";
    if (!fromValue) fromValue = "0";
    const nameValue = nameElement.val();

     if (canMove)
       window.location.href = `${baseUrl}/filter?name=${nameValue}&from=${fromValue}&to=${toValue}&categoryId=${selectedVal}&page=${1}`;
  });
});
