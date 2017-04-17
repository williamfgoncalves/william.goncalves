import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduouraDeixaArmaduraVestida(){
        //testes tem triple A = 
        //Arrange = Montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("milo", escorpiao);
        //Action = Invocar a ação a ser testada
        milo.vestirArmadura();
        //Assert = Verificacao dos resultados de testes
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint yuoga = new Saint ("Hyoga", new  Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, yuoga.getArmaduraVestida());
    }
    
    @Test
    public void verificaGenero(){
        Saint groot = new Saint("Groot", new Armadura(" Andromeda", Categoria.BRONZE));
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }
    
    @Test
    public void verificaStatusVida(){
       Saint groot = new Saint("Groot", new Armadura(" Andromeda", Categoria.BRONZE));
       assertEquals(Status.VIVO, groot.getStatus()); 
    }
    
    @Test
    public void verificaPerdaVida(){
        Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
        Seya.perderVida(16.0);
        assertEquals(84.0, Seya.getVida(), 0.1);
    }
    
    @Test
    public void criarUmSaintTemQueTerCincoSentidos(){
         Saint Seya = new Saint("Seya", new Armadura("Fenix", Categoria.PRATA));
         assertEquals(5, Seya.getQtdSentidosDespertados());
    }
}