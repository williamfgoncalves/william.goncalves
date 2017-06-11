angular.module('upEventos').factory('reservaService', function ($http) {

    let urlBase = 'http://localhost:55047/api/Reserva';

    return {
        adicionarReserva : adicionarReserva,
        listarTodosReservas : listarTodosReservas,
        listarReservasNaoDevolvidas : listarReservasNaoDevolvidas,
        listarReservasUltimos30dias : listarReservasUltimos30dias,
        listarReservasOrdenadoPorNumeroDiasDescendente : listarReservasOrdenadoPorNumeroDiasDescendente,
        adicionarReservaBanco : adicionarReservaBanco,
        devolverReserva : devolverReserva         
    };

    function adicionarReserva(reserva, headerAuth) {
    return $http({
        url: urlBase, reserva,
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
            data: reserva
        });
    }

    function adicionarReservaBanco(reserva, headerAuth) {
    return $http({
        url: urlBase + '/cadastroBanco', reserva,
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
            data: reserva
        });
    }

    function listarTodosReservas(){
        return $http.get(urlBase);     
    }

    function listarReservasNaoDevolvidas(){
        return $http.get(urlBase + '/pendentes');     
    }

    function listarReservasUltimos30dias(){
        return $http.get(urlBase + '/pendentes30Dias');     
    }

    function listarReservasOrdenadoPorNumeroDiasDescendente(){
        return $http.get(urlBase + '/pendentesMaisAntigos');     
    }

    function devolverReserva(reserva, headerAuth) {
    return $http({
        url: urlBase + '/' + reserva.IdReserva,
        method: 'PUT',
        headers: {
            Authorization: headerAuth
        },
            data: reserva
        });
    }
})