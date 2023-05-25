var myApp = angular.module("myModule", ["ngRoute"]);

myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/static", {
      templateUrl: "./page/static.html",
    })
    .when("/login", {
      templateUrl: "./page/login.html",
    })
    .when("/color", {
      templateUrl: "./page/color.html",
    })
    .when("/size", {
      templateUrl: "./page/size.html",
    })
    .when("/brand", {
      templateUrl: "./page/brand.html",
    })
    .when("/product", {
      templateUrl: "./page/product.html",
    })
    .when("/category", {
      templateUrl: "./page/category.html",
    })
    .when("/order", {
      templateUrl: "./page/order.html",
    })
    .when("/voucher", {
      templateUrl: "./page/voucher.html",
    })
    .otherwise({
      redirectTo: "/static",
    });
});
