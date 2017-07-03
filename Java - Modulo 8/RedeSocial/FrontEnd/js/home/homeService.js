angular.module('Andromeda').factory('homeService', function ($http) {
    
    var urlBase = 'http://localhost:9090/postagem';

    function cadastrarPostagem(postagem) {
        return $http.post(urlBase, postagem);
    };

    function buscarPostagens(email) {
        return $http({
            url: urlBase + '/postAmigos',
            params: { email: email },
            method: 'GET'
        })
    }

    return {
        buscarPostagens: buscarPostagens,
        cadastrarPostagem: cadastrarPostagem
    };
})