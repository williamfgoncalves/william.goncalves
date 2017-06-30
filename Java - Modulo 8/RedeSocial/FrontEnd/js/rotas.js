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
            templateUrl: './home.html'
        })
        .when('/amigos', {
            controller: 'amigosController',
            templateUrl: './amigos.html'
        })
        .when('/convites', {
            controller: 'convitesController',
            templateUrl: './convites.html'
        })
        .when('/perfil', {
            controller: 'perfilController',
            templateUrl: './perfil.html'
        })
        .otherwise({ redirectTo: '/login' })
})