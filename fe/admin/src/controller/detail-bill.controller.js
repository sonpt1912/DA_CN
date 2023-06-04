window.detailBillController = function ($scope, $http, $routeParams) {
  var idBill = $routeParams.id;
  // get bill
  $scope.bill = [];
  $http.get(billAPI + "/get-by-bill/" + idBill).then(function (response) {
    $scope.bill = response.data;
  });

  // get customer
  $scope.customer = [];
  $http.get(customerAPI + "/get-by-bill/" + idBill).then(function (response) {
    $scope.customer = response.data;
  });

  // get list Detial bill
  $scope.listDetailBill = [];
  $http
    .get(detailBillAPI + "/get-detail-bill-by-bill/" + idBill)
    .then(function (response) {
      $scope.listDetailBill = response.data;
    });

  // cancel
  $scope.cancelBill = function (idBill) {
    $http
      .put(billAPI + "/cancel-status-bill/" + idBill)
      .then(function (response) {
        $scope.init();
      });
  };

  // next status
  $scope.nextStatus = function (status, idBill) {
    $http
      .put(billAPI + "/update-status-bill/" + idBill + "?status=" + status)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.init = function () {
    $http.get(billAPI + "/get-by-bill/" + idBill).then(function (response) {
      $scope.bill = response.data;
    });

    $scope.customer = [];
    $http.get(customerAPI + "/get-by-bill/" + idBill).then(function (response) {
      $scope.customer = response.data;
    });

    $http
      .get(detailBillAPI + "/get-detail-bill-by-bill/" + idBill)
      .then(function (response) {
        $scope.listDetailBill = response.data;
      });
  };
};
