    controller.controller('UsuarioController', function ($scope, $routeParams, $localStorage, UsuarioService, toastr){

        listaTodosUsuarios();

         function listaTodosUsuarios() {
            UsuarioService.listarUsuarios().then(function (response) {
            $scope.usuarios = response.data;
            });
        }

       $scope.addUsuario = function (usuario){
            UsuarioService.criarUsuario(usuario).then(function (response){
                $localStorage.nome = usuario.nome;
                $localStorage.foto = usuario.foto;
                toastr.info("Login efetuado com sucesso!");
                listaTodosUsuarios();
            });
        }

        /*$scope.cancelar = function(aulaAtual){
            delete $scope.aulaAtual;
            toastr.warning('Você cancelou a edição da aula!');
            $scope.editarAula = false;
            $scope.exibirAula = true;
        }*/
    });