angular.module('Andromeda').controller('convitesController', function ($scope, $location, $routeParams, $localStorage, amigosService, authService, toastr){
    
    var userLocal = authService.getUsuario();
    pegarAmigosPendentes();

    function pegarAmigosPendentes(){
        amigosService.listarAmigosPendentes(userLocal.username).then(function(response){
            $scope.amigospendentes = response.data;
            if(!$scope.amigospendentes.length){
                 toastr.warning("Você não tem amizades pendentes!");
            }
        })
    }

    $scope.rejeitarAmizade = function(idamizade){
        amigosService.removerAmizade(idamizade).then(function(response){
            toastr.success("Amizade cancelada com sucesso!");
            $location.path('/home.html');
        })
    }

    $scope.pegaridamizade = function(idamizade){
        amigosService.aceitarAmizade(idamizade).then(function(response){
            toastr.success("Amigo adicionado com sucesso!");
            $location.path('/home');
        })
    }
});