import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void testarBatalhaSaintUmMaiorQueSaintDois()throws Exception{

        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));
        goku.aprenderGolpes(new Golpe("Meteoro Pegaso", 20));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));
        
        Golpear batalha = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha);
        Golpear batalha2 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha2);
        vegeta.adicionarMovimento(new VestirArmadura(vegeta));
        goku.adicionarMovimento(new VestirArmadura(goku));
        Golpear batalha3 = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha3);
        Golpear batalha4 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha4);
        
        Batalha batalhaSayajin = new Batalha(goku, vegeta);
        batalhaSayajin.iniciar();

        assertEquals(0.0, goku.getVida(), 0.1);
        assertEquals(80.0, vegeta.getVida(), 0.1);
    }
    
   @Test
    public void testarBatalhaSaintUmIgualSaintDois()throws Exception{
        Saint goku = new SilverSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));
        goku.aprenderGolpes(new Golpe("Meteoro Pegaso", 20));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));
        
        Golpear batalha = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha);
        Golpear batalha2 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha2);
        vegeta.adicionarMovimento(new VestirArmadura(vegeta));
        goku.adicionarMovimento(new VestirArmadura(goku));
        Golpear batalha3 = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha3);
        Golpear batalha4 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha4);
        
        Batalha batalhaSayajin = new Batalha(goku, vegeta);
        batalhaSayajin.iniciar();

        assertEquals(0.0, goku.getVida(), 0.1);
        assertEquals(80.0, vegeta.getVida(), 0.1);
    }
    
    @Test
    public void testarBatalhaSaintDoisMaiorQueSaintUm()throws Exception{
        Saint goku = new BronzeSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));
        goku.aprenderGolpes(new Golpe("Meteoro Pegaso", 20));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));
        
        Golpear batalha = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha);
        Golpear batalha2 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha2);
        vegeta.adicionarMovimento(new VestirArmadura(vegeta));
        goku.adicionarMovimento(new VestirArmadura(goku));
        Golpear batalha3 = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha3);
        Golpear batalha4 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha4);
        
        Batalha batalhaSayajin = new Batalha(goku, vegeta);
        batalhaSayajin.iniciar();

        assertEquals(0.0, goku.getVida(), 0.1);
        assertEquals(50.0, vegeta.getVida(), 0.1);
    }
}
