
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest
{
    @Test
    public void testarAtaqueComSaintOuroComArmadura()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Golpe Shoryuken = new Golpe("Shoryuken", 20);
        Aries.adicionarGolpe(Hadukem);
        Aries.adicionarGolpe(Shoryuken);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new GoldSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.vestirArmadura();
        Aldeibaran.aprenderGolpes(Hadukem);
        Aldeibaran.aprenderGolpes(Shoryuken);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(60.0,Seya.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintOuroSemArmadura()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aries.adicionarGolpe(Hadukem);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new GoldSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(90.0,Seya.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintPrataComArmadura()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aries.adicionarGolpe(Hadukem);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new SilverSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.vestirArmadura();
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(70.0,Seya.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintPrataSemArmadura()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aries.adicionarGolpe(Hadukem);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new SilverSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(90.0,Seya.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintBronzeComArmaduraESaintIgual()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aries.adicionarGolpe(Hadukem);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new BronzeSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.vestirArmadura();
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(80.0,Seya.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintBronzeSemArmadura()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aries.adicionarGolpe(Hadukem);

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new BronzeSaint("Aldeibaran", Aries.getNome());
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();

        assertEquals(90.0,Seya.getVida(),0.1);
    }

    @Test(expected = ArithmeticException.class)
    public void testarAtaqueComNenhumSaint()throws Exception{
        Constelacao Andromeda = new Constelacao("Andromeda");
        Constelacao Aries = new Constelacao("Áries");

        Saint Seya = new BronzeSaint("Seya", Andromeda.getNome());
        Saint Aldeibaran = new BronzeSaint("Aldeibaran", Aries.getNome());

        Golpear golpear = new Golpear(Aldeibaran, Seya);
        golpear.executar();
    }
}
