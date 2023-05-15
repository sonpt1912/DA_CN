window.detailProductController = function ($scope, $routeParams, $http) {
  let id = $routeParams.id;
  // brand
  $scope.brand = [];
  $http.get(brandApi + "/get-by-product/" + id).then(function (response) {
    $scope.brand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // category
  $scope.category = [];
  $http.get(categoryAPI + "/get-by-product/" + id).then(function (response) {
    $scope.category = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // color
  $scope.colors = [];
  $http.get(colorAPI + "/get-by-product/" + id).then(function (response) {
    $scope.colors = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // size
  $scope.sizes = [];
  $http.get(sizeAPI + "/get-by-product/" + id).then(function (response) {
    $scope.sizes = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // detail product
  $scope.detailProduct = [];
  $http
    .get(detailProductAPI + "/get-by-product/" + id)
    .then(function (response) {
      $scope.detailProduct = response.data;
    }),
    function (error) {
      console.log(error);
    };

  // favorite
  $scope.favorite;
  $http
    .get(favoriteAPI + "/get-one-by-customer-product/" + 1 + "/" + id)
    .then(function (response) {
      $scope.favorite = response.data;
    });

  // add product to wish list

  // button toast
  var showToastCheckbox = document.getElementById("showToastCheckbox");
  var toastContainer = document.querySelector(".toast-container");
  var liveToast = document.getElementById("liveToast");
  var toastBody = document.getElementById("toastBody");

  showToastCheckbox.addEventListener("change", function () {
    if (showToastCheckbox.checked) {
      // add
      $http
        .post(favoriteAPI + "/save-favorite/" + 1 + "/" + id)
        .then(function (response) {}),
        function (error) {
          console.log(error);
        };
      // show mess
      showToast("Add to favorites successfully");
    } else {
      $http
        .delete(favoriteAPI + "/delete-favorite/" + 1 + "/" + id)
        .then(function (response) {}),
        function (error) {
          console.log(error);
        };
      showToast("delete from favorites");
    }
  });

  function showToast(message) {
    var clonedToast = liveToast.cloneNode(true);
    var clonedToastBody = clonedToast.querySelector(".toast-body");
    clonedToastBody.textContent = message;
    toastContainer.appendChild(clonedToast);
    var newToast = new bootstrap.Toast(clonedToast);
    newToast.show();
  }
};
