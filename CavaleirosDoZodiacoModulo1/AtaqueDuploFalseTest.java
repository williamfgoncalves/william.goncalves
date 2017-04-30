import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploFalseTest{
    @Test
    public void verificaSeRealizaAtaqueDuploComArmadura() throws Exception{

        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));
        goku.adicionarMovimento(new VestirArmadura(goku));
        goku.getProximoMovimento().executar();
        goku.adicionarMovimento(new AtaqueDuploFalso(goku, vegeta));
        goku.getProximoMovimento().executar();

        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(20.0, vegeta.getVida(), 0.1);
    }

    @Test
    public void verificaSeRealizaAtaqueDuploSemArmadura() throws Exception{

        Saint goku = new GoldSaint("Goku", "Câncer");
        goku.aprenderGolpes( new Golpe("Hadukem", 10));

        Saint vegeta= new SilverSaint("Vegeta", "Leão");
        vegeta.aprenderGolpes(new Golpe("kamehameha", 30));

        goku.adicionarMovimento(new AtaqueDuploFalso(goku, vegeta));
        goku.getProximoMovimento().executar();

        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(80.0, vegeta.getVida(), 0.1);
    }
}
