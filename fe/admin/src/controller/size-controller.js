window.sizeController = function ($scope, $http, $routeParams) {
  $scope.listSize = [];
  $http.get(sizeAPI + "/get-all-size").then(function (response) {
    $scope.listSize = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addSize = function () {
    // $http
    //   .post(colorAPI + "/add", $scope.nameColor)
    //   .then(function (response) {});
  };

  $scope.deleteSize = function (idSize) {
    $http.delete(sizeAPI + "/delete/" + idSize).then(function (response) {});
  };

  $scope.getSize = function (idSize) {
    $scope.size = [];
    $http.get(sizeAPI + "/get/" + idSize).then(function (response) {
      $scope.size = response.data;
    });
  };

  $scope.updateSize = function () {
    // console.log(parseJsonToEntity($scope.color));
    // $http
    //   .put(colorAPI + "/update", $scope.color)
    //   .then(function (response) {});
    // console.log($scope.color);
  };
};
