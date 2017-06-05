angular.module('editoraCwi').config(function ($routeProvider) { 
        $routeProvider 
            .when('/livros', { 
            controller: 'livroController', 
            templateUrl: './livro.html' 
        }).when('/livros/:id', { 
            controller: 'livroDetalhesController', 
            templateUrl: './livroDetalhes.html' 
        })
        .when('/login', { 
            controller: 'loginController', 
            templateUrl: './login.html' 
        })
        .when('/administrativo', { 
            controller: 'administrativoController', 
            templateUrl: './administrativo.html',
            resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/adicionarLivro', { 
            controller: 'livroController', 
            templateUrl: './adicionarLivro.html',
            resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/editarLivro', { 
            controller: 'livroController', 
            templateUrl: './editarLivro.html',
            resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({redirectTo:'/livros'}); 
    });