    controller.controller('InstrutorController',  function ($scope, $routeParams, InstrutorService, AulaService, toastr){
    
    $scope.exibirInstrutor = true;

    listaTodosInstrutores();    
    //metodo que retonar todas as aulas
    function listaTodosInstrutores() {
            InstrutorService.listarInstrutores().then(function (response) {
            $scope.instrutores = response.data;
        });
    }
    
    function listaTodasAulas() {
            AulaService.listarAulas().then(function (response) {
            $scope.aulas = response.data;
        });
    }
    
    $scope.aulas = listaTodasAulas();

    function estaDandoAula(instrutor){
        let dandoAula = instrutor.dandoAula.localeCompare('SIM'); 
        if(dandoAula === 0){
            instrutor.dandoAula = true;
        }else{
            instrutor.dandoAula = false;
        }
    }
    
    $scope.nomeAula = function(id) {
        return $scope.aulas.find(a => a.id === id).nome;
    }

    $controller.filter('nomeDandoAula',function(nome) {
        if(nome === 'true'){
            return 'SIM';
        }else{
            return 'NÃO'
        }
    }
    
    $scope.addInstrutor = function (instrutor){
        if($scope.form1.$valid){
            if(instrutor.urlFoto === "" || typeof instrutor.urlFoto === "undefined"){
                instrutor.urlFoto = "https://pescadordesonhos.files.wordpress.com/2009/12/1-anonimo-famoso-oow.jpg";
            }
            estaDandoAula(instrutor);
            InstrutorService.create(instrutor).then(function(response){
                toastr.success('Instrutor adicionado com sucesso!');
            });
            delete $scope.instrutor;
            $scope.mostrarEdicao = false;
        }
        else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }
        listaTodosInstrutores();
    }

    $scope.editInstrutor = function (instrutor) {
         $scope.editarInstrutor = true;
         $scope.exibirInstrutor = false;
         toastr.info('Você está editando o instrutor!');
         $scope.instrutorAtual = angular.copy(instrutor);
    }

    $scope.cancelarInstrutor = function(instrutorAtual){
        delete $scope.instrutorAtual;
        toastr.warning('Você cancelou a edição da aula!');
        $scope.editarInstrutor = false;
        $scope.exibirInstrutor = true;
    }

    $scope.salvarInstrutor = function(instrutorAtual){
        if($scope.form2.$valid){
            if(instrutorAtual.urlFoto === "" || typeof instrutorAtual.urlFoto === "undefined"){
                instrutorAtual.urlFoto = "https://pescadordesonhos.files.wordpress.com/2009/12/1-anonimo-famoso-oow.jpg";
            }
            estaDandoAula(instrutorAtual);
            InstrutorService.update(instrutorAtual).then(function(response){
                toastr.success('Instrutor alterado com sucesso!');
            });
            delete $scope.instrutorAtual;
            $scope.editarInstrutor = false;
            $scope.exibirInstrutor = true;
        }
        else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }
        listaTodosInstrutores();   
    }

    $scope.removeInstrutor = function (instrutor){
        InstrutorService.remove(instrutor).then(function(response){
                toastr.success('Instrutor excluido com sucesso!');
                listaTodosInstrutores();                
        });
    }
});

    