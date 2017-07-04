angular.module('Andromeda').factory('homeService', function ($http) {
    
    var urlBase = 'http://localhost:9090/postagem';

    function cadastrarPostagem(postagem) {
        return $http.post(urlBase, postagem);
    };

    function curtirPostagem(email, idpostagem){
        return $http({
            url: 'http://localhost:9090/curtidas',
            params: { email: email, idpostagem : idpostagem},
            method: 'POST'
        })
    }

    function buscarPostagens(email) {
        return $http({
            url: urlBase + '/postAmigos',
            params: { email: email },
            method: 'GET'
        })
    }

    return {
        buscarPostagens: buscarPostagens,
        curtirPostagem, curtirPostagem,
        cadastrarPostagem: cadastrarPostagem
    };
})