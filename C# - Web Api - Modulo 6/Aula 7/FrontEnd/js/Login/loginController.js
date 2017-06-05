angular.module('editoraCwi').controller('loginController', function ($scope, authService, toastr) {

  $scope.estaLogado = false;

  $scope.logout = () => {
    authService.logout();
    $scope.estaLogado = false;
  }    

  $scope.login = function (usuario) {   
  $scope.estaLogado = false;
   
    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          toastr.success('Login com sucesso!');
          $scope.estaLogado = true;
        },
        function (response) {
          console.log(response);
          toastr.error('Erro no Login!, verifique sua senha e email!');
        });   
  };
});