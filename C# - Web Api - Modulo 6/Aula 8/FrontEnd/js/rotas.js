angular.module('upEventos').config(function ($routeProvider) {

    $routeProvider

        .when('/login', {
            controller: 'loginController',
            templateUrl: './login.html'
        })
        .when('/home', {
            controller: 'homeController',
            templateUrl: './home.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/cadastro', {
            controller: 'clienteController',
            templateUrl: './cadastro.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({ redirectTo: '/login' })
})