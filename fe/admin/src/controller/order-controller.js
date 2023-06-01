window.orderController = function ($scope, $http) {
  $scope.listBill = [];
  $http.get(billAPI + "/get-all").then(function (response) {
    $scope.listBill = response.data;
  });
};
