window.orderHistory = function ($scope, $http, $routeParams) {
  $scope.IdCart = [];
  $http.get(cartAPI + "/get-cart-by-customer/" + 1).then(function (response) {
    $scope.IdCart = response.data;
  });

  $scope.getBill = function (idCustomer, status) {
    $scope.listBill = [];
    $http
      .get(billAPI + "/get-all-by-customer-status/" + idCustomer + "/" + status)
      .then(function (response) {
        $scope.listBill = response.data;
      });
  };
};
