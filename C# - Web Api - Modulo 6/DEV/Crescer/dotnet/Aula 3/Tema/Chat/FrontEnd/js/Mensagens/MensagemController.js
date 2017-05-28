    controller.controller('MensagemController', function ($scope, $routeParams, $localStorage, MensagemService, toastr){

        listaTodasMensagens();

        function listaTodasMensagens() {
            MensagemService.listarMensagens().then(function (response) {
            $scope.mensagens = response.data;
            });
        }

        $scope.addMensagem = function (mensagem){
        MensagemService.criarMensagens(mensagem).then(function (response){
                mensagem.usuario = localStorage.getItem(usuario);
                listaTodasMensagens();
            });

            delete $scope.mensagem;
        }

        /*$scope.cancelar = function(aulaAtual){
            delete $scope.aulaAtual;
            toastr.warning('Você cancelou a edição da aula!');
            $scope.editarAula = false;
            $scope.exibirAula = true;
        }*/
    });