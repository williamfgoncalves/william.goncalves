import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    
    @Test
    public void vestirArmaduouraDeixaArmaduraVestida()throws Exception{
        Constelacao cancer = new Constelacao("Cancer");
        Armadura escorpiao = new Armadura(cancer, Categoria.OURO);
        Saint milo = new Saint("milo", escorpiao);
        milo.vestirArmadura();
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        Constelacao aquario = new Constelacao("Aquario");
        Saint yuoga = new Saint ("Hyoga", new  Armadura(aquario, Categoria.BRONZE));
        assertEquals(false, yuoga.getArmaduraVestida());
    }
    
    @Test
    public void verificaGenero()throws Exception{
        Constelacao leao = new Constelacao("Leao");
        Saint groot = new Saint("Groot", new Armadura(leao, Categoria.BRONZE));
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaSaintPodeAlterarGenero() throws Exception{
        Constelacao aries = new Constelacao("Aries");
        Saint groot = new Saint("Groot", new Armadura(aries, Categoria.BRONZE));
        
        groot.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, groot.getGenero());  
        
        groot.setGenero(Genero.NAO_INFORMADO);
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaStatusVida()throws Exception{
       Constelacao capricornio = new Constelacao("Capricornio");
       Saint groot = new Saint("Groot", new Armadura(capricornio, Categoria.BRONZE));
       assertEquals(Status.VIVO, groot.getStatus()); 
    }
    
    @Test
    public void verificaPerdaVida()throws Exception{
        Constelacao virgem = new Constelacao("Virgem");
        Saint Seya = new Saint("Seya", new Armadura(virgem, Categoria.PRATA));
        Seya.perderVida(16.0);
        assertEquals(84.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder100() throws Exception{
        Constelacao touro = new Constelacao("Touro");
        Saint Seya = new Saint("Seya", new Armadura(touro, Categoria.PRATA));
        Seya.perderVida(100.0);
        assertEquals(0.0, Seya.getVida(), 0.1);
    }
    
    @Test(expected=Exception.class)
    public void verificarSaintPerder1000() throws Exception{
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint Seya = new Saint("Seya", new Armadura(andromeda, Categoria.PRATA));
        Seya.perderVida(1000.0);
        assertEquals(-900.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder5000Negativos() throws Exception{
        Constelacao libra = new Constelacao("Libra");
        Saint Seya = new Saint("Seya", new Armadura(libra, Categoria.PRATA));
        Seya.perderVida(-5000.0);
        assertEquals(5100.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificaSaintBronzeNasceComCincoSentidos()throws Exception{
        Constelacao lyra = new Constelacao("Lyra");
        BronzeSaint Seya = new BronzeSaint("Seya", new Armadura(lyra, Categoria.BRONZE));
        assertEquals(5, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintPrataNasceComSeisSentidos()throws Exception{
        Constelacao sculum = new Constelacao("Sculum");
        SilverSaint Seya = new SilverSaint("Seya", new Armadura(sculum, Categoria.PRATA));
        assertEquals(6, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintOuroNasceComSeteSentidos()throws Exception{
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        assertEquals(7, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintPerdeVidaMorre()throws Exception{
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificaSaintMortoPerdeVida()throws Exception{
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(100);
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void saintAprenderGolpeAdicionaNaLista() throws Exception{
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Golpe hadukem = new Golpe("Hadukem", 20);
        Seya.aprenderGolpes(hadukem);
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes()[2]);
    }
    
     @Test
    public void saintProximoGolpeCorreto() throws Exception{
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe kamehameha = new Golpe("kamehameha", 80);
        Golpe meteoroPegaso = new Golpe("Meteoro Pegaso", 90);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(kamehameha);
        Seya.aprenderGolpes(meteoroPegaso);
        assertEquals(meteoroPegaso, Seya.getProximoGolpe());
        assertEquals(kamehameha, Seya.getProximoGolpe());
        assertEquals(hadukem, Seya.getProximoGolpe());
        assertEquals(meteoroPegaso, Seya.getProximoGolpe());
    }
    
}