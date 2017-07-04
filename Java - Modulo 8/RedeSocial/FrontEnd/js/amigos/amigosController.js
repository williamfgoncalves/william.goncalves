angular.module('Andromeda').controller('amigosController', function ($scope, $routeParams, $localStorage, amigosService, authService, cadastroService, perfilService, toastr) {

    $scope.meusamigos = true;
    $scope.perfilamigo = false;

    var userLocal = authService.getUsuario();
    pegarAmigos();

    function pegarAmigos() {
        amigosService.listarAmigos(userLocal.username).then(function (response) {
            $scope.amigos = response.data;
            if(!$scope.amigos.length){
                toastr.warning('Você não tem amigos!');
            }
        })
    }
    //$scope.email;

    function pegarPostAmigo(email) {
        perfilService.buscarPostagemPorUsuario(email).then(function (response) {
            $scope.postagensUsuario = response.data;
        })
    }

    $scope.verPerfil = function (email) {
        cadastroService.buscarUsuarioPorEmail(email).then(function (response) {
            $scope.userSession = response.data;
            pegarPostAmigo($scope.userSession.email);
            $scope.meusamigos = false;
            $scope.perfilamigo = true;
        })
    }

    $scope.voltar = function () {
        $scope.meusamigos = true;
        $scope.perfilamigo = false;
    }
});