import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void testarBatalhaCategoriaDiferente(){
        Saint goku = new Saint("Goku", new Armadura("Pegasus", Categoria.OURO));
        Saint vegeta= new Saint("Vegeta", new Armadura("Latão", Categoria.PRATA));
        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(goku, vegeta);
        assertEquals(goku.getVida(), 100.0, 0.1);
        assertEquals(90.0, vegeta.getVida(), 0.1);
    }
    
    @Test
    public void testarBatalhaCategoriaIgual(){
        Saint shiryu = new Saint("shiryu", new Armadura("Dragão", Categoria.OURO));
        Saint ikki = new Saint("ikki", new Armadura("Fenix", Categoria.OURO));
        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(shiryu, ikki);
        assertEquals(100.0, shiryu.getVida(), 0.1);
        assertEquals(90.0, ikki.getVida(), 0.1);
    }
}
