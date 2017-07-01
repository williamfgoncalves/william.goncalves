angular.module('Andromeda').controller('cadastroController', function ($scope, $routeParams, $localStorage, $location, cadastroService, toastr) {

    console.log("Loguei na Convite");
    
    $scope.comparar;
    
    $scope.cadastrar = function (usuario) {
        usuario.idusuario = 0;
        if (usuario.senha.localeCompare($scope.comparar) === 0){
            if ($scope.formCadastro.$valid) {
                cadastroService.cadastrarUsuario(usuario).then(function () {
                    toastr.success('Cadastro com sucesso! Faça o Login');
                    $location.path('/login.html');
                });
            } else {
                toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
            }
        }
    };

    $scope.voltar = function () {
        $location.path('/login.html');
    };
});