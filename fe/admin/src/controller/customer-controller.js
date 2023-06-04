window.customerController = function ($http, $scope) {
  $scope.listCustomer = [];
  $http.get(customerAPI + "/get-all-customer").then(function (response) {
    $scope.listCustomer = response.data;
  });

  $scope.deleteCustomer = function (idCustomer) {
    $http
      .delete(customerAPI + "/delete/" + idCustomer)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.init = function () {
    $http.get(customerAPI + "/get-all-customer").then(function (response) {
      $scope.listCustomer = response.data;
    });
  };
};
