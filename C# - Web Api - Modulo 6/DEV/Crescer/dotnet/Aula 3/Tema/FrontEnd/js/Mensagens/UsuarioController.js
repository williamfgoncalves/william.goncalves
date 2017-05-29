    controller.controller('UsuarioController', function ($scope, $routeParams, $localStorage, UsuarioService, toastr){

       $scope.addUsuario = function (usuario){
            UsuarioService.criarUsuario(usuario).then(function (response){
                localStorage.setItem('nome', usuario.Nome,toString());
                localStorage.setItem('foto', usuario.UrlFoto,toString());
                toastr.info("Login efetuado com sucesso!");
                location.href = '#!/chat';
                toastr.success("Bem vindo ao CHAT da CWI");
                listaTodosUsuarios();
            });
        }
    });