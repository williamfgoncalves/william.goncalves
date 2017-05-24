controller.factory('InstrutorService', function ($http) {

    let urlBase = 'http://localhost:3000';

    function getTodosOsInstrutores() {
      return $http.get(urlBase + '/instrutor');
    };

    function atualizar(instrutor) {
      return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
    };

    function criar(instrutor) {
      return $http.post(urlBase + '/instrutor', instrutor);
    };

    function excluir(instrutor) {
      return $http.delete(urlBase + '/instrutor/' + instrutor.id);
    };

    return {
      listarInstrutores: getTodosOsInstrutores,
      update: atualizar,
      create: criar,
      remove: excluir
    };
  });