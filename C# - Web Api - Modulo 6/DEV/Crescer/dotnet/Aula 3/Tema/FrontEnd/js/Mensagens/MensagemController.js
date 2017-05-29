    controller.controller('MensagemController', function ($scope, $routeParams, $localStorage, MensagemService, toastr){

        if(localStorage.getItem("nome") === null && localStorage.getItem("foto") === null) logout();

        $scope.logout = logout;

        function logout() {
            localStorage.clear();
            location.href = '#!/login';
            toastr.error("Informações invalidas ou usuario nao cadastrado!");
        }

        var recursiva = function () {
            listaTodasMensagens()
            setTimeout(recursiva,3000);
        }

        recursiva();

        function listaTodasMensagens() {
            MensagemService.listarMensagens().then(function (response) {
            $scope.mensagens = response.data;
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