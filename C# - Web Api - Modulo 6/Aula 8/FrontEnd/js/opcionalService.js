angular.module('upEventos').factory('opcionalService', function ($http) {
    
    let urlBase = 'http://localhost:55047/api/Opcional';

    return {
        listarTodosOpcional : listarTodosOpcional
    };

    function listarTodosOpcional(){
        return $http.get(urlBase);     
    }
})
