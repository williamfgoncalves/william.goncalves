    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/livros', { 
            controller: 'livroController', 
            templateUrl: './livro.html' 
        })
            .otherwise({redirectTo:'/livros'}); 
    });