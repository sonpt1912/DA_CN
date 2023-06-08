window.colorController = function ($scope, $http, $routeParams) {
  $scope.listColor = [];
  $http.get(colorAPI + "/get-all-color").then(function (response) {
    $scope.listColor = response.data;
  }),
    function (error) {
      console.log(error);
    };

  $scope.addColor = function () {
    let nameColor = $scope.nameColor;
    console.log(nameColor);
    $http
      .post(colorAPI + "/add" + "?nameColor=" + nameColor)
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.deleteColor = function (idColor) {
    $http.delete(colorAPI + "/delete/" + idColor).then(function (response) {
      $scope.init();
    });
  };

  $scope.getColor = function (idColor) {
    $scope.color = [];
    $http.get(colorAPI + "/get/" + idColor).then(function (response) {
      $scope.color = response.data;
    });
  };

  $scope.updateColor = function () {
    $http
      .put(colorAPI + "/update", JSON.parse(JSON.stringify($scope.color)))
      .then(function (response) {
        $scope.init();
      });
  };

  $scope.init = function () {
    $http.get(colorAPI + "/get-all-color").then(function (response) {
      $scope.listColor = response.data;
    }),
      function (error) {
        console.log(error);
      };
  };
};
