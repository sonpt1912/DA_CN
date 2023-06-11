window.orderController = function ($scope, $http) {
  // list bill
  $scope.listBill = [];
  $http.get(billAPI + "/get-all").then(function (response) {
    $scope.listBill = response.data;
  });

  $scope.search = function () {
    $scope.totalPages = 0; // Số trang tổng cộng (có thể tính toán từ dữ liệu)
    $http.get(billAPI + "/get-total-pages-bill").then(function (response) {
      $scope.totalPages = parseInt(response.data);
      console.log(parseInt(response.data));
    });

    $scope.setPage = function (page) {
      // Kiểm tra và giới hạn giá trị của currentPage
      if (page < 0) {
        $scope.currentPage = 0;
      } else if (page > $scope.totalPages) {
        $scope.currentPage = $scope.totalPages;
      } else {
        $scope.currentPage = page;
      }

      $http
        .get(billAPI + "/get-all?pageNumber=" + $scope.currentPage)
        .then(function (response) {
          $scope.listBill = response.data;
        }),
        function (error) {
          console.log(error);
        };
    };
  };

  $scope.search();

  $scope.redirectToDetail = function redirectToDetail(billId) {
    window.location.href = "#detail-bill/" + billId;
  };
};
