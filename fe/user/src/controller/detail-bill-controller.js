window.detailBillController = function ($scope, $http, $routeParams) {
  $scope.idBill = $routeParams.id;

  // lấy thông tin customer
  $scope.customer = [];
  $http.get(customerAPI + "/get-one-by-id/" + 1).then(function (response) {
    $scope.customer = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // lấy thông tin bill
  $scope.bill = [];
  $http.get(billAPI + "/get-by-id/" + $scope.idBill).then(function (response) {
    $scope.bill = response.data;
  });

  // lấy thông tin voucher
  $scope.voucher = [];
  $http
    .get(voucherAPI + "/get-voucher-by-bill/" + $scope.idBill)
    .then(function (response) {
      $scope.voucher = response.data;
    });

  // lấy thông tin detail bill
  $scope.listDetailBill = [];
  $http
    .get(detailBillAPI + "/get-by-bill/" + $scope.idBill)
    .then(function (response) {
      $scope.listDetailBill = response.data;

      // Tính tổng tiền
      $scope.price = 0;
      for (let i = 0; i < $scope.listDetailBill.length; i++) {
        $scope.price +=
          $scope.listDetailBill[i].price * $scope.listDetailBill[i].quantity;
      }
    })
    .catch(function (error) {
      console.log(error);
    });

  // lấy voucher by id
  $scope.voucher = [];
  $http
    .get(voucherAPI + "/get-voucher-by-bill/" + $scope.idBill)
    .then(function (response) {
      $scope.voucher = response.data;
    });

  $scope.init = function () {
    $http
      .get(billAPI + "/get-by-id/" + $scope.idBill)
      .then(function (response) {
        $scope.bill = response.data;
      });
    $http
      .get(detailBillAPI + "/get-by-bill/" + $scope.idBill)
      .then(function (response) {
        $scope.listDetailBill = response.data;
      }),
      function (error) {
        console.log(error);
      };
  };

  $scope.cancelBill = function (idBill) {
    $http
      .put(billAPI + "/cancel-status-bill/" + idBill)
      .then(function (response) {
        $scope.init();
      });
  };

  //
};
