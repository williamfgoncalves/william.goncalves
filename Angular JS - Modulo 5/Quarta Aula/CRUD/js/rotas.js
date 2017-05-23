    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/adicionarAula', { 
            controller: 'Aula.Controller', 
            templateUrl: './adicionarAula.html' 
        })
            .when('/exibirAulas', { 
            controller: 'Aula.Controller', 
            templateUrl: './exibirAulas.html' 
        })
            .when('/adicionarInstrutor', { 
            controller: 'Instrutor.Controller', 
            templateUrl: 'adicionarInstrutor.html' 
        })
            .when('/exibirInstrutores', { 
            controller: 'Instrutor.Controller', 
            templateUrl: 'exibirInstrutores.html' 
        }) 
            .otherwise({redirectTo:'/'}); 
    });