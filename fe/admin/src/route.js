var myApp = angular.module("myModule", ["ngRoute"]);

myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/static", {
      templateUrl: "./page/static.html",
      controller: staticController,
    })
    .when("/login", {
      templateUrl: "./page/login.html",
    })
    .when("/color", {
      templateUrl: "./page/color.html",
      controller: colorController,
    })
    .when("/size", {
      templateUrl: "./page/size.html",
      controller: sizeController,
    })
    .when("/brand", {
      templateUrl: "./page/brand.html",
      controller: brandController,
    })
    .when("/product", {
      templateUrl: "./page/product.html",
      controller: productController,
    })
    .when("/category", {
      templateUrl: "./page/category.html",
      controller: categoryController,
    })
    .when("/order", {
      templateUrl: "./page/order.html",
      controller: orderController,
    })
    .when("/customer", {
      templateUrl: "./page/customer.html",
      controller: customerController,
    })
    .when("/voucher", {
      templateUrl: "./page/voucher.html",
      controller: voucherController,
    })
    .when("/detail-bill/:id", {
      templateUrl: "./page/detail-bill.html",
      controller: detailBillController,
    })
    .otherwise({
      redirectTo: "/static",
    });
});
