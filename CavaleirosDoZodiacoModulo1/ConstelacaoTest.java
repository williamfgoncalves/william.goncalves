import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void verificarSeSaintAdicionaUmGolpe(){
        Constelacao aries = new Constelacao("Áries");
        Golpe hadukem = new Golpe("Hadukem!", 20);
        aries.adicionarGolpe(hadukem);
        assertEquals(hadukem, aries.getGolpes().get(0));
    }
    
    @Test
    public void verificarSeSaintAdicionaDoisGolpes(){
        Constelacao aries = new Constelacao("Áries");
        Golpe hadukem = new Golpe("Hadukem!", 20);
        Golpe shoriukem = new Golpe("shoriukem!", 20);
        aries.adicionarGolpe(hadukem);
        aries.adicionarGolpe(shoriukem);
        assertEquals(hadukem, aries.getGolpes().get(0));
        assertEquals(shoriukem, aries.getGolpes().get(1));
    }
    
    @Test
    public void verificarSeSaintAdicionaTresDoisGolpes(){
        Constelacao aries = new Constelacao("Áries");
        Golpe hadukem = new Golpe("Hadukem!", 20);
        Golpe shoriukem = new Golpe("shoriukem!", 20);
        Golpe Genkidama = new Golpe("Genkidama!", 20);
        aries.adicionarGolpe(hadukem);
        aries.adicionarGolpe(shoriukem);
        aries.adicionarGolpe(Genkidama);
        assertEquals(hadukem, aries.getGolpes().get(0));
        assertEquals(shoriukem, aries.getGolpes().get(1));
        assertEquals(Genkidama, aries.getGolpes().get(2));
    }
    
    @Test
    public void verificarSeSaintAdicionaQuatroGolpes(){
        Constelacao aries = new Constelacao("Áries");
        Golpe hadukem = new Golpe("Hadukem!", 20);
        Golpe shoriukem = new Golpe("shoriukem!", 20);
        Golpe Genkidama = new Golpe("Genkidama!", 20);
        Golpe Kamehameha = new Golpe("Kamehameha!", 20);
        aries.adicionarGolpe(hadukem);
        aries.adicionarGolpe(shoriukem);
        aries.adicionarGolpe(Genkidama);
        aries.adicionarGolpe(Kamehameha);
        assertEquals(hadukem, aries.getGolpes().get(0));
        assertEquals(shoriukem, aries.getGolpes().get(1));
        assertEquals(Genkidama, aries.getGolpes().get(2));
        assertEquals(Kamehameha, aries.getGolpes().get(3));
    }
}
