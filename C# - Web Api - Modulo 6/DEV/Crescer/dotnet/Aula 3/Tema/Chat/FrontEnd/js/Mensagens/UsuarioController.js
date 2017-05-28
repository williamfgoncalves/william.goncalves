    controller.controller('UsuarioController', function ($scope, $routeParams, $localStorage, UsuarioService, toastr){

        listaTodosUsuarios();

         function listaTodosUsuarios() {
            UsuarioService.listarUsuarios().then(function (response) {
            $scope.usuarios = response.data;
            });
        }

       $scope.addUsuario = function (usuario){
            UsuarioService.criarUsuario(usuario).then(function (response){
                localStorage.setItem('nome', usuario.Nome,toString());
                localStorage.setItem('foto', usuario.UrlFoto,toString());
                toastr.info("Login efetuado com sucesso!");
                listaTodosUsuarios();
            });
        }
    });