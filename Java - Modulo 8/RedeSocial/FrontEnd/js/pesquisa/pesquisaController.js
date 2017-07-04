angular.module('Andromeda').controller('pesquisaController', function ($scope, $location, $routeParams, $localStorage, amigosService, authService, toastr, cadastroService) {

    var userLocal = authService.getUsuario();

    pegarUsuarios() ;

    function pegarUsuarios() {
        cadastroService.buscarUsuariosNaoAmigos(userLocal.username).then(function (response) {
            $scope.usuarios = response.data;
            console.log($scope.usuarios);
        })
    }

    $scope.pegaridamigo = function(idamigo){
        console.log(idamigo);
        amigosService.cadastrarAmizade(idamigo).then(function(response){
            toastr.success("Convite enviado com Successo!");
            $location.path('/home');
        })
    }
});