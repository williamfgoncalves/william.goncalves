angular.module('Andromeda').controller('amigosController', function ($scope, $routeParams, $localStorage, amigosService, authService){
    
    var userLocal = authService.getUsuario();
    pegarAmigos();

    function pegarAmigos(){
        amigosService.listarAmigos(userLocal.username).then(function(response){
            $scope.amigos = response.data;
            console.log($scope.amigos);
        })
    }
});