angular.module('editoraCwi').controller('livroController', function ($scope, $routeParams, $localStorage, $location, livroService, toastr){
    
    console.log("Rwste");

    $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 6,
    };

    $scope.retornarPagina = function(){
            $scope.parametros.quantidadePular -= 6;
            
            if($scope.parametros.quantidadePular < 0){
                $scope.parametros.quantidadePular = 0;
                return;
            }

            listarlivrosNaoLancamento();
    }
    $scope.avancarPagina = function(){
            $scope.parametros.quantidadePular += 6;
            listarlivrosNaoLancamento();
    }

    function listarTodosOsLivros(){
        livroService.listarTodosLivros().then(function (response){
            $scope.livrosTodos = response.data.dados;
        })
    }

    function listarLivrosLancamentos(){
        livroService.listarLivrosLancamentos().then(function (response){
            $scope.livrosLancamentos = response.data.dados;
        })
    }

    function listarlivrosNaoLancamento(){
        livroService.listarLivrosQueNaoSaoLancamentos($scope.parametros).then(function (response) {
            $scope.livrosNaoLancamentos = response.data.dados;
        });
    };

    $scope.verLivro = function (id) {
        $location.path('/livros/' + id);
    }

    $scope.logar = function(){
        $location.path('/login');
    }

    $scope.adicionarLivro = function(livro){
        console.log("Entrei");
        if($scope.formLivro.$valid){
            livroService.adicionarLivro(livro, $localStorage.headerAuth).then(function(response){
                 toastr.success('Livro adicionado com sucesso!');
            });
            delete $scope.livro;
            $scope.mostrarEdicao = false;
        }else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }
    }

    $scope.editarLivro = function (livro) {
         $scope.livroAtual = angular.copy(livro);
    }

    $scope.salvarLivro = function(livroAtual){
        if($scope.formLivroEditado.$valid){
            livroService.editarLivro(livroAtual, $localStorage.headerAuth).then(function(response){
                toastr.success('Instrutor alterado com sucesso!');
            });
            delete $scope.livroAtual;
            $scope.editarInstrutor = false;
            $scope.exibirInstrutor = true;
        }
        else{
            toastr.error("Algum campo está errado ou faltando informação!");
        }
    }

    listarTodosOsLivros();
    listarLivrosLancamentos();
    listarlivrosNaoLancamento();
});