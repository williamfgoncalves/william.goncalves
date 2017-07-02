angular.module('Andromeda').factory('homeService', function ($http) {
    
    var urlBase = 'http://localhost:9090/postagem';

    function cadastrarPostagem(postagem) {
        return $http.post(urlBase, postagem);
    };

    function buscarPostagens(){
        return $http.get(urlBase);
    }

    return {
        buscarPostagens: buscarPostagens,
        cadastrarPostagem: cadastrarPostagem
    };
})