window.cartController = function ($scope, $routeParams, $http) {
  $scope.idCart = $routeParams.id;
  $scope.totalPrice = 0;

  // Lấy detail cart
  $scope.listDetailCarts = [];
  $http
    .get(detailCart + "/get-by-product/" + $scope.idCart)
    .then(function (response) {
      $scope.listDetailCarts = response.data;
      $scope.calculateTotalPrice();
      $scope.id = response.data.idDetailProduct;
    }),
    function (error) {
      console.log(error);
    };

  // xóa detail cart
  $scope.deleteDetailCart = function (idDetailProduct) {
    $http
      .get(
        detailCart +
          "/delete-detail-cart/" +
          $scope.idCart +
          "/" +
          idDetailProduct
      )
      .then(function (response) {
        $scope.listDetailCarts = response.data;
        $scope.calculateTotalPrice();
        $scope.id = response.data.idDetailProduct;
      }),
      function (error) {
        console.log(error);
      };
  };

  //tính thuế tax
  $scope.calculateTax = function () {
    var taxRate = 0.1; // Tỷ lệ thuế là 10%
    var tax = $scope.totalPrice * taxRate;
    return tax;
  };

  // tổng tiền sau thuế
  $scope.calculateToTal = function () {
    var total = $scope.totalPrice + $scope.calculateTax();
    return total;
  };

  // tính tổng tiền của sản phẩm
  $scope.calculateTotalPrice = function () {
    $scope.totalPrice = 0;
    for (var i = 0; i < $scope.listDetailCarts.length; i++) {
      var detailCart = $scope.listDetailCarts[i];
      var price = detailCart.price;
      var quantity = detailCart.quantity;
      $scope.totalPrice += price * quantity;
    }
  };

  // nếu sản phẩm tăng lên
  $scope.increaseQuantity = function (detailCart) {
    if (detailCart.quantity < 100) {
      detailCart.quantity++;
    }
    $scope.calculateTotalPrice();
  };

  // nếu giảm đi
  $scope.decreaseQuantity = function (detailCart) {
    if (detailCart.quantity > 1) {
      detailCart.quantity--;
    }
    $scope.calculateTotalPrice();
  };

  //nếu sửa trong ô input
  $scope.checkInputValue = function (detailCart) {
    var value = parseInt(detailCart.quantity);

    if (isNaN(value) || value < 1) {
      detailCart.quantity = 1;
    } else if (value > 100) {
      detailCart.quantity = 100;
    }

    $scope.calculateTotalPrice();
  };
};
