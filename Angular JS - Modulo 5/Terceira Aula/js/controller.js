//Criacao do modulo 
var controller = angular.module('aula3', []);

controller.controller('controllerForm', function($scope){
    
    $scope.instrutores = [{
        nome: 'Bernardo',
        sobrenome: 'Rezende',
        idade: 30,
        email: 'bernardo@cwi.com.br',
        jaDeuAula: true,
        aula: 'OO'
    }];;

    $scope.aulas =[
        'OO',
        'HTML e CSS',
        'Javascript',
        'AngularJS',
        'Banco de Dados I'
    ];
    
    $scope.addInstrutor = function addInstrutor(instrutor){
        if($scope.form1.$valid){
            $scope.instrutores.push(angular.copy(instrutor));
            $scope.instrutor = {};
        }   
    }

})