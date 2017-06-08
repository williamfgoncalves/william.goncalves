angular.module('upEventos').controller('reservaController', function ($scope, $routeParams, $localStorage, clienteService, festaService, opcionalService, pacoteService, reservaService){
    
    listarClientes();
    listarFestas();
    listarOpcionais();
    listarPacotes();

    $scope.reserva;

    $scope.cadastrarReserva = function(reserva){
        if($scope.formReserva.$valid){
            reservaService.adicionarReserva(reserva, $localStorage.headerAuth).then(function(response){
                alert('Cliente adicionado com sucesso!');
            });
            delete $scope.reserva;
        }else{
            alert("Algum campo está errado ou faltando informação!");
        }
    }

    function somar(soma){
        $scope.valor += soma;  
    }

    function listarClientes(){
        clienteService.listarTodosClientes().then(function (response){
            $scope.clientes = response.data.dados;
        })
    }

    function listarFestas(){
        festaService.listarTodasFestas().then(function (response){
            $scope.festas = response.data.dados;
        })
    }

    function listarOpcionais(){
        opcionalService.listarTodosOpcional().then(function (response){
            $scope.opcionais = response.data.dados;
        })
    }

    function listarPacotes(){
        pacoteService.listarTodosPacotes().then(function (response){
            $scope.pacotes = response.data.dados;
        })
    }
});