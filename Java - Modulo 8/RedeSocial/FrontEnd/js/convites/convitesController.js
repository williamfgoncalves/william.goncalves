angular.module('Andromeda').controller('convitesController', function ($scope, $routeParams, $localStorage, amigosService, authService, toastr){
    
    var userLocal = authService.getUsuario();
    pegarAmigosPendentes();

    function pegarAmigosPendentes(){
        amigosService.listarAmigosPendentes(userLocal.username).then(function(response){
            $scope.amigospendentes = response.data;
            console.log($scope.amigospendentes);
        })
    }

    $scope.pegaridamizade = function(idamizade){
        amigosService.aceitarAmizade(idamizade).then(function(response){
            toastr.success("Amigo adicionado com sucesso!");
        })
    }
});