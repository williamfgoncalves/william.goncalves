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
}