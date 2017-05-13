//Exercicio 1
function daisyGame(a){
    if(a % 2 === 0){
        return console.log("Love me not!");
    }else{
        return console.log("Love me!");
    }
}
daisyGame(4)
daisyGame(5)

//exercicio 2
function maiorTexto(textos){
    var maior = textos[0];
    for(var i = 1; i < textos.length; i++){
        if(maior.length < textos[i].length){
            maior = textos[i];
        }
    }
    return console.log(maior);
}
maiorTexto(['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'])

//Exercicio 3
var funcao = function (a){ return console.log(a)}

function imprime(nomes, funcao){
    if(typeof funcao !== "function"){
        console.log("Jabulani");
        alert("VOCE ESTA PASSANDO UM PARAMETRO ERRADO!!!");
        return;
    }
    for(var i = 0; i < nomes.length; i++){
        funcao("Bem Vindo Instrutor " + nomes[i]);
    }
}
imprime(['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'], funcao)
imprime(['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'], false)

//Exercicio 4
function somar(numeroUm){
    return function(numeroDois){
        console.log(numeroUm+numeroDois);
    }
};
somar(10)(-7)

//Exercicio 5
function fibonacci(a){
    if(a === 1 || a === 2){
        return console.log(1);
    }else{
        var b = 1;
        var c = 1;
        var soma;
        for(var i = 0; i < a; i++){
            soma = b + c;
            b = c;
            c = soma;
        }
        return console.log(soma-1);
    }
}
fibonacci(100)

//exercicio 6
function queroCafe(mascada, precos){
    var cafesPossiveis = "";
    precos.sort();
    for(var i = 0; i < precos.length; i++){
        if(mascada > precos[i]){
             console.log(cafesPossiveis.concat(String(precos[i])));
        }
    }
}
queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);