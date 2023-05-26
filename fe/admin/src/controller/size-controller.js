window.sizeController = function ($scope, $http, $routeParams) {
  $scope.listSize = [];
  $http.get(sizeAPI + "/get-all-size").then(function (response) {
    $scope.listSize = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
