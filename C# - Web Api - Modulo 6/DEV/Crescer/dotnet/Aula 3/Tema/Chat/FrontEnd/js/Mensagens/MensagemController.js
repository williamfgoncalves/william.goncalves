    controller.controller('MensagemController', function ($scope, $routeParams, $localStorage, MensagemService, toastr){

        // Buscando as mensagens

        var recursiva = function () {
            listaTodasMensagens()
            setInterval(recursiva,2000);
        }

        recursiva();

        function listaTodasMensagens() {
            MensagemService.listarMensagens().then(function (response) {
            $scope.mensagens = response.data;
            });
        }

        $scope.usuario = {nome:localStorage.getItem('nome'), foto:localStorage.getItem('foto')};

        $scope.addMensagem = function (mensagem){

        mensagem.usuario = $scope.usuario;

        MensagemService.criarMensagens(mensagem).then(function (response){
                setInterval(listaTodasMensagens(), 1000);
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