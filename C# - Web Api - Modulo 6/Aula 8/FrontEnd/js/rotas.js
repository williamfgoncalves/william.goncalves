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
        .when('/cadastroReserva', {
            controller: 'reservaController',
            templateUrl: './cadastroReserva.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/relatorios', {
            controller: 'reservaController',
            templateUrl: './relatorios.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/devolverReserva', {
            controller: 'reservaController',
            templateUrl: './devolverReserva.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/relatorio30dias', {
            controller: 'reservaController',
            templateUrl: './relatorio30dias.html',
            resolve: {
                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({ redirectTo: '/login' })
})