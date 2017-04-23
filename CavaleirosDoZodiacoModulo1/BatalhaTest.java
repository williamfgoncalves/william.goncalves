import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void testarBatalhaSaintUmMaiorQueSaintDois()throws Exception{
        
        Constelacao cancer = new Constelacao("Câncer");
        Constelacao leao = new Constelacao("Leao");
        
        Saint goku = new GoldSaint("Goku", cancer.getNome());
        Golpe hadukem = new Golpe("Hadukem", 10);
        Golpe meteoroPegaso = new Golpe("Meteoro Pegaso", 20);
        goku.aprenderGolpes(hadukem);
        goku.aprenderGolpes(meteoroPegaso);
        
        Saint vegeta= new SilverSaint("Vegeta", leao.getNome());
        Golpe kamehameha = new Golpe("kamehameha", 30);
        vegeta.aprenderGolpes(kamehameha);
        
        //primereiras batalhas sem casaco
        Golpear batalha = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha);
        Golpear batalha2 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha2);
        
        VestirArmadura botaCasaco = new VestirArmadura(goku);
        goku.adicionarMovimento(botaCasaco);
        VestirArmadura colocaCasaco = new VestirArmadura(vegeta);
        vegeta.adicionarMovimento(colocaCasaco);
        
        Golpear batalha3 = new Golpear(vegeta, goku);
        vegeta.adicionarMovimento(batalha3);
        Golpear batalha4 = new Golpear(goku, vegeta);
        goku.adicionarMovimento(batalha4);
        
        Batalha batalhaSayajin = new Batalha(goku, vegeta);
        batalhaSayajin.iniciar();

        assertEquals(0.0, goku.getVida(), 0.1);
        assertEquals(10.0, vegeta.getVida(), 0.1);
    }
    
   /*@Test
    public void testarBatalhaSaintUmIgualSaintDois()throws Exception{
        Constelacao aquario = new Constelacao("Aquário");
        Constelacao aries = new Constelacao("Áries");
        Saint shiryu = new GoldSaint("shiryu", aquario.getNome());
        Saint ikki = new SilverSaint("ikki", aries.getNome());
        Batalha batalha = new Batalha(shiryu, ikki);
        batalha.iniciar();
        assertEquals(100.0, shiryu.getVida(), 0.1);
        assertEquals(90.0, ikki.getVida(), 0.1);
    }
    
    @Test
    public void testarBatalhaSaintDoisMaiorQueSaintUm()throws Exception{
        Constelacao virgem = new Constelacao("Virgem");
        Constelacao sagitario = new Constelacao("Sagitário");
        Saint shiryu = new SilverSaint("shiryu", virgem.getNome());
        Saint ikki = new GoldSaint("ikki", sagitario.getNome());
        Batalha batalha = new Batalha(shiryu, ikki);
        batalha.iniciar();
        assertEquals(90.0, shiryu.getVida(), 0.1);
        assertEquals(100.0, ikki.getVida(), 0.1);
    }*/
}
