controller.factory('MensagemService', function ($http) {

  let urlBase = 'http://localhost:61239/Api/Mensagem';

  function getMensagens() {
    return $http.get(urlBase);
  };

  function enviarMensagem(mensagem) {
    return $http.post(urlBase, mensagem);
  };

  return {
    listarMensagens: getMensagens,
    criarMensagens: enviarMensagem,
  };
});