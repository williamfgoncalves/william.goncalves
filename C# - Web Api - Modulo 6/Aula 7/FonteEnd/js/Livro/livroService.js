controller.factory('livroService', function ($http) {

  let urlBase = 'http://localhost:55070/Api/Livros';

  function listarLivros() {
    return $http.get(urlBase);
  };

  //function enviarMensagem(mensagem) {
  //  return $http.post(urlBase, mensagem);
  //};

  return {
    listarLivros: listarLivros,
    //criarMensagens: enviarMensagem,
  };
  
});