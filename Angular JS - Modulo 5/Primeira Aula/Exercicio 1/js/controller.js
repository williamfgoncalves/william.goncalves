//Criacao do modulo 
var app = angular.module('myApp', []);

//Criacao da minha controller, adicionando a chamada para o scope
app.controller('controller', function($scope) {
         //Criamos abaixo um objeto pokemon dentro do scope
         $scope.pokemon = {
         nome: "Pikachu",
         tipo: "raio",
         imagem: "http://sm.ign.com/ign_br/screenshot/default/025pikachu-os-anime-4_3pym.png"
        }
});

app.controller('controller2', function($scope) {
         //Criamos abaixo um objeto pokemon dentro do scope
         $scope.pokemons = [
        {
         nome: "Pikachu",
         tipo: "Raio",
        },
        {
         nome: "Squirtle",
         tipo: "Agua",
        },
        {
         nome: "Charmander",
         tipo: "Fogo",
        }]
});