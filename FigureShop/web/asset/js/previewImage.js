$(document).ready(function () {
  const inputFile = $("#imageInputFile");
  const prevImage = $("#defaultImage");

  if (prevImage.val() !== "null") {
    $("#imagePreview").attr("src", prevImage.val());
  }
  inputFile.on("change", function () {
    const reader = new FileReader();
    reader.onload = function () {
      const dataURL = reader.result;
      $("#imagePreview").attr("src", dataURL);
    };
    reader.readAsDataURL(this.files[0]);
  });
});
