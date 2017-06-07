angular.module('upEventos').controller('loginController', function ($scope, $location, authService) {

  $scope.logout = function(){
    authService.logout();
  }    

  $scope.login = function (usuario) {
    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert("Logado!");
          
          $location.path("/home");
        },
        function (response) {
          alert("Erro!");
        });   
    };
});