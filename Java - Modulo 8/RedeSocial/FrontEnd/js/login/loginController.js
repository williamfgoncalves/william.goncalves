angular.module('Andromeda').controller('loginController', function ($scope, authService, $location, $routeParams, $localStorage, toastr) {
    
    console.log("Loguei na login");

    $scope.login = function (usuario) {
        if ($scope.formLogin.$valid) {
            authService.login(usuario)
                .then(function (response) {
                    toastr.success('Login com sucesso!');
                    $location.path('/home');

                },
                function (response) {
                    toastr.error('Login ou Senha inválidos!');
                });
        } else {
            toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
        }
    };

    $scope.cadastrar = function () {
        $location.path('/cadastro');
    };

});
