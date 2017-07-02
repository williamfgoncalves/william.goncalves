angular.module('Andromeda').controller('perfilController', function ($scope, $routeParams, $localStorage, cadastroService, perfilService, authService, toastr) {

    $scope.perfil = true;
    $scope.editar = false;
    $scope.novasenha;
    $scope.comparar;

    $scope.userGet = authService.getUsuario();
    pegarPostagensUsuario();

    function pegarPostagensUsuario() {
        perfilService.buscarPostagemPorUsuario($scope.userGet.username).then(function (response) {
            $scope.postagensUsuario = response.data;
            console.log($scope.postagensUsuario);
        })
    }

    $scope.editarUser = function () {
        console.log("rwa");
        cadastroService.buscarUsuarioPorEmail($scope.userGet.username).then(function (response) {
            $scope.user = response.data;
            $scope.perfil = false;
            $scope.editar = true;
        })
    }

    $scope.atualizar = function (user) {
        if ($scope.novasenha.localeCompare($scope.comparar) === 0) {
            if ($scope.formCadastro.$valid) {
                $scope.verificarImagem(user);
                user.senha = $scope.novasenha;
                cadastroService.atualizarUsuario(user).then(function () {
                    toastr.success('Cadastro com sucesso! Faça o Login');
                    login(user);
                });
            } else {
                toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
            }
        } else {
            toastr.warning('Senhas incompativeis!');
        }
        delete $scope.user;
        $scope.perfil = true;
        $scope.editar = false;
    };

    $scope.cancelarUser = function (user) {
        delete $scope.user;
        $scope.perfil = true;
        $scope.editar = false;
    }

    $scope.verificarImagem = function (usuario) {
        if (usuario.urlimagem == null || usuario.urlimagem.length === 0) {
            if (usuario.sexo.localeCompare('M') === 0) {
                usuario.urlimagem = 'http://baxtercoaching.com/wp-content/uploads/2013/12/facebook-default-no-profile-pic-300x300.jpg';
            } else {
                usuario.urlimagem = 'http://rehrealestate.com/wp-content/uploads/2015/08/facebook-default-no-profile-pic-girl.jpg';
            }
        }
    }

    function login(usuario) {

        authService.login(usuario)
            .then(
            function (response) {
                console.log(response);
                toastr.success("Feito!", "Login com sucesso!", "success");

            },
            function (response) {
                console.log(response);
                toastr.warning("Eita!", "Usuário ou Senha inválidos!", "error");
            });
    };

    console.log("Loguei na perfil");
});