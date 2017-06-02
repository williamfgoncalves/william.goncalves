 controller.controller('livroController', function ($scope, $routeParams, $localStorage, livroService, toastr){
    
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

    function listarLivroPorId(){
        livroService.listarLivroPorId($scope.idAtual).then(function (response){
            $scope.livroPorId = response.data.dados;
            debugger;
            console.log($scope.livroPorId);
        })
    }

    $scope.verLivro = function (id) {
        $scope.idAtual = id;          
        listarLivroPorId();
        location.href = '#!/livroDetalhes';
    }

    listarLivrosLancamentos();
    listarlivrosNaoLancamento();
});