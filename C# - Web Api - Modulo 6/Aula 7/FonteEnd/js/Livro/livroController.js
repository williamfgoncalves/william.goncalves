 controller.controller('livroController', function ($scope, $routeParams, $localStorage, livroService, toastr){

    function listarTodosLivros() {
        livroService.listarLivros().then(function (response) {
            $scope.livros = response.data.dados;
        });
    };
    
    listarTodosLivros();
  });