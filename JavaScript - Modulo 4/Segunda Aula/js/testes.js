describe("Testando seriesInvalidas()", function() {
    it("Teste para o array series", function() {
        var resultado = "Narcos - Band of Brothers - Mr. Robot";
        expect(resultado).toBe(seriesInvalidas(series));
    });
});

describe("Testando filtrarSeriesPorAno()", function() {
    it("Teste para o array series", function() {
        var resultado = "Series Invalidas: The Walking Dead - 10 Days Why";
        expect(resultado).toBe(filtrarSeriesPorAno(2010, series));
    });
});

describe("Testando mediaDeEpisodios()", function() {
    it("Teste para o array series", function() {
        var resultado =34.1;
        expect(resultado).toBe(mediaDeEpisodios(series));
    });
});

describe("Testando procurarPorNome()", function() {
    it("Teste para o array series", function() {
        var resultado = true;
        expect(resultado).toBe(procurarPorNome(series, "William Goncalves"));
    });
});

describe("Testando mascadaEmSerie()", function() {
    it("Teste para o array series", function() {
        var resultado =880;
        expect(resultado).toBe(mascadaEmSerie(series[2]));
    });
});

describe("Testando queroGenero()", function() {
    it("Teste para o array series", function() {
        var resultado ="Stranger Things,Game Of Thrones,Mr. Robot,Narcos,Westworld,Breaking Bad";
        expect(resultado).toBe(queroGenero("Drama"));
    });
});

describe("Testando queroTitulo()", function() {
    it("Teste para o array series", function() {
        var resultado ="The Walking Dead,Bernardo The Master of the Wizards";
        expect(resultado).toBe(queroTitulo("The"));
    });
});

describe("Testando creditosIlluminatis()", function() {
    it("Teste para o array series", function() {
        var resultado1 = "Titulo da Série: The Walking Dead Diretor da Série: Bellson,Dale,Gadd,Womble Elenco da Série: ,,Bernthal,Callies,Cohan,DeMunn,Gurira,Holden,Lincoln,Morrissey,Reedus,Yeun";
        expect(resultado1).toBe(creditosIlluminatis(series[2]));
    });
});
describe("Testando esterEggIluminati()", function() {
    it("Teste para o array series", function() {
        var resultado1 = "N,U,N,E,S,I,r,L,U,M,I,N,A,T,I";
        expect(resultado1).toBe(esterEggIluminati(series));
    });
});