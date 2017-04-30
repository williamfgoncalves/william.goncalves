import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest{
    @Test
    public void verificaSeRealizaContraAtaqueSemArmadura() throws Exception{

        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 26));
        Saint vegeta= new SilverSaint("Vegeta", "Leão");

        //primeiro golpe
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();
        goku.getProximoMovimento().executar();

        new ContraAtaque(goku, vegeta, new DadoFalso(5)).executar();
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();  

        assertEquals(75.0, goku.getVida(), 0.1);
        assertEquals(48.0, vegeta.getVida(), 0.1);
    }

    @Test
    public void verificaSeNaoRealizaContraAtaqueSemArmadura() throws Exception{
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 26));
        Saint vegeta= new SilverSaint("Vegeta", "Leão");

        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();
        goku.getProximoMovimento().executar();

        new ContraAtaque(goku, vegeta, new DadoFalso(2)).executar();
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();  

        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(22.0, vegeta.getVida(), 0.1);
    }

    @Test
    public void verificaSeRealizaContraAtaqueComArmadura() throws Exception{
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 22));
        Saint vegeta= new SilverSaint("Vegeta", "Leão");

        goku.adicionarMovimento(new VestirArmadura(goku));
        goku.getProximoMovimento().executar();
        
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();

        new ContraAtaque(goku, vegeta, new DadoFalso(5)).executar();
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();  

        assertEquals(75.0, goku.getVida(), 0.1);
        assertEquals(12.0, vegeta.getVida(), 0.1);
    }
    
    @Test
    public void verificaSeMaoRealizaContraAtaqueComArmadura() throws Exception{
        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 22));
        Saint vegeta= new SilverSaint("Vegeta", "Leão");

        goku.adicionarMovimento(new VestirArmadura(goku));
        goku.getProximoMovimento().executar();
        
        vegeta.adicionarMovimento(new VestirArmadura(vegeta));
        vegeta.getProximoMovimento().executar();
        
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();

        new ContraAtaque(goku, vegeta, new DadoFalso(5)).executar();
        goku.adicionarMovimento(new Golpear(goku, vegeta));
        goku.getProximoMovimento().executar();  

        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(0.0, vegeta.getVida(), 0.1);
    }
}
