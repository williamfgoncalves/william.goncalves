angular.module('Andromeda').controller('cadastroController', function ($scope, $routeParams, $localStorage, $location, cadastroService, toastr) {

    console.log("Loguei na Convite");

    $scope.comparar;

    $scope.cadastrar = function (usuario) {
        usuario.idusuario = 0;
        if (usuario.senha.localeCompare($scope.comparar) === 0) {
            if ($scope.formCadastro.$valid) {
                $scope.verificarImagem(usuario);
                cadastroService.cadastrarUsuario(usuario).then(function () {
                    toastr.success('Cadastro com sucesso! Faça o Login');
                    $location.path('/login.html');
                });
            } else {
                toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
            }
        } else {
            toastr.warning('Senhas incompativeis!');
        }
    };

    $scope.voltar = function () {
        $location.path('/login.html');
    };

    $scope.verificarImagem = function(usuario){
        if(usuario.urlimagem == null || usuario.urlimagem.length === 0){
            if(usuario.sexo.localeCompare('M') === 0){
                usuario.urlimagem = 'http://baxtercoaching.com/wp-content/uploads/2013/12/facebook-default-no-profile-pic-300x300.jpg';
            }else{
                usuario.urlimagem = 'http://rehrealestate.com/wp-content/uploads/2015/08/facebook-default-no-profile-pic-girl.jpg';
            }
        }
    }
});