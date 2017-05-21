//Criacao do modulo 
var controller = angular.module('aula3', ['ngAnimate', 'toastr']);

controller.controller('controllerForm', function($scope, toastr){
    
    $scope.editarAula = false;
    $scope.editarInstrutor = false;
    $scope.mostrarAulas;
    $scope.mostrarInstrutor;
    
    
    function gerarId(arr){
        let id;
        if(arr.length > 0){
            id = arr.length+1;
        }else{
            return;
        }   
        return id;
    }

    function compararNomes(arr, obj){
    let compare = false;
    for(let i = 0; i < arr.length; i++){
        if(arr[i].nome.localeCompare(obj.nome) === 0){
            compare = true;
        }
    }    
        if(compare === true){
                return 0;
        }
        else{
            return 1;
        }
    }

    function compararEmails(arr, obj){
    let compareEmail = false;
    for(let i = 0; i < arr.length; i++){
        if(arr[i].email.localeCompare(obj.email) === 0){
            compareEmail = true;
        }
    }    
        if(compareEmail === true){
                return 0;
        }
        else{
            return 1;
        }
    }

    function verificarAula(id){
        for(let i = 0; $scope.instrutores.length > i; i++){
            for(let j = 0; j < $scope.instrutores[i].aula.length; j++){
                if(id === $scope.instrutores[i].aula[j]){
                    return true;
                }
            }
        }
        return false;
    }

    $scope.addAula = function (aula){
        if($scope.formAula.$valid){
            let compararNome = compararNomes($scope.aulas, aula);
            if(compararNome === 0){
                toastr.error("Esta aula já existe");
                return;
            }
            aula.id = gerarId($scope.aulas);
            $scope.aulas.push(angular.copy(aula));
            delete $scope.aula;
            toastr.success('Aula adicionada com sucesso!');
            $scope.mostrarAulas = true;
        }
    }
    
    $scope.editAula = function (aula) {
         $scope.editarAula = true;
         toastr.warning('Você está editando uma aula!');
         $scope.aulaAtual = aula;
    }

    $scope.salvarAula = function(aulaAtual){
        let idaula = aulaAtual.id;
        $scope.aulas.splice(idaula,1,aulaAtual);
        delete $scope.aulaAtual;
        toastr.success('Aula alterada com sucesso!');
        $scope.editarAula = false;
    }

    $scope.cancelar = function(aulaAtual){
        delete $scope.aulaAtual;
        toastr.warning('Você cancelou a edição da aula!');
        $scope.editarAula = false;
    }

    $scope.removeAula = function (aula){
        let idAula = $scope.aulas.indexOf(aula);
        if(verificarAula(aula.id)){
            toastr.error("Aula esta sendo utilizada por um professor, impossivel excluir!");
            return;
        }
	    $scope.aulas.splice(idAula, 1);
    }
    
    $scope.addInstrutor = function (instrutor){
        if($scope.form1.$valid){

            let compararNome = compararNomes($scope.instrutores, instrutor);
            if(compararNome === 0){
                toastr.error("Este instrutor já existe!");
                return;
            }

            let compararEmail = compararEmails($scope.instrutores, instrutor);
            if(compararEmail === 0){
                toastr.error("Este email já está cadastrado!");
                return;
            }

            if(instrutor.urlFoto === null || typeof instrutor.urlFoto === "undefined"){
                instrutor.urlFoto = "https://pescadordesonhos.files.wordpress.com/2009/12/1-anonimo-famoso-oow.jpg";
            }

            instrutor.id = gerarId($scope.instrutores);
            $scope.instrutores.push(angular.copy(instrutor));
            delete $scope.instrutor;
            toastr.success('Instrutor adicionado com sucesso!');
            $scope.mostrarEdicao = false;
        }   
    }

    $scope.editInstrutor = function (instrutor) {
         $scope.editarInstrutor = true;
         toastr.warning('Você está editando o instrutor!');
         $scope.instrutorAtual = instrutor;
    }

    $scope.cancelarInstrutor = function(instrutorAtual){
        delete $scope.instrutorAtual;
        toastr.warning('Você cancelou a edição da aula!');
        $scope.editarInstrutor = false;
    }

    $scope.salvarInstrutor = function(instrutorAtual){
        let idInstrutor = instrutorAtual.id;
        $scope.instrutores.splice(idInstrutor,1,instrutorAtual);
        delete $scope.instrutorAtual;
        toastr.success('Instrutor alterado com sucesso!');
        $scope.editarInstrutor = false;
    }

    $scope.removeInstrutor = function (instrutor){
        if(instrutor.dandoAula.localeCompare('SIM') === 0){
            toastr.error('Você não pode excluir esse instrutor, ele está dando aula!');
            return;
        }
        let idInstrutor = $scope.instrutores.indexOf(instrutor);
        toastr.error('Instrutor excluido com sucesso!');
	    $scope.instrutores.splice(idInstrutor, 1);
    }

    $scope.instrutores = [{
            id: 0,
            nome: 'Bernardo',
            sobrenome: 'Rezende',
            idade: 30,
            email: 'bernardo@cwi.com.br',
            dandoAula: "SIM",
            aula: [0, 4],
            urlFoto: "http://fullmoonbrewwork.com/wp-content/uploads/2014/06/FMBW_Beers_Phuket-Lager-300x300.png"
        },
        {
            id: 1,
            nome: 'André',
            sobrenome: 'Nunes',
            idade: 35,
            email: 'andre.nunes@cwi.com.br',
            dandoAula: "SIM",
            aula: [4],
            urlFoto: "https://pedrotavars.files.wordpress.com/2012/02/moneysmiley.png"
        }
    ];;

    $scope.aulas =[
        {id: 0, nome: 'OO'},
        {id: 1, nome: 'HTML e CSS'},
        {id: 2, nome: 'Javascript'},
        {id: 3, nome: 'AngularJS'},
        {id: 4, nome: 'Banco de Dados I'}
    ];

     if($scope.aulas.length > 0){
        $scope.mostrarAulas = true;
        $scope.mostrarInstrutor = true; 
    }else{
        $scope.mostrarAulas = false;
        $scope.mostrarInstrutor = false;
    }
});

    