import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest{
   
    @Test
    public void verificaSeRealizaAtaqueDuploComArmadura() throws Exception{
        
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));
        goku.adicionarMovimento(new VestirArmadura(goku));
        goku.getProximoMovimento().executar();
        goku.adicionarMovimento(new AtaqueDuplo(goku, vegeta));
        goku.getProximoMovimento().executar();
        
        if(vegeta.getVida() == 20){
            assertEquals(100.0, goku.getVida(), 0.1);
            assertEquals(20.0, vegeta.getVida(), 0.1);
        }else{
            assertEquals(95.0, goku.getVida(), 0.1);
            assertEquals(60.0, vegeta.getVida(), 0.1);
        }
    }
    
    @Test
    public void verificaSeRealizaAtaqueDuploSemArmadura() throws Exception{
        
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));

        goku.adicionarMovimento(new AtaqueDuplo(goku, vegeta));
        goku.getProximoMovimento().executar();
        
        if(goku.getVida() == 100){
            assertEquals(100.0, goku.getVida(), 0.1);
            assertEquals(90.0, vegeta.getVida(), 0.1);
        }else{
            assertEquals(95.0, goku.getVida(), 0.1);
            assertEquals(90.0, vegeta.getVida(), 0.1);
        }
    }
}
