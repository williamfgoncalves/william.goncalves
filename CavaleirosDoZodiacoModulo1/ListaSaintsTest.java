import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.ArrayList; 

public class ListaSaintsTest { 
    
    @Test
    public void verificarSeRetornaSaintPeloIndice()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(ikki,listaSaint.getSaintLista(2));
    }
    
    @Test
    public void verificarSeRetornaSaintPorNome()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(ikki,listaSaint.buscarPorNome("ikki"));
    }
    
    /*@Test
    public void verificarSeRetornaSaintCategoriaInformada()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        
        Constelacao peixes = new Constelacao("Peixes");
        GoldSaint Hakata = new GoldSaint("Hakata", new Armadura(peixes, Categoria.OURO));
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(Hakata);
        listaSaint.adicionarSaint(ikki);
        
        ArrayList<Saint> categorias = new ArrayList<Saint>(); 
        categorias = listaSaint.buscarPorCategoria(Categoria.OURO);
        
        assertEquals(Seya, categorias.get(0));
 		assertEquals(Hakata, categorias.get(1));
    }*/

	@Test 
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        listaSaints.adicionarSaint(shun); 
        listaSaints.adicionarSaint(misty); 
        listaSaints.adicionarSaint(june); 
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE); 
        assertEquals(shun, resultadoBusca.get(0)); 
        assertEquals(june, resultadoBusca.get(1)); 
        assertEquals(2, resultadoBusca.size()); 
    } 
    
    @Test
    public void verificarSaintMaiorVida()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(5);
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        Shiryu.perderVida(22);
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(Seya, listaSaint.getSaintMaiorVida());
    }
    
    @Test
    public void verificarSaintMenorVida()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(5);
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        Shiryu.perderVida(22);
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(Shiryu, listaSaint.getSaintMenorVida());
    }
     
   @Test
    public void verificarSeOrdenouLista()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(5);
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        Shiryu.perderVida(22);
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        listaSaint.ordenarSaint();
        ArrayList<Saint> vidas = new ArrayList<Saint>();
        vidas = listaSaint.retornaTodos();
        
        assertEquals(Shiryu,vidas.get(0));
    }

	@Test
    public void verificarSeOrdenouListaAscendente()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(5);
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        Shiryu.perderVida(22);
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        listaSaint.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> vidas = new ArrayList<Saint>();
        vidas = listaSaint.retornaTodos();
        
        assertEquals(Shiryu, vidas.get(0));
    }

	@Test
    public void verificarSeOrdenouListaDescendente()throws Exception{
        
        Constelacao sagitario = new Constelacao("Sagitario");
        GoldSaint Seya = new GoldSaint("Seya", new Armadura(sagitario, Categoria.OURO));
        Seya.perderVida(5);
        
        Constelacao aries = new Constelacao("Aries");
        SilverSaint Shiryu = new SilverSaint("Shiryu", new Armadura(aries, Categoria.PRATA));
        Shiryu.perderVida(22);
        
        Constelacao andromeda = new Constelacao("Andromeda");
        BronzeSaint ikki = new BronzeSaint("ikki", new Armadura(andromeda, Categoria.BRONZE));
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        listaSaint.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> vidas = new ArrayList<Saint>();
        vidas = listaSaint.retornaTodos();
        
        assertEquals(Seya, vidas.get(0));
    }
}