window.orderHistory = function ($scope, $http, $routeParams) {
  $scope.IdCart = [];
  $http.get(cartAPI + "/get-cart-by-customer/" + 1).then(function (response) {
    $scope.IdCart = response.data;
  });

  // chuyển trang
  $scope.redirectToDetail = function redirectToDetail(billId) {
    window.location.href = "#detail-bill/" + billId;
  };

  $scope.getBill = function (idCustomer, status) {
    $scope.listBill = [];
    $http
      .get(billAPI + "/get-all-by-customer-status/" + idCustomer + "/" + status)
      .then(function (response) {
        $scope.listBill = response.data;
        console.log($scope.listBill);
      });
  };

  $scope.getBill(1, 0);
};
