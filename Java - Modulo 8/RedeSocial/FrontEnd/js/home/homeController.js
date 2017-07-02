angular.module('Andromeda').controller('homeController', function ($scope, $routeParams, $localStorage, authService, cadastroService, homeService, toastr) {

  pegarUser();
  pegarPostagens();

  function pegarUser() {

    $scope.userGet = authService.getUsuario();

    cadastroService.buscarUsuarioPorEmail($scope.userGet.username).then(function (response) {
      $scope.user = response.data;
    })
  }

  function pegarPostagens(){
    homeService.buscarPostagens().then(function(response){
      $scope.postagens = response.data;
      console.log($scope.postagens);
    })
  }

  $scope.cadastrar = function (postagem) {
    if ($scope.formCadastro.$valid) {
      postagem.idusuario = $scope.user.idusuario;
      postagem.datapostagem = new Date();
      homeService.cadastrarPostagem(postagem).then(function () {
        toastr.success('Postagem cadastrada com sucesso!');
        pegarPostagens();
      });
    } else {
      toastr.warning('Algum erro ocorreu ao cadstrar a postagem!', 'Contate o administrador do site.');
    }
  }

  $scope.logout = function () {
    authService.logout();
  }

});