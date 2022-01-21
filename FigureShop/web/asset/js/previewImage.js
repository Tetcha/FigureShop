$(document).ready(function () {
  const inputFile = $("#imageInputFile");
  const prevImage = $("#defaultImage");
  const errorMessage = $("#imageError");
  if (prevImage.val() !== "null") {
    $("#imagePreview").attr("src", prevImage.val());
  }
  inputFile.on("change", function () {
    const reader = new FileReader();
    const inputType = inputFile.val().split("\\")[2].split(".")[1];
    reader.onload = function () {
      const dataURL = reader.result;
      if (inputType.match(/jpg|jpeg|png/)) {
        $("#imagePreview").attr("src", dataURL);
      } else {
        console.log(errorMessage);
        errorMessage.text("The image should be jpg, jpeg or png");
      }
    };
    reader.readAsDataURL(this.files[0]);
  });
});
