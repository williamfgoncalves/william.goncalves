    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/livros', { 
            controller: 'livroController', 
            templateUrl: './livro.html' 
        }).when('/livros/:id', { 
            controller: 'livroDetalhesController', 
            templateUrl: './livroDetalhes.html' 
        })
        .when('/login', { 
            controller: 'livroDetalhesController', 
            templateUrl: './login.html' 
        })
            .otherwise({redirectTo:'/livros'}); 
    });