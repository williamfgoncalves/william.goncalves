angular.module('editoraCwi').controller('loginController', function ($scope, authService) {

  $scope.logout = () => {
          console.log("eNTREI");
          authService.logout();
          $scope.estaLogado = false;
        }    

  $scope.login = function (usuario) {   
  $scope.estaLogado = false;
   
    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');
          $scope.estaLogado = true;
        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });   
  };
});