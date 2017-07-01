angular.module('Andromeda').factory('cadastroService', function ($http) {
    
    var urlBase = 'http://localhost:9090/usuarios';

    function listarUsuarios() {
        return $http.get(urlBase);
    };

    function cadastrarUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

     function buscarUsuarioPorEmail(username) {
         return $http({
             url: urlBase + '/login',
             params: {email: username},
             method: 'GET'
         })
     }

    return {
        buscarUsuarioPorEmail : buscarUsuarioPorEmail,
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario
    };

})