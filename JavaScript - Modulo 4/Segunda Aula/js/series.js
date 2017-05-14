var series = JSON.parse('[{"titulo":"Stranger Things","anoEstreia":2016,"diretor":["Matt Duffer","Ross Duffer"],"genero":["Suspense","Ficcao Cientifica","Drama"],"elenco":["Winona Ryder","David Harbour","Finn Wolfhard","Millie Bobby Brown","Gaten Matarazzo","Caleb McLaughlin","Natalia Dyer","Charlie Heaton","Cara Buono","Matthew Modine","Noah Schnapp"],"temporadas":1,"numeroEpisodios":8,"distribuidora":"Netflix"},{"titulo":"Game Of Thrones","anoEstreia":2011,"diretor":["David Benioff","D. B. Weiss","Carolyn Strauss","Frank Doelger","Bernadette Caulfield","George R. R. Martin"],"genero":["Fantasia","Drama"],"elenco":["Peter Dinklage","Nikolaj Coster-Waldau","Lena Headey","Emilia Clarke","Kit Harington","Aidan Gillen","Iain Glen  ","Sophie Turner","Maisie Williams","Alfie Allen","Isaac Hempstead Wright"],"temporadas":6,"numeroEpisodios":60,"distribuidora":"HBO"},{"titulo":"The Walking Dead","anoEstreia":2010,"diretor":["Jolly Dale","Caleb Womble","Paul Gadd","Heather Bellson"],"genero":["Terror","Suspense","Apocalipse Zumbi"],"elenco":["Andrew Lincoln","Jon Bernthal","Sarah Wayne Callies","Laurie Holden","Jeffrey DeMunn","Steven Yeun","Chandler Riggs ","Norman Reedus","Lauren Cohan","Danai Gurira","Michael Rooker ","David Morrissey"],"temporadas":7,"numeroEpisodios":99,"distribuidora":"AMC"},{"titulo":"Band of Brothers","anoEstreia":20001,"diretor":["Steven Spielberg","Tom Hanks","Preston Smith","Erik Jendresen","Stephen E. Ambrose"],"genero":["Guerra"],"elenco":["Damian Lewis","Donnie Wahlberg","Ron Livingston","Matthew Settle","Neal McDonough"],"temporadas":1,"numeroEpisodios":10,"distribuidora":"HBO"},{"titulo":"Bernardo The Master of the Wizards","anoEstreia":2017,"diretor":["James Bajczuk","Marcio Tesser","Andre Nunes"],"genero":["Terror","Caos","JavaScript"],"elenco":["Alana Weiss","Alexia Pereira","Bruno Aguiar","Camila Batista","Christopher Michel","Claudia Moura","Deordines Tomazi","Diandra Rocha","Jabel Fontoura","João Silva","Jomar Cardoso","Leonardo Alves","Leonardo Morais","Lucas Damaceno","Lucas Gaspar","Lucas Muller","Luis Robinson","Maico Kley","Mateus Silva","Mathias Ody","Mirela Adam","Rafael Barizon","Rafael Barreto","Tais Silva","William Goncalves"],"temporadas":1,"numeroEpisodios":40,"distribuidora":"CWI"},{"titulo":"10 Days Why","anoEstreia":2010,"diretor":["Brendan Eich"],"genero":["Caos","JavaScript"],"elenco":["Brendan Eich","Bernardo Bosak"],"temporadas":10,"numeroEpisodios":10,"distribuidora":"JS"},{"titulo":"Mr. Robot","anoEstreia":2018,"diretor":["Sam Esmail"],"genero":["Drama","Techno Thriller","Psychological Thriller"],"elenco":["Rami Malek","Carly Chaikin","Portia Doubleday","Martin Wallström","Christian Slater"],"temporadas":2,"numeroEpisodios":22,"distribuidora":"USA Network"},{"titulo":"Narcos","anoEstreia":2015,"diretor":["Paul Eckstein","Mariano Carranco","Tim King","Lorenzo O Brien"],"genero":["Documentario","Crime","Drama"],"elenco":["Wagner Moura","Boyd   Holbrook","Pedro Pascal","Joann Christie","Mauricie Compte","André Mattos","Roberto Urbina","Diego Cataño","Jorge A. Jiménez","Paulina Gaitán","Paulina Garcia"],"temporadas":2,"numeroEpisodios":20,"distribuidora": null},{"titulo":"Westworld","anoEstreia":2016,"diretor":["Athena Wickham"],"genero":["Ficcao Cientifica","Drama","Thriller","Acao","Aventura","Faroeste"],"elenco":["Evan N. Rachel Wood","Thandie U. Newton","Jeffrey N. Wright","James E. Marsden","Ben S. Barnes","Ingrid I. Bolso Berdal","Clifton L. Collins Jr.","Luke L. Hemsworth","Sidse U. Babett Knudsen","Simon M. Quarterman","Rodrigo I. Santoro","Tessa N. Thompson","Shannon A. Woodward","Ed T. Harris","Anthony I. Hopkins"],"temporadas":1,"numeroEpisodios":10,"distribuidora":"HBO"},{"titulo":"Breaking Bad","anoEstreia":2008,"diretor":["Vince Gilligan","Michelle MacLaren","Adam Bernstein","Colin Bucksey","Michael Slovis","Peter Gould"],"genero":["Acao","Suspense","Drama","Crime","Humor Negro"],"elenco":["Bryan Cranston","Anna Gunn","Aaron Paul","Dean Norris","Betsy Brandt","RJ Mitte"],"temporadas":5,"numeroEpisodios":62,"distribuidora":"AMC"}]');
console.log(series);

