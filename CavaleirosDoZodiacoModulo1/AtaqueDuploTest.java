import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest{
   
    @Test
    public void verificaSeRealizaAtaqueDuplo() throws Exception{
        
        Sorteador sorteador = new DadoFalso(3);
        SorteDoDia sorteDoDia = new SorteDoDia(sorteador);
        sorteDoDia.consigoDeferirAtaqueDuplo();
        
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));

        goku.adicionarMovimento(new AtaqueDuplo(goku, vegeta, sorteDoDia));
        goku.getProximoMovimento().executar();
        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(80.0, vegeta.getVida(), 0.1);

    }
    
    @Test
    public void verificaSeNaoRealizaAtaqueDuplo() throws Exception{
        
        Sorteador sorteador = new DadoFalso(2);
        SorteDoDia sorteDoDia = new SorteDoDia(sorteador);
        sorteDoDia.consigoDeferirAtaqueDuplo();
        
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));

        goku.adicionarMovimento(new AtaqueDuplo(goku, vegeta, sorteDoDia));
        goku.getProximoMovimento().executar();
        assertEquals(95.0, goku.getVida(), 0.1);
        assertEquals(90.0, vegeta.getVida(), 0.1);

    }
}
