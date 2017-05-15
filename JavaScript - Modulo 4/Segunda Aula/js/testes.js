describe("Testando seriesInvalidas()", function() {
    it("Teste para o array series", function() {
        var resultado = "Band of Brothers,Mr. Robot";
        expect(resultado).toBe(seriesInvalidas(series));
    });
});

describe("Testando filtrarSeriesPorAno()", function() {
    it("Teste para o array series", function() {
        var resultado = "Stranger Things,Band of Brothers,Bernardo The Master of the Wizards,Mr. Robot,Narcos,Westworld";
        expect(resultado).toBe(filtrarSeriesPorAno(2015, series));
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
        var resultado = "William Goncalves";
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
