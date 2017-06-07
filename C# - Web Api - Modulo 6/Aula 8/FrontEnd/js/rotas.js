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
            autenticado: function (authService) {
                return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({redirectTo:'/login'})
    })