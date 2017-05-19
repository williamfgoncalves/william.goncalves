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

let count = 0;
controler.filter('addZerosPad', function(){
        return function(aula){
                count++;
                return '0' + aula.indice + ' - ' + aula.nomeAula.toUpperCase();
        }
});

controler.filter('mascada', function(){
        return function(nome){
                return nome.replace(/(nunes)/gi, '$ $1 $');
        }
});

controler.controller('controllerInstrutores', function($scope) {
        $scope.instrutores = instrutores = [{
                nome: 'Bernardo',
                aula: [{
                        numero: 1,
                        nome: 'OO'
                },
                {
                        numero: 4,
                        nome: 'Javascript'
                }
                ]
                },
                {
                        nome: 'Nunes',
                        aula: [{
                        numero: 2,
                        nome: 'Banco de Dados I'
                }]
                },
                {
                        nome: 'Pedro (PHP)',
                        aula: [{
                        numero: 3,
                        nome: 'HTML e CSS'
                }]
                },
                {
                        nome: 'Zanatta',
                        aula: [{
                        numero: 5,
                        nome: 'AngularJS'
                }]
                }
                ];

        $scope.aulas = novaLista(instrutores);
});

function novaLista(instrutores){
        var novaLista = new Array;
                for(let i = 0; i < instrutores.length; i++){
                        for(let j = 0; j < instrutores[i].aula.length; j++){
                                var aulas = new Object();
                                aulas.nome = instrutores[i].nome;
                                aulas.nomeAula = instrutores[i].aula[j].nome;
                                aulas.indice = instrutores[i].aula[j].numero;
                                novaLista.push(aulas);
                        }
                }
        return novaLista;
}

