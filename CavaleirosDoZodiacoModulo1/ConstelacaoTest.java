import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void VerificaSeadicionaGolpesaConstelacao(){
        Golpe hadukem = new Golpe("Hadukem!", 20);
        Constelacao aries = new Constelacao("Aries");
        aries.adicionarGolpe(hadukem);
        assertEquals(hadukem, aries.getGolpes()[2]);
    }
}
