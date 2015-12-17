var app = angular.module('app', []);

app.controller('MainController', function ($scope, $http) {
    var vm = this;

    $scope.currentBlockId;
    $scope.registrations = [];
    $scope.currentBlock;
    $scope.blockCourses = [];

    $http.get("getRegistrations-ajax.faces")
            .success(function (data, status, headers, config) {
                $scope.registrations = data;
            })
            .error(function (data, status, headers, config) {
                alert("AJAX failed!");
            });

    vm.showNewPreferencesModal = function (registration) {
        $('#addPreferrenceModal').modal('show');
        $scope.registration = registration;
        $http.get("blockCourses-ajax.faces?blockId=" + registration.block.id + "&courseId=" + registration.course.id)
                .success(function (data, status, headers, config) {
                    $scope.blockCourses = data;
                })
                .error(function (data, status, headers, config) {
                    alert("AJAX failed!");
                });
    };

    vm.addPreferedCourse = function addPreferedCourse(course) {
        $http.get("addPreferedCourse-ajax.faces?courseId=" + course.id + "&registrationId=" + $scope.registration.id)
                .success(function (data, status, headers, config) {
                    $scope.registration.preferedCourses.push(course);
                    $('#addPreferrenceModal').modal('hide');
                })
                .error(function (data, status, headers, config) {
                    alert("AJAX failed!");
                });
    };
});