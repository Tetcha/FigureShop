$(document).ready(function () {
  const fromElement = $("#fromFilter");
  const fromText = $("#fromFilterText");
  const toElement = $("#toFilter");
  const toText = $("#toFilterText");
  const nameElement = $("#nameFilter");
  const userSearchButton = $("#filterSearchButton");
  const adminSearchButton = $("#filterAdminSearchButton");
  const paramValue = {
    name: "",
    from: "",
    to: "",
    categoryId: "",
    page: "",
  };
  let canMove = true;
  let fromValue = "0";
  let toValue = "99999999";
  let nameValue = "";
  if (window.location.href.split("?").length > 1) {
    const paramQueryList = window.location.href.split("?")[1].split("&");

    paramQueryList.forEach((param) => {
      const paramSplitList = param.split("=");
      if (param[1] != "") {
        paramValue[paramSplitList[0]] = decodeURI(paramSplitList[1]).trim();
      }
    });
    //set default value for each field
    nameElement.val(paramValue.name);
    fromElement.val(paramValue.from);
    toElement.val(paramValue.to);
    $(`#categoryFilter option[value='${paramValue.categoryId}']`).attr(
      "selected",
      "selected"
    );
  }

  let selectedVal = $("#categoryFilter option:selected").val();
  $("#categoryFilter").change(function (e) {
    e.preventDefault();
    selectedVal = $("#categoryFilter option:selected").val();
  });
  const baseUrl = `http://${window.location.host}/FigureShop`;
  const actionOnClick = () => {
    canMove = true;
    fromValue = fromElement.val().trim().replace(" ", "");
    toValue = toElement.val().trim().replace(" ", "");
    nameValue = nameElement
      .val()
      .trim()
      .replace(/[ ]{2,}/, " ");
    if (isNaN(fromValue) || parseInt(fromValue) < 0) {
      fromText.text("From value should be a valid positive number");
      canMove = false;
    }
    if (isNaN(toValue) || parseInt(toValue) <= 0) {
      toText.text("To value should be a valid positive number");
      canMove = false;
    }
    if (parseInt(fromValue) > parseInt(toValue)) {
      toText.text("To value should be higher than from value");
      canMove = false;
    }
    if (!toValue) toValue = "99999999";
    if (!fromValue) fromValue = "0";
  };
  userSearchButton.click(function (e) {
    e.preventDefault();
    actionOnClick();
    if (canMove)
      window.location.href = `${baseUrl}/filter?name=${nameValue}&from=${fromValue}&to=${toValue}&categoryId=${selectedVal}&page=${1}`;
  });

  adminSearchButton.click(function (e) {
    e.preventDefault();
    actionOnClick();
    if (canMove)
      window.location.href = `${baseUrl}/adminProduct?name=${nameValue}&from=${fromValue}&to=${toValue}&categoryId=${selectedVal}&page=${1}`;
  });
});
