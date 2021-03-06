import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.ArrayList; 

public class ListaSaintsTest { 
    
    @Test
    public void verificarSeRetornaSaintPeloIndice()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya", "Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(ikki,listaSaint.getSaintLista(2));
    }
    
    @Test
    public void verificarSeRetornaSaintPorNome()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(ikki,listaSaint.buscarPorNome("ikki"));
    }
    
    @Test
    public void verificarSeRetornaSaintCategoriaInformada()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        GoldSaint Hakata = new GoldSaint("Hakata","Peixes");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(Hakata);
        listaSaint.adicionarSaint(ikki);
        
        ArrayList<Saint> categorias = new ArrayList<Saint>(); 
        categorias = listaSaint.buscarPorCategoria(Categoria.OURO);
        
        assertEquals(Seya, categorias.get(0));
        assertEquals(Hakata, categorias.get(1));
    }

    @Test 
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        Saint june = new BronzeSaint("June","Camaleão"); 
        Saint misty = new SilverSaint("Misty","Lagarto"); 
        Saint shun = new BronzeSaint("June","Andrômeda"); 
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
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(5);
        
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(Seya, listaSaint.getSaintMaiorVida());
    }
    
    @Test
    public void verificarSaintMenorVida()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(5);
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        assertEquals(Shiryu, listaSaint.getSaintMenorVida());
    }
     
   @Test
    public void verificarSeOrdenouLista()throws Exception{   
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(5);
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        BronzeSaint ikki = new BronzeSaint("ikki", "Andromeda");
        ikki.perderVida(21);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(ikki);
        
        listaSaint.ordenar();
        ArrayList<Saint> vidas = new ArrayList<Saint>();
        vidas = listaSaint.retornaTodos();
        
        assertEquals(Shiryu,vidas.get(0));
    }

    @Test
    public void verificarSeOrdenouListaAscendente()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya", "Sagitário");
        Seya.perderVida(5);
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
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
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(5);
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
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
    
    @Test
    public void unirInserindoUmSaintApenasPorArrayList()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(5);
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        Shiryu.perderVida(22);
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Shiryu);
       
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.unir(novaLista);
        
        assertEquals(Seya,atualLista.get(0));
        assertEquals(Shiryu,atualLista.get(1));
   }
   
   @Test
   public void unirInserindoTresSaintsPorArrayList()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");
        GoldSaint Goku = new GoldSaint("Goku","Sagitário");
        SilverSaint Gotanks = new SilverSaint("Gotaks","Áries");
        BronzeSaint Vegeta = new BronzeSaint("Vegeta","Andromeda");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(ikki);
        listaSaint.adicionarSaint(Gotanks);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Shiryu);
        novaLista.add(Goku);
        novaLista.add(Vegeta);
        
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.unir(novaLista);
        
        assertEquals(Seya,atualLista.get(0));
        assertEquals(ikki,atualLista.get(1));
        assertEquals(Gotanks,atualLista.get(2));
        assertEquals(Shiryu,atualLista.get(3));
        assertEquals(Goku,atualLista.get(4));
        assertEquals(Vegeta,atualLista.get(5));
   }
   
   @Test
   public void diffListaComUmDiferentes()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");       
        GoldSaint Goku = new GoldSaint("Goku","Sagitário");
        GoldSaint Vegeta = new GoldSaint("Vegeta","Sagitário");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(Goku);
        listaSaint.adicionarSaint(ikki);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Seya);
        novaLista.add(Shiryu);
        novaLista.add(Vegeta);
        novaLista.add(ikki);
        
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.diff(novaLista);
        
        assertEquals(Goku, atualLista.get(0));
   }
   
   @Test
   public void diffListaComUmDiferentesePosicaoDiferente()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");       
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");        
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");        
        GoldSaint Goku = new GoldSaint("Goku","Sagitário");
        GoldSaint Vegeta = new GoldSaint("Vegeta","Sagitário");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(ikki);
        listaSaint.adicionarSaint(Goku);
        listaSaint.adicionarSaint(Shiryu);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Seya);
        novaLista.add(Shiryu);
        novaLista.add(ikki);
        novaLista.add(Vegeta);
        
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.diff(novaLista);
        
        assertEquals(Goku, atualLista.get(0));
   }
   
   @Test
   public void intersecListaComUmDiferente()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");        
        GoldSaint Goku = new GoldSaint("Goku","Sagitário");
        GoldSaint Vegeta = new GoldSaint("Vegeta","Sagitário");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(Shiryu);
        listaSaint.adicionarSaint(Goku);
        listaSaint.adicionarSaint(ikki);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Seya);
        novaLista.add(Shiryu);
        novaLista.add(Vegeta);
        novaLista.add(ikki);
        
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.intersec(novaLista);
        
        assertEquals(Seya, atualLista.get(0));
        assertEquals(Shiryu, atualLista.get(1));
        assertEquals(ikki, atualLista.get(2));
    }
   
   @Test
   public void intersecListaComUmDiferenteEComSaintsEmPosicoesDiferentes()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        SilverSaint Shiryu = new SilverSaint("Shiryu","Áries");
        BronzeSaint ikki = new BronzeSaint("ikki","Andromeda");     
        GoldSaint Goku = new GoldSaint("Goku","Sagitário");
        GoldSaint Vegeta = new GoldSaint("Vegeta","Sagitário");
        
        ListaSaints listaSaint = new ListaSaints();
        listaSaint.adicionarSaint(Seya);
        listaSaint.adicionarSaint(ikki);
        listaSaint.adicionarSaint(Goku);
        listaSaint.adicionarSaint(Shiryu);
        
        ArrayList<Saint> novaLista = new ArrayList<>();
        novaLista.add(Seya);
        novaLista.add(Shiryu);
        novaLista.add(ikki);
        novaLista.add(Vegeta);
        novaLista.add(Shiryu);
        novaLista.add(ikki);
       
        ArrayList<Saint> atualLista = new ArrayList<>();
        atualLista = listaSaint.intersec(novaLista);
        
        assertEquals(Seya, atualLista.get(0));
        assertEquals(ikki, atualLista.get(1));
        assertEquals(Shiryu, atualLista.get(2));
   }
   
   @Test
   public void getCSVTestandoComDoisSaints()throws Exception{
       ListaSaints lista = new ListaSaints();
       
       Saint june = new BronzeSaint("June","Camaleão");
       june.setGenero(Genero.FEMININO);
       june.perderVida(15.5);
       lista.adicionarSaint(june);
       
       Saint dohko = new GoldSaint("Dohko","Áries");
       dohko.perderVida(90);
       dohko.vestirArmadura();
       lista.adicionarSaint(dohko);
       String separador = System.getProperty("line.separator");
       String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false" + separador + "Dohko,10.0,Áries,OURO,VIVO,NAO_INFORMADO,true";
       assertEquals(esperado, lista.getCSV());
   }
}