window.productController = function ($http, $scope, $routeParams) {
  // get all products
  $scope.listProduct = [];
  $http.get(productAPI + "/get-3-new-product").then(function (response) {
    $scope.listProduct = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
