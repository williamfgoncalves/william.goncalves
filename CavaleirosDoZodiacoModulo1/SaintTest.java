import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    
    @Test
    public void vestirArmaduouraDeixaArmaduraVestida()throws Exception{
        Saint milo = new GoldSaint("milo","Câncer");
        milo.vestirArmadura();
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        Saint yuoga = new BronzeSaint ("Hyoga", "Andromeda");
        assertEquals(false, yuoga.getArmaduraVestida());
    }
    
    @Test
    public void verificaGenero()throws Exception{
        Saint groot = new BronzeSaint("Groot","Leão");
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaSaintPodeAlterarGenero() throws Exception{
        Saint groot = new BronzeSaint("Groot","Aries");
        
        groot.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, groot.getGenero());  
        
        groot.setGenero(Genero.NAO_INFORMADO);
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaStatusVida()throws Exception{
       Saint groot = new BronzeSaint("Groot","Capricornio");
       assertEquals(Status.VIVO, groot.getStatus()); 
    }
    
    @Test
    public void verificaPerdaVida()throws Exception{
        Saint Seya = new SilverSaint("Seya","Virgem");
        Seya.perderVida(16.0);
        assertEquals(84.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder100() throws Exception{
        Saint Seya = new SilverSaint("Seya","Touro");
        Seya.perderVida(100.0);
        assertEquals(0.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder1000() throws Exception{
        Saint Seya = new SilverSaint("Seya","Andromeda");
        Seya.perderVida(1000.0);
        assertEquals(0, Seya.getVida(), 0.1);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void verificarSaintPerder5000Negativos() throws Exception{
        Saint Seya = new SilverSaint("Seya","Libra");
        Seya.perderVida(-5000.0);
        assertEquals(5100.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificaSaintBronzeNasceComCincoSentidos()throws Exception{
        BronzeSaint Seya = new BronzeSaint("Seya", "Lyra");
        assertEquals(5, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintPrataNasceComSeisSentidos()throws Exception{
        SilverSaint Seya = new SilverSaint("Seya","Sculum");
        assertEquals(6, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintOuroNasceComSeteSentidos()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        assertEquals(7, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintPerdeVidaMorre()throws Exception{
        Constelacao sagitario = new Constelacao("Sagitário");
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificaSaintMortoPerdeVida()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(100);
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void saintAprenderGolpeAdicionaNaLista() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Seya.aprenderGolpes(hadukem);
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes().get(0));
    }
    
     @Test
    public void saintProximoGolpeCorreto() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe kamehameha = new Golpe("kamehameha", 80);
        Golpe meteoroPegaso = new Golpe("Meteoro Pegaso", 90);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(kamehameha);
        Seya.aprenderGolpes(meteoroPegaso);
        assertEquals(hadukem, Seya.getProximoGolpe());
        assertEquals(kamehameha, Seya.getProximoGolpe());
        assertEquals(meteoroPegaso, Seya.getProximoGolpe());
        assertEquals(hadukem, Seya.getProximoGolpe());
    }
    
}