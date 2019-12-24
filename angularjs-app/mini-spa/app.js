(function (angular) {
    var miniapp = angular.module('minispa', ['ngRoute']);

    miniapp.config(['$routeProvider', function ($routeProvider) {
        console.log("inside contro");
        $routeProvider.when('/', {
            controller: 'homeController',
            templateUrl: '/fragment/home.html'
        }).when('/career', {
            controller: 'careerController',
            templateUrl: '/fragment/career.html'
        }).when('/about', {
            controller: 'aboutController',
            templateUrl: '/fragment/about.html'
        }).when('/home', {
            controller: 'homeController',
            templateUrl: '/fragment/home.html'
        });
    }]);

    miniapp.controller('homeController', ['$scope', function ($scope) {
        $scope.message = "At Home";
    }]);

    miniapp.controller('careerController', ['$scope', function ($scope) {
        $scope.message = "At Career";
    }]);

    miniapp.controller('aboutController', ['$scope', function ($scope) {
        $scope.message = "At About";
    }])
}(window.angular));