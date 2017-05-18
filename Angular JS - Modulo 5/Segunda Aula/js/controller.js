//Criacao do modulo 
var controler = angular.module('aula2', []);

//Criacao da minha controller, adicionando a chamada para o scope
controler.controller('controllerData', function($scope, $filter) {
        
        $scope.exibirData = exibirData;
        
        function exibirData(data){
                $scope.data = data;
                if (angular.isUndefined($scope.data)) {
                        return;
                }
                $scope.dataPronta = $filter('date')(data, 'shortDate')
        }
});