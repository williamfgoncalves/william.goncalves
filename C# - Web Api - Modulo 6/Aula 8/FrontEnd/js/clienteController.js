angular.module('upEventos').controller('clienteController', function ($scope, $routeParams, $localStorage, clienteService){
    
    $scope.livro;

    $scope.cadastrarCliente = function(cliente){
        if($scope.formCliente.$valid){
            debugger;
            clienteService.adicionarCliente(cliente, $localStorage.headerAuth).then(function(response){
                alert('Cliente adicionado com sucesso!');
            });
            delete $scope.cliente;
        }else{
            alert("Algum campo está errado ou faltando informação!");
        }
    } 
});