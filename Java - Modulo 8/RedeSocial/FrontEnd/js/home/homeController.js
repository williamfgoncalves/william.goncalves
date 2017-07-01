angular.module('Andromeda').controller('homeController', function ($scope, $routeParams, $localStorage, authService){
    
    console.log("Loguei na HOME");

    $scope.logout = function(){
    authService.logout();
  }  
});