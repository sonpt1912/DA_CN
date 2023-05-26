window.productController = function ($scope, $http, $routeParams) {
  $scope.listProduct = [];
  $http.get(productAPI + "/get-all-product").then(function (response) {
    $scope.listProduct = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
