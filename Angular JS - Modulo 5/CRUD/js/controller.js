//Criacao do modulo 
var controller = angular.module('aula3', []);

controller.controller('controllerForm', function($scope){
    
    let idAula = 0;

    $scope.addInstrutor = function addInstrutor(instrutor){
        if($scope.form1.$valid){
            $scope.instrutores.push(angular.copy(instrutor));
            $scope.instrutor = {};
        }   
    }

    $scope.addAula = function addAula(aula){
        if($scope.formAula.$valid){
            aula.id = idAula++;
            $scope.aulas.push(angular.copy(aula));
            $scope.aula = {};
        }   
    }


    $scope.editAula = function editAula(aula){
        return nome
    }

    $scope.removeAula = function removeAula(aula){
        $scope.aulas.pop(aula);
    }

    $scope.instrutores = [{
    }];;

    $scope.aulas =[];
});