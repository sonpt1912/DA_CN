var myApp = angular.module("myModule", ["ngRoute"]);

myApp.controller("headerController", function ($scope, $http) {
  // favorite
  $scope.listFavorites = [];
  $http
    .get(favoriteAPI + "/get-all-by-customer/" + 1)
    .then(function (response) {
      $scope.listFavorites = response.data;
    });

  $scope.deleteFavorite = function (id) {
    $http
      .delete(favoriteAPI + "/delete-favorite/" + 1 + "/" + id)
      .then(function (response) {}),
      function (error) {
        console.log(error);
      };
  };

  // cart
  $scope.IdCart = [];
  $http.get(cartAPI + "/get-cart-by-customer/" + 1).then(function (response) {
    $scope.IdCart = response.data;
  });
});

myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/home", {
      templateUrl: "./page/home.html",
      controller: productController,
    })
    .when("/about-us", {
      templateUrl: "./page/about-us.html",
    })
    .when("/blog", {
      templateUrl: "./page/blog.html",
    })
    .when("/shop", {
      templateUrl: "./page/shop.html",
      controller: shopController,
    })
    .when("/cart/:id", {
      templateUrl: "./page/cart.html",
      controller: cartController,
    })
    .when("/checkout/:id", {
      templateUrl: "./page/checkout.html",
      controller: checkoutController,
    })
    .when("/detail-product/:id", {
      templateUrl: "./page/detail-product.html",
      controller: detailProductController,
    })
    .when("/login", {
      templateUrl: "./page/login.html",
    })
    .when("/forgot-password", {
      templateUrl: "./page/forgot-password.html",
    })
    .when("/register", {
      templateUrl: "./page/register.html",
      controller: registerController,
    })
    .when("/customer", {
      templateUrl: "./page/customer.html",
    })
    .otherwise({
      redirectTo: "/login",
    });
});
