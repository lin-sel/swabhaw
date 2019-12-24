(function (angular) {
    // propertybinding
    // eventbinding
    // stylebinding
    const CLASS_SHOW = 'show-data';
    const CLASS_HIDE = 'hide-data';
    const file = 'products.json';
    const app = angular.module('product-app', ['ngRoute', 'ngRateIt']);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            controller: 'welcomeHome',
            templateUrl: '/fragment/welcome.html'
        }).when('/productlist', {
            controller: 'productlist',
            templateUrl: '/fragment/productlist.html'
        }).when('/productdetail/:id', {
            controller: 'productdetail',
            templateUrl: '/fragment/productdetail.html'
        }).otherwise({ templateUrl: '/fragment/404.html' });
    }]);

    app.filter('productfilter', function () {
        return function (input) {

        }
    });

    // app.directive('starRating', function () {
    //     return {
    //         templateUrl: '/fragment/ng-rate-it.html'
    //     }
    // });

    app.factory('productService', ['$http', '$q', function ($http, $q) {
        var productservice = {};
        productservice.productlist = [];
        console.log(productservice.productlist);
        productservice.getProduct = function () {
            return $q(function (resolve, reject) {
                console.log("inside fetch");
                $http({
                    method: 'GET',
                    url: file
                }).then(function (res) {
                    console.log("Inside ");
                    productservice.productlist = res.data;
                    console.log(productservice.productlist);
                    resolve({ status: true, msg: "Completed" });
                }, function (err) {
                    reject({ status: false, msg: err });
                });
            });
        }
        return productservice;
    }]);

    app.controller('welcomeHome', ['$scope', 'productService', function ($scope, productService) {
        $scope.message = "Welcome To Home Page";
        productService.getProduct().then(function (res) {

        }).catch(function (res) {
            console.log(res);
        });
    }]);

    app.controller('productlist', ['$scope', 'productService', '$window', function ($scope, productService, $window) {
        $scope.class = CLASS_SHOW;
        $scope.title = 'Hide Image';
        $scope.log = "";
        if (productService.productlist.length == 0) {
            productService.getProduct().then(function (res) {
                console.log(productService.productlist);
                $scope.itemlist = productService.productlist;
            }).catch(function (res) {
                console.log(res);
            });
        }
        else {
            $scope.itemlist = productService.productlist;
        }
        $scope.productDetails = function (id) {
            $window.location.href = '#!/productdetail/' + id;
        }

        $scope.imageButtonClick = function () {
            if ($scope.class == CLASS_SHOW) {
                $scope.class = CLASS_HIDE;
                $scope.title = 'Show Image';
                return;
            }
            $scope.class = CLASS_SHOW;
            $scope.title = CLASS_HIDE;
        }
    }]);

    app.controller('productdetail', ['$scope', '$routeParams', 'productService', '$window', function ($scope, $routeParams, productService, $window) {
        for (let i = 0; i < productService.productlist.length; i++) {
            if (productService.productlist[i].productId == $routeParams.id) {
                $scope.item = productService.productlist[i];
                console.log(productService.productlist[i]);
            }
        }

        $scope.returnBack = function () {
            $window.location.href = '#!/productlist';
        }
    }]);
}(window.angular));