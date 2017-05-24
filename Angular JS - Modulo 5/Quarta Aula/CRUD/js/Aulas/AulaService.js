controller.factory('AulaService', function ($http) {

  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function atualizar(aula) {
    return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
    return $http.post(urlBase + '/aula', aula);
  };

   function excluir(aula) {
    return $http.delete(urlBase + '/aula/' + aula.id);
   };

  return {
    listarAulas: getTodasAsAulas,
    update: atualizar,
    create: criar,
    remove: excluir
  };
});