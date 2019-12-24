(function (angular) {

    const key = 'EM_KEY';
    const credential = {
        username: 'Nilesh',
        password: 'root'
    };
    var app = angular.module('employeeApp', ['ngRoute']);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            controller: 'homeController',
            templateUrl: '/fragment/home.html'
        }).when('/update/:id', {
            controller: 'updateController',
            templateUrl: '/fragment/update.html'
        }).when('/add', {
            controller: 'AddController',
            templateUrl: '/fragment/add.html'
        }).when('/login/:url', {
            controller: 'loginController',
            templateUrl: '/fragment/login.html'
        });
    }]);

    app.factory('EmployeeService', ['$q', function ($q) {
        var service = {};

        service.data = [];
        service.get = function () {
            return $q(function (resolve, reject) {
                if (service.data.length == 0) {
                    service.data = JSON.parse(localStorage.getItem(key));
                    if (service.data == null) {
                        service.data = [];
                    }
                    resolve(service.data);
                }
                resolve(service.data);
            });
        }

        service.getId = function (id) {
            return $q(function (resolve, reject) {
                service.data.forEach(element => {
                    if (element.id == id) {
                        resolve(element);
                    }
                });
                reject({ status: false, msg: 'Employee Id Not Valid' });
            });
        }

        service.add = function (empData) {
            return $q(function (resolve, reject) {
                let len = service.data.length;
                service.data.push(empData);
                if (len < service.data.length) {
                    service.localStorageAdd();
                    resolve({ status: true, msg: "Added Successfully" });
                }
                else {
                    reject({ status: false, msg: "Failed to Add" });
                }
            });
        }

        service.update = function (empData) {
            return $q(function (resolve, reject) {
                for (let i = 0; i < service.data.length; i++) {
                    console.log(service.data[i].id, empData.id);
                    if (service.data[i].id == empData.id) {
                        service.data[i] = empData;
                        service.localStorageAdd();
                        resolve({ status: true, msg: "Updated" });
                    }
                }
                reject({ status: false, msg: "Failed to Update" });
            });
        }

        service.localStorageAdd = function () {
            localStorage.setItem(key, angular.toJson(service.data));
        }

        return service;
    }]);

    app.controller('homeController', ['$scope', 'EmployeeService', '$window', function ($scope, EmployeeService, $window) {
        EmployeeService.get().then(function (res) {
            $scope.empdata = EmployeeService.data;
            console.log(EmployeeService.data);
        });

        $scope.delete = function (id) {
            $window.location.href = '#!/login';
            let empd = [];
            for (let i = 0; i < $scope.empdata.length; i++) {
                if ($scope.empdata[i].id !== id) {
                    empd.push($scope.empdata[i]);
                }
            }
            EmployeeService.data = empd;
            EmployeeService.localStorageAdd();
            alert('Deleted SuccessFully');
            $window.location.href = '/';
        }

        $scope.reDirect = function (afterloginurl) {
            $window.location.href = '#!/login/' + $scope.encrypturl(afterloginurl);
        }

        $scope.encrypturl = function (data) {
            console.log(data);
            let n = [];
            for (let i = 0; i < data.length; i++) {
                n[i] = data.charCodeAt(i);
            }
            let stp = '';
            for (let i = 0; i < n.length; i++) {
                stp = stp.concat(n[i] + ':');
            }
            return stp;
        }

    }]);

    app.controller('loginController', ['$scope', '$window', '$routeParams', function ($scope, $window, $routeParams) {
        console.log($routeParams.url);
        $scope.login = function () {
            if ($scope.login.uname == credential.username) {
                if ($scope.login.password == credential.password) {
                    alert('Authentication Successfully Completed');
                    $window.location.href = '#!/' + $scope.decryptUrl($routeParams.url);
                    return;
                }
                alert("Authentication failed");
                return;
            }
            alert("Authentication failed");
        }

        $scope.decryptUrl = function (url) {
            var letter = url.split(":");
            var ur = '';
            for (let i = 0; i < letter.length - 1; i++) {
                ur = ur + String.fromCharCode(Number(letter[i]));
            }
            return ur;

        }
    }]);
    app.controller('updateController', ['$scope', 'EmployeeService', '$routeParams', '$window', function ($scope, EmployeeService, $routeParams, $window) {
        console.log(typeof $routeParams.id);
        EmployeeService.get();
        for (let i = 0; i < EmployeeService.data.length; i++) {
            console.log(typeof EmployeeService.data[i].id);
            if (EmployeeService.data[i].id == $routeParams.id) {
                $scope.emp = EmployeeService.data[i];
            }
        }

        console.log($scope.emp);

        $scope.edit = function () {
            console.log($scope.emp);
            EmployeeService.update($scope.emp).then(function (res) {
                alert("Updated Successfully");
                $window.location.href = '/';
            }).catch(function (e) {
                console.log("edit Error");
            });
        }


    }]);

    app.controller('AddController', ['$scope', 'EmployeeService', '$window', function ($scope, EmployeeService, $window) {
        EmployeeService.get();
        let len = EmployeeService.data.length;
        $scope.empdata = {
            id: len + 1,
            name: null,
            salary: null
        };
        console.log($scope.empdata);
        $scope.empAdd = function () {
            EmployeeService.add($scope.empdata).then(function (res) {
                alert(res.msg);
                $window.location.href = '/';
            }).catch(function (e) {
                console.log("Add Error");
            });
        }

    }]);


}(window.angular))