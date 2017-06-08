angular.module('upEventos').factory('pacoteService', function ($http) {
    
    let urlBase = 'http://localhost:55047/api/Pacote';

    return {
        listarTodosPacotes : listarTodosPacotes
    };

    function listarTodosPacotes(){
        return $http.get(urlBase);     
    }
})
