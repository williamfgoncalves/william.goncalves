controller.factory('instrutorService', function ($http) {

    let urlBase = 'http://localhost:3000';

    function getTodasOsInstrutores() {
      return $http.get(urlBase + '/instrutor');
    };

    function getInstrutorPorId(id) {
      return $http.get(urlBase + '/instrutor' + '/' + id);
    };

    function atualizarInstrutor(instrutor) {
      return $http.put(urlBase + '/aula' + '/' + instrutor.id, instrutor);
    };

    function criarInstrutor(instrutor) {
      instrutor.id = ++idAtual;
      instrutores.push(angular.copy(instrutor));
    };

    return {
      list: getTodasOsInstrutores,
      findById: getInstrutorPorId,
      update: atualizarInstrutor,
      create: criarInstrutor
    };
  });