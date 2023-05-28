window.productController = function ($scope, $http, $routeParams) {
  $scope.listProduct = [];
  $http.get(productAPI + "/get-all-product").then(function (response) {
    $scope.listProduct = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.listBrand = [];
  $http.get(brandAPI + "/get-all-brand").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all-category").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
