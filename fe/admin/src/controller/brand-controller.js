window.brandController = function ($scope, $http, $routeParams) {
  $scope.listBrand = [];
  $http.get(brandAPI + "/get-all-brand").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addBrand = function () {
    let nameBrand = $scope.nameBrand;
    $http
      .post(brandAPI + "/add" + "?nameBrand=" + nameBrand)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.deleteBrand = function (idBrand) {
    $http.delete(brandAPI + "/delete/" + idBrand).then(function (response) {
      $scope.init();
    });
  };

  $scope.getBrand = function (idBrand) {
    $scope.brand = [];
    $http.get(brandAPI + "/get/" + idBrand).then(function (response) {
      $scope.brand = response.data;
    });
  };

  $scope.updateBrand = function () {
    console.log("s");
    $http
      .put(brandAPI + "/update", JSON.parse(JSON.stringify($scope.brand)))
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.init = function () {
    $http.get(brandAPI + "/get-all-brand").then(function (response) {
      $scope.listBrand = response.data;
    }),
      function (error) {
        console.log(error);
      };
  };
};
