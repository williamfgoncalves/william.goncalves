    controller.controller('MensagemController', function ($scope, $routeParams, $localStorage, MensagemService, toastr){

        // Buscando as mensagens

        var recursiva = function () {
            listaTodasMensagens()
            setInterval(recursiva,2000);
        }

        //recursiva();

        function listaTodasMensagens() {
            MensagemService.listarMensagens().then(function (response) {
            $scope.mensagens = response.data;
            debugger;
            });
        }

        $scope.usuario = {nome:localStorage.getItem('nome'), UrlFoto:localStorage.getItem('foto')};

        $scope.addMensagem = function (mensagem){

        mensagem.usuario = $scope.usuario;

        MensagemService.criarMensagens(mensagem).then(function (response){
                listaTodasMensagens();
            });
            delete $scope.mensagem;
        }
    });