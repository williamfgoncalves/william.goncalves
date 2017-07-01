angular.module('Andromeda').controller('homeController', function ($scope, $routeParams, $localStorage, authService, cadastroService) {

  pegarUser();

  function pegarUser() {

    $scope.userGet = authService.getUsuario();

    cadastroService.buscarUsuarioPorEmail($scope.userGet.username).then(function (response) {
      $scope.user = response.data;
    })
  }

  console.log("Loguei na HOME " + $scope.user);

  $scope.logout = function () {
    authService.logout();
  }

});