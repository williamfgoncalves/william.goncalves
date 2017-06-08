angular.module('upEventos').factory('reservaService', function ($http) {

    let urlBase = 'http://localhost:55047/api/Reserva';

    return {
        adicionarReserva : adicionarReserva,
        listarTodosReservas : listarTodosReservas
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

    function listarTodosReservas(){
        return $http.get(urlBase);     
    }

    function devolverReserva(reserva, headerAuth) {
    return $http({
        url: urlBase + '/' +  reserva.IdReserva,
        method: 'PUT',
        headers: {
            Authorization: headerAuth
        },
            data: reserva
        });
    }
})