//Criacao do modulo 
var controller = angular.module('aula3', []);

controller.controller('controllerForm', function($scope){
    
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

    $scope.addAula = function (aula){
        if($scope.formAula.$valid){
            let compararNome = compararNomes($scope.aulas, aula);
            if(compararNome === 0){
                alert("Esta aula já existe");
                return;
            }
            aula.id = gerarId($scope.aulas);
            $scope.aulas.push(angular.copy(aula));
            delete $scope.aula;
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
            let compararNome = compararNomes($scope.instrutores, instrutor);
            if(compararNome === 0){
                alert("Este professor já existe");
                return;
            }
            instrutor.id = gerarId($scope.instrutores);
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
        if(instrutor.dandoAula.localeCompare('SIM') === 0){
            alert('Você não pode excluir esse professor, ele está dando aula!');
            return;
        }
        let idInstrutor = $scope.instrutores.indexOf(instrutor);
	    $scope.instrutores.splice(idInstrutor, 1);
    }

    $scope.instrutores = [{
            id: 0,
            nome: 'Bernardo',
            sobrenome: 'Rezende',
            idade: 30,
            email: 'bernardo@cwi.com.br',
            dandoAula: "SIM",
            aula: ["0", "4"],
            urlFoto: "http://fullmoonbrewwork.com/wp-content/uploads/2014/06/FMBW_Beers_Phuket-Lager-300x300.png"
        },
        {
            id: 1,
            nome: 'André',
            sobrenome: 'Nunes',
            idade: 35,
            email: 'andre.nunes@cwi.com.br',
            dandoAula: "SIM",
            aula: ["4"],
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

    