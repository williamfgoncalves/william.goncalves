controller.factory('Instrutor.Service', function ($http) {

    let urlBase = 'http://localhost:3000';

    function getTodosOsInstrutores() {
      return $http.get(urlBase + '/instrutor');
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