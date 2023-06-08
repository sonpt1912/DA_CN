window.categoryController = function ($scope, $http, $routeParams) {
  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all-category").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addCategory = function () {
    $http
      .post(categoryAPI + "/add" + "?nameCategory=" + $scope.nameCategory)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.deleteCategory = function (idCategory) {
    $http
      .delete(categoryAPI + "/delete/" + idCategory)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.getCategory = function (idCategory) {
    $scope.category = [];
    $http.get(categoryAPI + "/get/" + idCategory).then(function (response) {
      $scope.category = response.data;
    });
  };

  $scope.updateCategory = function () {
    // console.log(parseJsonToEntity($scope.color));
    $http
      .put(categoryAPI + "/update", JSON.parse(JSON.stringify($scope.category)))
      .then(function (response) {
        $scope.init();
      });
    // console.log($scope.color);
  };

  $scope.init = function () {
    $http.get(categoryAPI + "/get-all-category").then(function (response) {
      $scope.listCategory = response.data;
    }),
      function (error) {
        console.log(error);
      };
  };
};
