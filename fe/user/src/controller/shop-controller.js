window.shopController = function ($http, $scope, $routeParams) {
  // $scope.listProduct = [];
  $http.get(productAPI + "/get-all").then(function (response) {
    $scope.listProduct = response.data;
  }),
    function (error) {
      console.log(error);
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
