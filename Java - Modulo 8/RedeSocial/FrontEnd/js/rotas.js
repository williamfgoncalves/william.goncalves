angular.module('upEventos').config(function ($routeProvider) {

    $routeProvider

        .when('/login', {
            controller: 'loginController',
            templateUrl: './login.html'
        })
        .when('/index', {
            controller: 'homeController',
            templateUrl: './index.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/amigos', {
            controller: 'amigosController',
            templateUrl: './amigos.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/convites', {
            controller: 'convitesController',
            templateUrl: './convites.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/perfil', {
            controller: 'perfilController',
            templateUrl: './perfil.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({ redirectTo: '/login' })
})