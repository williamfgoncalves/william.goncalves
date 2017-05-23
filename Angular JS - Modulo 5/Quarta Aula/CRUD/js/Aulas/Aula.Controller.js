    controller.controller('Aula.Controller', function ($scope){

        $scope.addAula = function (aula){
            if($scope.formAula.$valid){
                $scope.aulas.push(angular.copy(aula));
                delete $scope.aula;
                alert('Aula adicionada com sucesso!');
                $scope.mostrarAulas = true;
            }else{
                alert("Algum campo está errado ou faltando informação!");
            }
        }

        $scope.nomeAula = function(id) {
            return $scope.aulas.find(a => a.id === id).nome;
        }

        $scope.editAula = function (aula) {
            $scope.editarAula = true;
            alert('Você está editando uma aula!');
            $scope.aulaAtual = angular.copy(aula);
        }

        $scope.salvarAula = function(aulaAtual){
            if($scope.formEditarAula.$valid){
                let idaula = aulaAtual.id;
                $scope.aulas.splice(idaula,1,aulaAtual);
                delete $scope.aulaAtual;
                alert('Aula alterada com sucesso!');
                $scope.editarAula = false;
            }else{
                toastr.error("Algum campo está errado ou faltando informação!");
            }
        }

        $scope.cancelar = function(aulaAtual){
            delete $scope.aulaAtual;
            alert('Você cancelou a edição da aula!');
            $scope.editarAula = false;
        }

        $scope.removeAula = function (aula){
            let idAula = $scope.aulas.indexOf(aula);
            $scope.aulas.splice(idAula, 1);
        }

    });