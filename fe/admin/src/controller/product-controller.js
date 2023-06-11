window.productController = function ($scope, $http, $routeParams) {
  $scope.searchByName = "";
  $scope.listProduct = [];

  $scope.getProduct = function () {
    $http
      .get(productAPI + "/get-all-product?name=" + $scope.searchByName)
      .then(function (response) {
        $scope.listProduct = response.data;
      }),
      function (error) {
        console.log(error);
      };
  };

  // get list brand
  $scope.listBrand = [];
  $http.get(brandAPI + "/get-all-brand").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // get list cate
  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all-category").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // function add product
  $scope.addProduct = function () {
    console.log($scope.checkProduct);
  };

  // editPorudct
  $scope.editPorudct = function (idProduct) {
    $http
      .get(productAPI + "/get-response/" + idProduct)
      .then(function (response) {
        $scope.product = response.data;
      });
  };

  // get list color
  $scope.listColor = [];
  $http.get(colorAPI + "/get-color-by-status").then(function (response) {
    $scope.listColor = response.data;
  });

  $scope.getProduct();
};
