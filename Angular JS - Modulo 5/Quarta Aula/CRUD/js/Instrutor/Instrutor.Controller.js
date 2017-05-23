    controller.controller('Instrutor.Controller', function ($scope){

    $scope.addInstrutor = function (instrutor){
        if($scope.form1.$valid){
            if(instrutor.urlFoto === null || typeof instrutor.urlFoto === "undefined"){
                instrutor.urlFoto = "https://pescadordesonhos.files.wordpress.com/2009/12/1-anonimo-famoso-oow.jpg";
            }
            $scope.instrutores.push(angular.copy(instrutor));
            delete $scope.instrutor;
            alert('Instrutor adicionado com sucesso!');
            $scope.mostrarEdicao = false;
        }
        else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }   
    }
    

    $scope.editInstrutor = function (instrutor) {
         $scope.editarInstrutor = true;
         alert('Você está editando o instrutor!');
         $scope.instrutorAtual = angular.copy(instrutor);
    }

    $scope.cancelarInstrutor = function(instrutorAtual){
        delete $scope.instrutorAtual;
        alert('Você cancelou a edição da aula!');
        $scope.editarInstrutor = false;
    }

    $scope.salvarInstrutor = function(instrutorAtual){
        if($scope.form2.$valid){
            let idInstrutor = instrutorAtual.id;
            $scope.instrutores.splice(idInstrutor,1,instrutorAtual);
            delete $scope.instrutorAtual;
            alert('Instrutor alterado com sucesso!');
            $scope.editarInstrutor = false;
        }
        else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }   
    }

    $scope.removeInstrutor = function (instrutor){
        let idInstrutor = $scope.instrutores.indexOf(instrutor);
	    $scope.instrutores.splice(idInstrutor, 1);
        alert('Instrutor excluido com sucesso!');        
    }
});

    