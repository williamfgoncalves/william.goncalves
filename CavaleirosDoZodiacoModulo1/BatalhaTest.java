import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void testarBatalhaSaintUmMaiorQueSaintDois(){
        Saint goku = new Saint("Goku", new Armadura("Pegasus", Categoria.OURO));
        Saint vegeta= new Saint("Vegeta", new Armadura("Latão", Categoria.PRATA));
        Batalha batalha = new Batalha(goku, vegeta);
        batalha.iniciar();
        assertEquals(100.0, goku.getVida(), 0.1);
        assertEquals(90.0, vegeta.getVida(), 0.1);
    }
    
    @Test
    public void testarBatalhaSaintUmIgualSaintDois(){
        Saint shiryu = new Saint("shiryu", new Armadura("Dragão", Categoria.OURO));
        Saint ikki = new Saint("ikki", new Armadura("Fenix", Categoria.OURO));
        Batalha batalha = new Batalha(shiryu, ikki);
        batalha.iniciar();
        assertEquals(100.0, shiryu.getVida(), 0.1);
        assertEquals(90.0, ikki.getVida(), 0.1);
    }
    
    @Test
    public void testarBatalhaSaintDoisMaiorQueSaintUm(){
        Saint shiryu = new Saint("shiryu", new Armadura("Ornitorrinco", Categoria.PRATA));
        Saint ikki = new Saint("ikki", new Armadura("Fenix", Categoria.OURO));
        Batalha batalha = new Batalha(shiryu, ikki);
        batalha.iniciar();
        assertEquals(90.0, shiryu.getVida(), 0.1);
        assertEquals(100.0, ikki.getVida(), 0.1);
    }
}
