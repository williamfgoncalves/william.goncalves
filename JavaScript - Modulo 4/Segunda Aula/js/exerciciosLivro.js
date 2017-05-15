//Exercicio 1
function tringulo(num){
    var hashTag = "#";
    var imprime = new Array;
    for(let i = 0; i < num; i++){
        imprime.push('\n');
        for(let j = 0; j <= i; j++){
            imprime.push(hashTag);
        }
    }
    console.log(imprime.toString());
}
//Exercicio 2
function fizzBuzz(){
    for(let i = 0; i < 100; i++){
        if(i % 3 === 0 || i % 5 === 0){
            console.log("FizzBuzz");
        }
        else{
            console.log(i);
        }
    }
}
//Exercicio 3
function xadrez(tamanho){
    var imprime = new Array;
    for(let i =0; i < tamanho; i++){
        for(let j = 0; j < tamanho/2; j++){
            if(i % 2 === 0 || i === 0){
                imprime.push("#");
                imprime.push(" ");
            }else{
                imprime.push(" ");
                imprime.push("#");
            }
        }
        imprime.push("\n");
    }
    return imprime.toString();
}