//Exercicio 1
function seriesInvalidas(series){
    seriesInvalidadas = new Array;
    var data = new Date();
    for(let i = 0; i < series.length; i++){
        if(series[i].anoEstreia > data.getFullYear() || Object.values(series[1]) === "undefined" ||
        Object.values(series[1]) === "null"){
            seriesInvalidadas.push(series[i].titulo);           
        }
    }
    return seriesInvalidadas.toString();
}

//Exercicio 2
function filtrarSeriesPorAno(ano, series){
    seriesFiltradas = new Array;
    var data = new Date();
    for(let i = 0; i < series.length; i++){
        if(series[i].anoEstreia >= ano){
            seriesFiltradas.push(series[i].titulo);
        }
    }
    return seriesFiltradas;
}

//Exercicio 3
function mediaDeEpisodios(series){
    var mediaSeries = 0;
    for(let i = 0; i < series.length; i++){
        mediaSeries += series[i].numeroEpisodios;
    }
    mediaSeries = mediaSeries/series.length;
    return mediaSeries;
}

//Exercicio 4
function procurarPorNome(series, nome){
    var ator;
    for(let i = 0; i < series.length; i++){
        for(let j = 0; j < series[i].elenco.length; j++){
            if(series[i].elenco[j].localeCompare(nome) === 0){
                ator = series[i].elenco[j];
            }
        }
    }
    return ator;
}

//Exercicio 5
function mascadaEmSerie(series){
    var soma = 0;
    var diretores = (soma += series.diretor.length)*100.000
    soma = 0;
    var elencos = (soma += series.elenco.length)*40.000
    return soma = elencos+diretores;
}

//Exercicio 6
//A
function queroGenero(qualGenero){
    seriesFiltradasGenero = new Array;
     for(let i = 0; i < series.length; i++){
        for(let j = 0; j < series[i].genero.length; j++){
            if(series[i].genero[j].localeCompare(qualGenero) === 0){
                seriesFiltradasGenero.push(series[i].titulo);
            }
        }
    }
    return seriesFiltradasGenero;
}

//B
function queroTitulo(qualTitulo){
    seriesTitulo = new Array;
    for(let i = 0; i < series.length; i++){
        if(series[i].titulo.includes(qualTitulo)){
            seriesTitulo.push(series[i].titulo);
        }
    }
     return seriesTitulo;
}

//Exercicio 7
function creditosIlluminatis(series){
    var diretores = new Array;
    var elencos = new Array;
    for(let i = 0; i<series.diretor.length; i++){
        diretores.push(series.diretor[i].substring(series.diretor[i].lastIndexOf(" ")+1,series.diretor[i].length))
    }
    for(let i = 0; i<series.elenco.length; i++){
        elencos.push(series.elenco[i].substring(series.elenco[i].lastIndexOf(" ")+1,series.elenco[i].length))
    }
    console.log("Titulo da Série: " + series.titulo + "\nDiretor da Série: " +  diretores.sort() + "\nElenco da Série: " + elencos.sort());
}

//Exercicio 8
function esterEggIluminati(series){
    var serieIluminati = serieEsterEgg(series);
    var elencos = new Array;
    for(let i = 0; i < serieIluminati.elenco.length; i++){
        var p1 = serieIluminati.elenco[i].lastIndexOf(".")-1;
        var p2 = p1+1;
        elencos.push(serieIluminati.elenco[i].substring(p1, p2));
    }
    return elencos;
}

function serieEsterEgg(series){
    var controle = 0;
    for(let i = 0; i < series.length; i++){
       for(let j = 0; j < series[i].elenco.length; j++){
            if(series[i].elenco[j].includes(".")){
                controle++;
                if(controle === series[i].elenco.length){
                    return series[i];
                }
            }
        }
    }
}

