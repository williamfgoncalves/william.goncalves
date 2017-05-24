    controller.controller('AulaController', function ($scope, $routeParams, AulaService, toastr){

        $scope.exibirAula = true;

        listaTodasAulas();

        //metodo que retonar todas as aulas
         function listaTodasAulas() {
            AulaService.listarAulas().then(function (response) {
            $scope.aulas = response.data;
            });
        }

        $scope.addAula = function (aula){
            if($scope.formAula.$valid){
                AulaService.create(aula).then(function (response){
                    toastr.success('Aula adicionada com sucesso!');
                    listaTodasAulas();
                });
            }else{
                toastr.error("Algum campo está errado ou faltando informação!");
            }

            $scope.aula = {};
        }

         $scope.removeAula = function (aula){
            AulaService.remove(aula).then(function (response){
                toastr.success('Aula excluida com sucesso!');
                listaTodasAulas();
            })
        }

         $scope.editAula = function (aula) {
            $scope.editarAula = true;
            $scope.exibirAula = false;
            toastr.info('Você está editando uma aula!');
            $scope.aulaAtual = angular.copy(aula);
        }

        $scope.salvarAula = function(aulaAtual){
            if($scope.formEditarAula.$valid){
                AulaService.update(aulaAtual);
                delete $scope.aulaAtual;
                listaTodasAulas();
                toastr.success('Aula alterada com sucesso!');
                $scope.editarAula = false;
                $scope.exibirAula = true;
            }else{
               toastr.error("Algum campo está errado ou faltando informação!");
            }
        }

        $scope.cancelar = function(aulaAtual){
            delete $scope.aulaAtual;
            toastr.warning('Você cancelou a edição da aula!');
            $scope.editarAula = false;
            $scope.exibirAula = true;
        }
    });