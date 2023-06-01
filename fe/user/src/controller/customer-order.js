window.orderHistory = function ($scope, $http, $routeParams) {
  $scope.getBill = function (idCustomer, status) {
    $scope.listBill = [];
    $http
      .get(billAPI + "/get-all-by-customer-status/" + idCustomer + "/" + status)
      .then(function (response) {
        $scope.listBill = response.data;
      });
  };
};
