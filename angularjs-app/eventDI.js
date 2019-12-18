(function (angular) {
    var studentData = [
        {
            name: "xyz",
            cgpa: 8.1,
            profile: "/img/profile.jpg"
        },
        {
            name: "abc",
            cgpa: 7.1,
            profile: "/img/profile.jpg"
        },
        {
            name: "pqr",
            cgpa: 6.75,
            profile: "/img/profile.jpg"
        }
    ];
    angular.module("eventApp", []).controller("eventcontroller", ['$scope', '$timeout', function (a, b) {
        a.loadData = function () {
            a.data = studentData;
            b(function () {
                studentData[2].name = "Nilesh";
                studentData[2].cgpa = 7.1;
            }, 3000);
        };
    }]);
}(window.angular))