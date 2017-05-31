    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/chat', { 
            controller: 'MensagemController', 
            templateUrl: './chat.html' 
        })
            .when('/login', { 
            controller: 'UsuarioController', 
            templateUrl: './login.html' 
        })
            .otherwise({redirectTo:'/login'}); 
    });