window.detailProductController = function (
  $scope,
  $rootScope,
  $routeParams,
  $http
) {
  let id = $routeParams.id;
  $scope.selectColor; // lấy id color

  // form detail-cart

  $scope.formProduct = {
    idProduct: "",
    idCategory: "",
    idBrand: "",
    idColor: "",
    idSize: "",
    quantity: 1,
  };
  $scope.formProduct.idProduct = id;

  // brand
  $scope.brand = [];
  $http.get(brandApi + "/get-by-product/" + id).then(function (response) {
    $scope.brand = response.data;
    $scope.formProduct.idBrand = response.data.id;
  }),
    function (error) {
      console.log(error);
    };

  // category
  $scope.category = [];
  $http.get(categoryAPI + "/get-by-product/" + id).then(function (response) {
    $scope.category = response.data;
    $scope.formProduct.idCategory = response.data.id;
  }),
    function (error) {
      console.log(error);
    };

  // color
  $scope.colors = [];
  $http.get(colorAPI + "/get-by-product/" + id).then(function (response) {
    $scope.colors = response.data;
    if ($scope.colors.length > 0) {
      // lấy id color đầu tiên
      $scope.selectColor = $scope.colors[0].id;
      $scope.getSize($scope.selectColor);
    }
  }),
    function (error) {
      console.log(error);
    };
  // size
  $scope.getSize = function (idColor) {
    $scope.formProduct.idColor = idColor;
    $scope.sizes = [];
    $http
      .get(sizeAPI + "/get-by-product/" + id + "/" + idColor)
      .then(function (response) {
        $scope.sizes = response.data;
        $scope.getIdSize($scope.sizes[0].id);
      }),
      function (error) {
        console.log(error);
      };
  };

  // get idSize
  $scope.getIdSize = function (idSize) {
    $scope.formProduct.idSize = idSize;
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
      console.log(response.data);
    });

  // add to detail cart
  $scope.addToCart = function () {
    $http
      .post(detailCart + "/add-detail-cart", $scope.formProduct)
      .then(function (response) {});
  };

  // get quantity
  $scope.checkInputValue = function () {
    var input = document.querySelector("#form1");
    var value = $scope.formProduct.quantity;

    if (isNaN(value) || value === 0 || value < 1) {
      $scope.formProduct.quantity = 1;
    }
  };

  // tăng và giảm
  $scope.decreaseQuantity = function () {
    if ($scope.formProduct.quantity > 1) {
      $scope.formProduct.quantity--;
    }
  };

  $scope.increaseQuantity = function () {
    $scope.formProduct.quantity++;
  };

  // add product to wish list
  // button toast
  var showToastCheckbox = document.getElementById("showToastCheckbox");
  var showToastAddToCart = document.getElementById("showToastAddToCart");
  var toastContainer = document.querySelector(".toast-container");
  var liveToast = document.getElementById("liveToast");
  var addToat = document.getElementById("addToat");
  var toastBody = document.getElementById("toastBody");

  showToastCheckbox.addEventListener("change", function () {
    if (showToastCheckbox.checked) {
      // add
      $http
        .post(favoriteAPI + "/save-favorite/" + 1 + "/" + id)
        .then(function (response) {
          $http
            .get(favoriteAPI + "/get-all-by-customer/" + 1)
            .then(function (response) {
              $rootScope.favoriteCount = $rootScope.favoriteCount + 1;
              $rootScope.listFavorites = response.data;
              showToast("Add to favorites successfully");
            });
          console.log(error);
        }),
        function (error) {};
      // show mess
    } else {
      $http
        .delete(favoriteAPI + "/delete-favorite/" + 1 + "/" + id)
        .then(function (response) {
          $http
            .get(favoriteAPI + "/get-all-by-customer/" + 1)
            .then(function (response) {
              $rootScope.listFavorites = response.data;
              $rootScope.favoriteCount = $rootScope.favoriteCount - 1;
            });
          console.log(error);
        }),
        function (error) {};
      showToast("delete from favorites");
    }
  });

  showToastAddToCart.addEventListener("click", function () {
    showToast("Add to cart successfully");
    $scope.addToCart();
  });

  function showToast(message) {
    var clonedToast = liveToast.cloneNode(true);
    var clonedToastBody = clonedToast.querySelector(".toast-body");
    clonedToastBody.textContent = message;
    toastContainer.appendChild(clonedToast);
    var newToast = new bootstrap.Toast(clonedToast);
    newToast.show();
  }
  // alert show toat add to cart
};
