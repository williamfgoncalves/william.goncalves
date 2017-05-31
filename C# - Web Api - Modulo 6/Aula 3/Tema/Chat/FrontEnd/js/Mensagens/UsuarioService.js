controller.factory('UsuarioService', function ($http) {

  let urlBase = 'http://localhost:61239/Api/Usuario';

  function getUsuario() {
    return $http.get(urlBase);
  };

  function enviarUsuario(usuario) {
    return $http.post(urlBase, usuario);
  };

  return {
    listarUsuarios: getUsuario,
    criarUsuario: enviarUsuario,
  };
  
});