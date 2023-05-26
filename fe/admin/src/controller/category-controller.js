window.categoryController = function ($scope, $http, $routeParams) {
  $scope.listCategory = [];
  $http.get(categoryAPI + "/get-all-category").then(function (response) {
    $scope.listCategory = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
