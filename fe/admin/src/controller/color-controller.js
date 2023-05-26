window.colorController = function ($scope, $http, $routeParams) {
  $scope.listColor = [];
  $http.get(colorAPI + "/get-all-color").then(function (response) {
    $scope.listColor = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
