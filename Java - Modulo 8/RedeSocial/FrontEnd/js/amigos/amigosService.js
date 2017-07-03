angular.module('Andromeda').factory('amigosService', function ($http) {

    var urlBase = 'http://localhost:9090/amizades';

    function listarAmigos(email) {
        return $http({
            url: urlBase + '/amigos',
            params: { email: email },
            method: 'GET'
        })
    }

    function listarAmigosPendentes(email) {
        return $http({
            url: urlBase + '/pendentes',
            params: { email: email },
            method: 'GET'
        })
    }
    
    function cadastrarAmizade(idamigo) {
        return $http.post(urlBase + "/solicitaramizade/" + idamigo);
    };
    
    function aceitarAmizade(idamizade) {
        return $http.put(urlBase + "/aceitaramizade/" + idamizade);
    };

    return {
        listarAmigos: listarAmigos,
        listarAmigosPendentes: listarAmigosPendentes,
        cadastrarAmizade: cadastrarAmizade,
        aceitarAmizade: aceitarAmizade
    };
})