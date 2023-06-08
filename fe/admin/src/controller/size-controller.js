window.sizeController = function ($scope, $http, $routeParams) {
  $scope.listSize = [];
  $http.get(sizeAPI + "/get-all-size").then(function (response) {
    $scope.listSize = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addSize = function () {
    $http
      .post(sizeAPI + "/add" + "?nameSize=" + $scope.nameSize)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.deleteSize = function (idSize) {
    $http.delete(sizeAPI + "/delete/" + idSize).then(function (response) {
      $scope.init();
    });
  };

  $scope.getSize = function (idSize) {
    $scope.size = [];
    $http.get(sizeAPI + "/get/" + idSize).then(function (response) {
      $scope.size = response.data;
    });
  };

  $scope.updateSize = function () {
    // console.log(parseJsonToEntity($scope.color));
    $http
      .put(sizeAPI + "/update", JSON.parse(JSON.stringify($scope.size)))
      .then(function (response) {
        $scope.init();
      });
    // console.log($scope.color);
  };

  $scope.init = function () {
    $http.get(sizeAPI + "/get-all-size").then(function (response) {
      $scope.listSize = response.data;
    }),
      function (error) {
        console.log(error);
      };
  };
};
