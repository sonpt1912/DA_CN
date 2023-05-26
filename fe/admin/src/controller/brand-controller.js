window.brandController = function ($scope, $http, $routeParams) {
  $scope.listBrand = [];
  $http.get(brandAPI + "/get-all-brand").then(function (response) {
    $scope.listBrand = response.data;
  }),
    function (error) {
      console.log(error);
    };
};
