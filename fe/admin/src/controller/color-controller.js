window.colorController = function ($scope, $http, $routeParams) {
  $scope.listColor = [];
  $http.get(colorAPI + "/get-all-color").then(function (response) {
    $scope.listColor = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addColor = function () {
    // $http
    //   .post(colorAPI + "/add", $scope.nameColor)
    //   .then(function (response) {});
  };

  $scope.deleteColor = function (idColor) {
    $http.delete(colorAPI + "/delete/" + idColor).then(function (response) {});
  };

  $scope.getColor = function (idColor) {
    $scope.color = [];
    $http.get(colorAPI + "/get/" + idColor).then(function (response) {
      $scope.color = response.data;
    });
  };

  $scope.updateColor = function () {
    // console.log(parseJsonToEntity($scope.color));
    // $http
    //   .put(colorAPI + "/update", $scope.color)
    //   .then(function (response) {});
    // console.log($scope.color);
  };
};
