angular.module('upEventos').factory('clienteService', function ($http) {

    let urlBase = 'http://localhost:55047/api/Cliente';

    return {
        adicionarCliente : adicionarCliente,
        listarTodosClientes : listarTodosClientes
    };

    function adicionarCliente(cliente, headerAuth) {
    return $http({
        url: urlBase, cliente,
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
            data: cliente
        });
    }

    function listarTodosClientes(){
        return $http.get(urlBase);     
    }
})