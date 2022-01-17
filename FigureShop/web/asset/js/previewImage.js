$(document).ready(function () {
  const inputFile = $("#imageInputFile");
  inputFile.on("change", function () {
    const reader = new FileReader();
    reader.onload = function () {
      const dataURL = reader.result;
      $("#imagePreview").attr("src", dataURL);
    };
    reader.readAsDataURL(this.files[0]);
  });
});
