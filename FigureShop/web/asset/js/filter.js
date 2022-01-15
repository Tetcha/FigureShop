$(document).ready(function () {
  const fromElement = $("#fromFilter");
  const fromText = $("#fromFilterText");
  const toElement = $("#toFilter");
  const toText = $("#toFilterText");
  const nameElement = $("#nameFilter");
  const paramValue = {
    name: "",
    from: "",
    to: "",
    categoryId: "",
    page: "",
  };
  if (window.location.href.split("?").length > 1) {
    const paramQueryList = window.location.href.split("?")[1].split("&");

    paramQueryList.forEach((param) => {
      const paramSplitList = param.split("=");
      if (param[1] != "") {
        paramValue[paramSplitList[0]] = paramSplitList[1];
      }
    });
    //set default value for each field
    nameElement.val(paramValue.name);
    fromElement.val(paramValue.from);
    toElement.val(paramValue.to);
    console.log($(`#categoryFilter option[value='${paramValue.categoryId}']`));
    $(`#categoryFilter option[value='${paramValue.categoryId}']`).attr(
      "selected",
      "selected"
    );
  }

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
    const nameValue = nameElement.val();
    if (isNaN(fromValue) || parseInt(fromValue) < 0) {
      fromText.append("From value should be a valid positive number");
      canMove = false;
    }
    if (isNaN(toValue) || parseInt(toValue) <= 0) {
      toText.append("To value should be a valid positive number");
      canMove = false;
    }
    if (parseInt(fromValue) > parseInt(toValue)) {
      toText.append("To value should be higher than from value");
    }
    if (!toValue) toValue = "99999999";
    if (!fromValue) fromValue = "0";
    console.log(canMove);
    if (canMove)
      window.location.href = `${baseUrl}/filter?name=${nameValue}&from=${fromValue}&to=${toValue}&categoryId=${selectedVal}&page=${1}`;
  });
});
