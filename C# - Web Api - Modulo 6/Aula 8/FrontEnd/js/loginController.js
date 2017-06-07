angular.module('upEventos').controller('loginController', function ($scope, authService) {

  $scope.logout = function(){
    authService.logout();
  }    

  $scope.login = function (usuario) {
    authService.login(usuario)
      .then(
        function (response) {
          alert("Logado!");
        },
        function (response) {
          alert("Erro!");
        });   
    };
});