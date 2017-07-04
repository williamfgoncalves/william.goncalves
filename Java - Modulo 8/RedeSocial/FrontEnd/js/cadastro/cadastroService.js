angular.module('Andromeda').factory('cadastroService', function ($http) {

    var urlBase = 'http://localhost:9090/usuarios';

    function listarUsuarios() {
        return $http.get(urlBase);
    };

    function listarTodosUsuarios() {
        return $http.get(urlBase + "/pesquisar");
    };

    function cadastrarUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    function atualizarUsuario(usuario) {
        return $http.put(urlBase, usuario);
    };

    function buscarUsuarioPorEmail(username) {
        return $http({
            url: urlBase + '/login',
            params: { email: username },
            method: 'GET'
        })
    }

    function buscarUsuariosNaoAmigos(email) {
        return $http({
            url: urlBase + '/usuarios/naoamigos',
            params: { email: email },
            method: 'GET'
        })
    }

    return {
        buscarUsuarioPorEmail: buscarUsuarioPorEmail,
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario,
        atualizarUsuario: atualizarUsuario,
        listarTodosUsuarios: listarTodosUsuarios,
        buscarUsuariosNaoAmigos: buscarUsuariosNaoAmigos
    };

})