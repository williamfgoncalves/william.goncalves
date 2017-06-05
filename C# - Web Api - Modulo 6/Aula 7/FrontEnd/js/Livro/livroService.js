angular.module('editoraCwi').factory('livroService', function ($http) {

  let urlBase = 'http://localhost:55070/Api/Livros';
  
  return {
    listarTodosLivros : listarTodosLivros,
    listarLivrosLancamentos : listarLivrosLancamentos,
    listarLivrosQueNaoSaoLancamentos: listarLivrosQueNaoSaoLancamentos,
    listarLivroPorId : listarLivroPorId,
    adicionarLivro : adicionarLivro,
    editarLivro: editarLivro,
    excluirLivro: excluirLivro,
    publicarLivro:publicarLivro
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

  function adicionarLivro(livro, headerAuth) {
    return $http({
      url: urlBase, livro,
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    });
  }

  function editarLivro(livro, headerAuth) {
    return $http({
      url: urlBase + '/' + livro.Isbn, 
      method: 'PUT',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    });
  }

  function excluirLivro(livro, headerAuth) {
    return $http({
      url: urlBase + '/' + livro.Isbn, 
      method: 'DELETE',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    })
  };

  function publicarLivro(livro, headerAuth) {
    return $http({
      url: urlBase + '/' + livro.Isbn, 
      method: 'PUT',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    });
  }

});