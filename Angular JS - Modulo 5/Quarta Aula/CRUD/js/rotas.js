    controller.config(function ($routeProvider) { 
        $routeProvider 
            .when('/adicionarAula', { 
            controller: '/Aulas/Aula.Controller', 
            templateUrl: './adicionarAula.html' 
        })
            .when('/exibirAulas', { 
            controller: '/Aulas/Aula.Controller', 
            templateUrl: './exibirAulas.html' 
        })
            .when('/adicionarInstrutor', { 
            controller: '/Instrutor/Instrutor.Controller', 
            templateUrl: 'adicionarInstrutor.html' 
        })
            .when('/exibirInstrutores', { 
            controller: '/Instrutor/Instrutor.Controller', 
            templateUrl: 'exibirInstrutores.html' 
        }) 
            .otherwise({redirectTo:'/'}); 
    });