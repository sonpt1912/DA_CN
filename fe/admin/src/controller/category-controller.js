window.categoryController = function ($scope, $http, $routeParams) {
  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all-category").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addCategory = function () {
    // $http
    //   .post(colorAPI + "/add", $scope.nameColor)
    //   .then(function (response) {});
  };

  $scope.deleteCategory = function (idCategory) {
    $http
      .delete(categoryAPI + "/delete/" + idCategory)
      .then(function (response) {});
  };

  $scope.getCategory = function (idCategory) {
    $scope.category = [];
    $http.get(categoryAPI + "/get/" + idCategory).then(function (response) {
      $scope.category = response.data;
    });
  };

  $scope.updateCategory = function () {
    // console.log(parseJsonToEntity($scope.color));
    // $http
    //   .put(colorAPI + "/update", $scope.color)
    //   .then(function (response) {});
    // console.log($scope.color);
  };
};
