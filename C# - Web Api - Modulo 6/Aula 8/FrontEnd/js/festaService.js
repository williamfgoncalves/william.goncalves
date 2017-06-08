angular.module('upEventos').factory('festaService', function ($http) {
    
    let urlBase = 'http://localhost:55047/api/Festa';

    return {
        listarTodasFestas : listarTodasFestas
    };

    function listarTodasFestas(){
        return $http.get(urlBase);     
    }
})
