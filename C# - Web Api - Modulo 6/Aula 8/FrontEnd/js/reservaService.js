angular.module('upEventos').factory('reservaService', function ($http) {

    let urlBase = 'http://localhost:55047/api/Reserva';

    return {
        adicionarReserva : adicionarReserva
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
})