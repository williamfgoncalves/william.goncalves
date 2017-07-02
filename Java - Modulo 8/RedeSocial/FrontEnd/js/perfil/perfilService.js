angular.module('Andromeda').factory('perfilService', function ($http) {

    var urlBase = 'http://localhost:9090/postagem';

    function buscarPostagemPorUsuario(email) {
        return $http({
            url: urlBase + '/post',
            params: { email: email },
            method: 'GET'
        })
    }

    return {
        buscarPostagemPorUsuario: buscarPostagemPorUsuario
    };
})