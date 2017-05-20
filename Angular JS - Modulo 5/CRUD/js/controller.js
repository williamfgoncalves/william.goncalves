//Criacao do modulo 
var controller = angular.module('aula3', []);

controller.controller('controllerForm', function($scope){
    
    $scope.editarAula = false;
    $scope.mostrarAulas = false;
    $scope.mostrarInstrutor = false;
    $scope.editarInstrutor = false;

    let idAula = 0;
    let idInstrutor = 0;

    $scope.addAula = function (aula){
        if($scope.formAula.$valid){
            aula.id = idAula++;
            $scope.aulas.push(angular.copy(aula));
            $scope.aula = {};
            $scope.mostrarAulas = true;
        }
    }
    
    $scope.editAula = function (aula) {
         $scope.editarAula = true;
         $scope.aulaAtual = aula;
    }

    $scope.salvar = function(aulaAtual){
        let idaula = aulaAtual.id;
        $scope.aulas.splice(idaula,1,aulaAtual);
        delete $scope.aulaAtual;
        $scope.editarAula = false;
    }

    $scope.removeAula = function (aula){
        let idAula = $scope.aulas.indexOf(aula);
	    $scope.aulas.splice(idAula, 1);
    }
    
    $scope.addInstrutor = function (instrutor){
        if($scope.form1.$valid){
            instrutor.id = idInstrutor++;
            $scope.instrutores.push(angular.copy(instrutor));
            delete $scope.instrutor;
            $scope.mostrarInstrutor = true;
        }   
    }

    $scope.editInstrutor = function (instrutor) {
         $scope.editarInstrutor = true;
         $scope.instrutorAtual = instrutor;
    }

    $scope.salvarInstrutor = function(instrutorAtual){
        let idInstrutor = instrutorAtual.id;
        $scope.instrutores.splice(idInstrutor,1,instrutorAtual);
        delete $scope.instrutorAtual;
        $scope.editarInstrutor = false;
    }

    $scope.removeInstrutor = function (instrutor){
        let idInstrutor = $scope.instrutores.indexOf(instrutor);
	    $scope.instrutores.splice(idInstrutor, 1);
    }

    $scope.instrutores = [{
    }];;

    $scope.aulas =[];
});