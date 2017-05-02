import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest
{
    @Test
    public void alistarSaintDoidos()throws Exception{
        
        BronzeSaint bronze1 = new BronzeSaint("Bronze 1","Bronze 1");
        BronzeSaint bronze2 = new BronzeSaint("Bronze 2","Bronze 2");
        BronzeSaint bronze3 = new BronzeSaint("Bronze 3","Bronze 3");
        SilverSaint silver1 = new SilverSaint("Prata 1","Prata 1");
        SilverSaint silver2 = new SilverSaint("Prata 2","Prata 2");
        GoldSaint gold1 = new GoldSaint("Gold 1","Leão");
        GoldSaint gold2 = new GoldSaint("Gold 2","Leão");
        
        ExercitoQueAtacaEmOrdemAlternada impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistarExercito(bronze1);
        impostores.alistarExercito(gold1);
        impostores.alistarExercito(silver1);
        impostores.alistarExercito(silver2);
        impostores.alistarExercito(bronze2);
        impostores.alistarExercito(bronze3);
        impostores.alistarExercito(gold2);
        impostores.ordenarExercito();
        
        assertEquals(bronze1,impostores.getSaintsIndice(0));
        assertEquals(silver1,impostores.getSaintsIndice(1));
        assertEquals(gold1,impostores.getSaintsIndice(2));
        assertEquals(bronze2,impostores.getSaintsIndice(3));
        assertEquals(silver2,impostores.getSaintsIndice(4));
        assertEquals(gold2,impostores.getSaintsIndice(5));
        assertEquals(bronze3,impostores.getSaintsIndice(6));
    }
}
