controller.factory('livroService', function ($http) {

  let urlBase = 'http://localhost:55070/Api/Livros';
  
  return {
    listarTodosLivros : listarTodosLivros,
    listarLivrosLancamentos : listarLivrosLancamentos,
    listarLivrosQueNaoSaoLancamentos: listarLivrosQueNaoSaoLancamentos,
    listarLivroPorId : listarLivroPorId,
  };

  function listarTodosLivros(){
    return $http.get(urlBase);
  }

  function listarLivrosLancamentos(){
    return $http.get(urlBase + '/Lancamentos');
  };

  function listarLivrosQueNaoSaoLancamentos(parametros){
    return $http.get(urlBase + `?quantidadePular=${parametros.quantidadePular}&quantidadeTrazer=${parametros.quantidadeTrazer}`)
  };

  function listarLivroPorId(id){
    return $http.get(urlBase + '/' + id)
  }
});