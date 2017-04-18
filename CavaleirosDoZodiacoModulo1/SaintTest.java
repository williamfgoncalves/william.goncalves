import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduouraDeixaArmaduraVestida()throws Exception{
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("milo", escorpiao);
        milo.vestirArmadura();
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        Saint yuoga = new Saint ("Hyoga", new  Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, yuoga.getArmaduraVestida());
    }
    
    @Test
    public void verificaGenero()throws Exception{
        Saint groot = new Saint("Groot", new Armadura(" Andromeda", Categoria.BRONZE));
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaSaintPodeAlterarGenero() throws Exception{
        Saint groot = new Saint("Groot", new Armadura(" Andromeda", Categoria.BRONZE));
        
        groot.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, groot.getGenero());  
        
        groot.setGenero(Genero.NAO_INFORMADO);
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaStatusVida()throws Exception{
       Saint groot = new Saint("Groot", new Armadura(" Andromeda", Categoria.BRONZE));
       assertEquals(Status.VIVO, groot.getStatus()); 
    }
    
     @Test
    public void verificaPerdaVida()throws Exception{
        Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
        Seya.perderVida(16.0);
        assertEquals(84.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder100() throws Exception{
        Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
        Seya.perderVida(100.0);
        assertEquals(0.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder1000() throws Exception{
        Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
        Seya.perderVida(1000.0);
        assertEquals(-900.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificarSaintPerder5000Negativos() throws Exception{
        Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
        Seya.perderVida(-5000.0);
        assertEquals(5100.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void verificaSaintBronzeNasceComCincoSentidos()throws Exception{
         BronzeSaint Seya = new BronzeSaint("Seya", new Armadura("Fenix", Categoria.BRONZE));
         assertEquals(5, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintPrataNasceComSeisSentidos()throws Exception{
         SilverSaint Seya = new SilverSaint("Seya", new Armadura("Fenix", Categoria.PRATA));
         assertEquals(6, Seya.getQtdSentidosDespertados());
    }
    
    @Test
    public void verificaSaintOuroNasceComSeteSentidos()throws Exception{
         GoldSaint Seya = new GoldSaint("Seya", new Armadura("Áries", Categoria.OURO));
         assertEquals(7, Seya.getQtdSentidosDespertados());
    }
}