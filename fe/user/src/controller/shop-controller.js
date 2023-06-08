window.shopController = function ($http, $scope, $routeParams, $rootScope) {
  $scope.currentPage = 0;
  // $scope.listProduct = [];
  $http.get(productAPI + "/get-all").then(function (response) {
    $scope.listProduct = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.totalPages = 0; // Số trang tổng cộng (có thể tính toán từ dữ liệu)
  $http.get(productAPI + "/get-total-pages").then(function (response) {
    $scope.totalPages = parseInt(response.data);
  });

  // hàm set page
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
      .get(productAPI + "/get-all?pageNumber=" + $scope.currentPage)
      .then(function (response) {
        $scope.listProduct = response.data;
      }),
      function (error) {
        console.log(error);
      };
  };

  // get all brand
  $scope.listBrand = [];
  $http.get(brandApi + "/get-all").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // category
  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // get all size
  $scope.listSize = [];
  $http.get(sizeAPI + "/get-all").then(function (response) {
    $scope.listSize = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // get all color
  $scope.listColor = [];
  $http.get(colorAPI + "/get-all").then(function (response) {
    $scope.listColor = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
