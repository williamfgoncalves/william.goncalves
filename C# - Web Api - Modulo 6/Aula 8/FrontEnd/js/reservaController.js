angular.module('upEventos').controller('reservaController', function ($scope, $routeParams,  $location,  $localStorage, clienteService, festaService, opcionalService, pacoteService, reservaService){
    
    listarClientes();
    listarFestas();
    listarOpcionais();
    listarPacotes();
    listarReservas()
    listarReservasPendentes();
    listarReservasUltimosDias();
    $scope.cadastrado = false;
    $scope.cadastro = true;
    $scope.reserva;

    $scope.cadastrarReserva = function(reserva){
        if($scope.formReserva.$valid){
            reservaService.adicionarReserva(reserva, $localStorage.headerAuth).then(function(response){
                alert('Cliente adicionado com sucesso!');
                $scope.orcamento = response.data.dados;
                console.log(response);
                $scope.cadastrado = true;
                $scope.cadastro = false;
            });
            delete $scope.reserva;
        }else{
            alert("Algum campo está errado ou faltando informação!");
        }
    }
    
    $scope.adicionarReservaBanco = function(orcamento){
        reservaService.adicionarReservaBanco(orcamento, $localStorage.headerAuth).then(function(response){
            alert("Vcoe cadastrou com sucesso!!");
        })
    }

    $scope.devolverReserva = function(reserva){
        console.log(reserva);
        reservaService.devolverReserva(reserva, $localStorage.headerAuth).then(function(response){
            alert("Vcoe devolveu os itens com sucesso!!");   
        })
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

    function listarReservas(){
        reservaService.listarTodosReservas().then(function(response){
            $scope.reservas = response.data.dados;
        })
    }

    function listarReservasPendentes(){
        reservaService.listarReservasNaoDevolvidas().then(function(response){
            $scope.reservasPendentes = response.data.dados;
            console.log($scope.reservasPendentes);
        })
    }

    function listarReservasUltimosDias(){
        reservaService.listarReservasUltimos30dias().then(function(response){
            $scope.reservasUltimosDias = response.data.dados;
            console.log($scope.reservasUltimosDias);
        })
    }
});