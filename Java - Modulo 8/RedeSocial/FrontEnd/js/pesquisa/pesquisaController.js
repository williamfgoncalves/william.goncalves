angular.module('Andromeda').controller('pesquisaController', function ($scope, $location, $routeParams, $localStorage, amigosService, authService, toastr, cadastroService) {

    var userLocal = authService.getUsuario();
    var usuariosCache;
    $scope.usuarioEncontrado = false;

    pegarUsuarios();

    function pegarUsuarios() {
        cadastroService.buscarUsuariosNaoAmigos(userLocal.username).then(function (response) {
            usuariosCache = response.data;
            $scope.usuarios = usuariosCache;
            if (!$scope.usuarios.length) {
                toastr.warning("Não existe usuarios não vinculados!");
            }
        })
    }

    $scope.filtrar = function (filtro) {
        $scope.usuarios = usuariosCache.filter(item => {
            if (item.nome.toLocaleLowerCase() === filtro.toLocaleLowerCase()) {
                $scope.usuarioEncontrado = true;
                return usuariosCache;
            }
        })
        if(!$scope.usuarios.length){
            return toastr.warning("Usuario não encontrado!");
        }
    }
    
    $scope.pegaridamigo = function (idamigo) {
        console.log(idamigo);
        amigosService.cadastrarAmizade(idamigo).then(function (response) {
            toastr.success("Convite enviado com Successo!");
            $location.path('/home');
        })
    }
});