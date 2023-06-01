window.brandController = function ($scope, $http, $routeParams) {
  $scope.listBrand = [];
  $http.get(brandAPI + "/get-all-brand").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addBrand = function () {
    // $http
    //   .post(colorAPI + "/add", $scope.nameColor)
    //   .then(function (response) {});
  };

  $scope.deleteBrand = function (idBrand) {
    $http.delete(brandAPI + "/delete/" + idBrand).then(function (response) {});
  };

  $scope.getBrand = function (idBrand) {
    $scope.brand = [];
    $http.get(brandAPI + "/get/" + idBrand).then(function (response) {
      $scope.brand = response.data;
    });
  };

  $scope.updateBrand = function () {
    // console.log(parseJsonToEntity($scope.color));
    // $http
    //   .put(colorAPI + "/update", $scope.color)
    //   .then(function (response) {});
    // console.log($scope.color);
  };
};
