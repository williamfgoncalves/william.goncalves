 controller.controller('livroController', function ($scope, $routeParams, $location, livroService, toastr){
    
    $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 8,
    };

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

    listarLivrosLancamentos();
    listarlivrosNaoLancamento();
});