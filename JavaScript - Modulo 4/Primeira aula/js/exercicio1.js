//Exercicio 1
function daisyGame(a){
    if(a % 2 === 0){
        console.log("Love me not!");
    }else{
        console.log("Love me!");
    }
}

//exercicio 2
function ordenar(palavras){
    var maior = palavras[0];
    for(var i = 1; i < palavras.length; i++){
        if(maior.length < palavras[i].length){
            maior = palavras[i];
        }
    }
    return console.log(maior);
}

//Exercicio 3
var funcao = function funcao(a){ console.log(a)}

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

//Exercicio 4
function somar(numeroUm){
    return function(numeroDois){
        console.log(numeroUm+numeroDois);
    }
};

//Exercicio 5
function fibonacci(a){
    if(a === 1){
        console.log(1);
    } else if(a === 2){
        console.log(1);
    }else{
        var b = 1;
        var c = 1;
        var soma;
        var sum = 0;
        for(var i = 0; i < a; i++){
            soma = b + c;
            b = c;
            c = soma;
        }
        return console.log(soma-1);
    }
}

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