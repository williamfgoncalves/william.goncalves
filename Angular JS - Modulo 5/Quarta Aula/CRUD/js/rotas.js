    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/adicionarAula', { 
            controller: 'AulaController', 
            templateUrl: './adicionarAula.html' 
        })
            .when('/exibirAulas', { 
            controller: 'AulaController', 
            templateUrl: './exibirAulas.html' 
        })
            .when('/adicionarInstrutor', { 
            controller: 'InstrutorController', 
            templateUrl: 'adicionarInstrutor.html' 
        })
            .when('/exibirInstrutores', { 
            controller: 'InstrutorController', 
            templateUrl: 'exibirInstrutores.html' 
        }) 
            .otherwise({redirectTo:'/'}); 
    });