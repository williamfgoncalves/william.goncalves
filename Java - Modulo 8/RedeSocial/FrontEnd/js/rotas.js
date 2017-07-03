angular.module('Andromeda').config(function ($routeProvider) {

    $routeProvider

        .when('/login', {
            controller: 'loginController',
            templateUrl: './login.html'
        })
        .when('/cadastro', {
            controller: 'cadastroController',
            templateUrl: './cadastro.html'
        })
        .when('/home', {
            controller: 'homeController',
            templateUrl: './home.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/amigos', {
            controller: 'amigosController',
            templateUrl: './amigos.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/convites', {
            controller: 'convitesController',
            templateUrl: './convites.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/perfil', {
            controller: 'perfilController',
            templateUrl: './perfil.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/pesquisar', {
            controller: 'pesquisaController',
            templateUrl: './pesquisa.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({ redirectTo: '/login' })
})