var app = angular.module('app', []);

app.controller('MainController', function ($http) {
    var vm = this;

    vm.showNewPreferencesModal = function (blockId) {
        var responsePromise = $http.get("blockCoursesJson.faces", {blockId: blockId});

        responsePromise.success(function (data, status, headers, config) {
            vm.blockCourses = data;
            $('#addPreferrenceModal').modal('show');
        });
        responsePromise.error(function (data, status, headers, config) {
            alert("AJAX failed!");
        });
    };
    
    vm.addPreferedCourse = function addPreferedCourse(course) {
        
    };
});