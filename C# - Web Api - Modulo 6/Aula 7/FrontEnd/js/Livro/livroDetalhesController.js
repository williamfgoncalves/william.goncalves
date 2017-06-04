angular.module('editoraCwi').controller('livroDetalhesController', function ($scope, $routeParams, livroService){

    buscarLivro($routeParams.id);

    function buscarLivro(id) {
        livroService.listarLivroPorId(id).then(function (response) {
             $scope.livro = response.data.dados;
      })
    };
});