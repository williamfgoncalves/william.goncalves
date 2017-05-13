
console.log("Carregou");
//alert("Bem Vindo!!");
//var pi = 3.14;

if(typeof pi !== "undefined"){
    console.log(pi);
}

function somaDoisNumeros(a,b,c){
    c = c || 3;
    return a+b;
}

//var somar = (a,b, c=3) => a+b;
// formato de arrowFunction, uma especie de lambda de javascript

var somar = function(a,b, c){
    c = c || 3;
    return a + b;
} // criado uma função que nao tem nome, porem a referencia dela é a variavel acima;

var somarArrowFunction = (a,b) => a+b;

console.log(somar(1,2,3));
// podemos fazer isso, mesmo que a function recebe apenas dois valores, porem ele ignora o terceiro

var somar = function(){
    var a = arguments[0], b = arguments[1];
    return a + b;
}
console.log(somar(3,4));

//funcao que é atribuida a uma variavel e ja é chamada loga na esquencia
var resultado = function(a,b){return a*b}(2,3); // 2,3 é chamada da funcao já escrita anterioemente;
console.log(resultado); // printamos o resultado