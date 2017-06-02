    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/livros', { 
            controller: 'livroController', 
            templateUrl: './livro.html' 
        }).when('/livroDetalhes', { 
            controller: 'livroController', 
            templateUrl: './livroDetalhes.html' 
        })
            .otherwise({redirectTo:'/livros'}); 
    });