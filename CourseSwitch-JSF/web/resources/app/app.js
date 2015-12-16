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
        $scope.$apply($.get("blockCourses-ajax.faces", {blockId: registration.block.id})
            .success(function (data, status, headers, config) {
                $scope.blockCourses = data;
            })
            .error(function (data, status, headers, config) {
                alert("AJAX failed!");
            }));
    };

    vm.addPreferedCourse = function addPreferedCourse(courseId) {
        $.get("addPreferedCourse-ajax.faces", {courseId: courseId, registrationId: $scope.registration.id})
            .success(function (data, status, headers, config) {
                $scope.blockCourses = data;
                $('#addPreferrenceModal').modal('hide');
            })
            .error(function (data, status, headers, config) {
                alert("AJAX failed!");
            });
    };
});