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
    }),
    function (error) {
      console.log(error);
    };

  //
  $scope.quantity = function () {
    return $scope.bill.totalPrice - $scope.voucher.discountAmount;
  };

  //
  function setProgressBarColor() {
    var progressBar = document.getElementById("progress-bar");
    var progressValue = parseInt(progressBar.innerText);

    if (progressValue >= 0 && progressValue < 25) {
      progressBar.className = "progress-bar w-25 bg-primary";
    } else if (progressValue >= 25 && progressValue < 50) {
      progressBar.className = "progress-bar w-50 bg-success";
    } else if (progressValue >= 50 && progressValue < 75) {
      progressBar.className = "progress-bar w-75 bg-warning";
    } else if (progressValue >= 75 && progressValue <= 100) {
      progressBar.className = "progress-bar w-100 bg-danger";
    }
  }

  setProgressBarColor();
};
