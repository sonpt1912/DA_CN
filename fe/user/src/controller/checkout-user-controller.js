window.checkoutUserController = function ($scope, $http, $routeParams) {
  $scope.idCart = $routeParams.id;
  $scope.totalPrice = 0;

  // Lấy detail cart
  $scope.listDetailCarts = [];
  $http.get(detailCart + "/get-by-product/" + 1).then(function (response) {
    $scope.listDetailCarts = response.data;
    $scope.calculateTotalPrice();
    $scope.id = response.data.idDetailProduct;
  }),
    function (error) {
      console.log(error);
    };

  // lấy all address
  $scope.listAddress = [];
  $http
    .get(addressAPI + "/get-all-address-by-customer/" + 1)
    .then(function (response) {
      $scope.listAddress = response.data;
    }),
    function (error) {
      console.log(error);
    };

  // $scope.address = [];
  // // lấy address

  // $scope.getAddress = function (idAddress) {
  //   $http.get(addressAPI + "/get-by-id/" + 1).then(function (response) {
  //     $scope.address = response.data;
  //   }),
  //     function (error) {
  //       console.log(error);
  //     };
  // };

  // lấy số tiền của voucher
  $scope.code = "";
  $scope.discountPrice = 0;
  $scope.getVoucher = function () {
    $http
      .get(voucherAPI + "/get-voucher-by-code/" + $scope.code)
      .then(function (response) {
        $scope.discountPrice = response.data;
      }),
      function (e) {
        console.log(e);
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
    if ($scope.discountPrice != 0) {
      return total - $scope.discountPrice.discountAmount;
    }
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
};
