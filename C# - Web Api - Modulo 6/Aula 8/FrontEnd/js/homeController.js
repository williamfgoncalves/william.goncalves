angular.module('upEventos').controller('homeController', function ($scope, authService) {
    $scope.auth = authService;
});