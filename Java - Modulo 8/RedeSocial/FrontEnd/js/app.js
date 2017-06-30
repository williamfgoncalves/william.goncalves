angular.module('Andromeda', ['ngRoute', 'ngStorage', 'auth']);

angular.module('Andromeda').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:55047/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/perfil',
});