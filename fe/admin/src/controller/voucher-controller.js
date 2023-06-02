window.voucherController = function ($scope, $http) {
  $scope.listVoucher = [];
  $http.get(voucherAPI + "/get-all").then(function (response) {
    $scope.listVoucher = response.data;
  });
};
