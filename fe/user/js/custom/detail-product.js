function checkInputValue() {
  var input = document.querySelector("#form1");
  var value = parseInt(input.value);

  if (isNaN(value) || value === 0 || value < 1) {
    input.value = 1;
  }
}
