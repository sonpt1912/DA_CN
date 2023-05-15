var myApp = angular.module("myModule", ["ngRoute"]);

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
    .when("/cart", {
      templateUrl: "./page/cart.html",
    })
    .when("/checkout", {
      templateUrl: "./page/checkout-guest.html",
    })
    .when("/detail-product/:id", {
      templateUrl: "./page/detail-product.html",
      controller: detailProductController,
    })
    .when("/login", {
      templateUrl: "./page/login.html",
    })
    .when("/register", {
      templateUrl: "./page/register.html",
      controller: registerController,
    })
    .otherwise({
      redirectTo: "/checkout",
    });
});
