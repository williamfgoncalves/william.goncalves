import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemHierarquicaTest{

    @Test
    public void alistarSaintDoidos()throws Exception{

        BronzeSaint bronze1 = new BronzeSaint("Bronze 1","Bronze 1");
        BronzeSaint bronze2 = new BronzeSaint("Bronze 2","Bronze 2");
        BronzeSaint bronze3 = new BronzeSaint("Bronze 3","Bronze 3");
        SilverSaint silver1 = new SilverSaint("Prata 1","Prata 1");
        SilverSaint silver2 = new SilverSaint("Prata 2","Prata 2");
        GoldSaint gold1 = new GoldSaint("Gold 1","Leão");
        GoldSaint gold2 = new GoldSaint("Gold 2","Leão");

        ExercitoQueAtacaEmOrdemHierarquica defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistarExercito(bronze1);
        defensoresDeAthena.alistarExercito(gold1);
        defensoresDeAthena.alistarExercito(silver1);
        defensoresDeAthena.alistarExercito(silver2);
        defensoresDeAthena.alistarExercito(bronze2);
        defensoresDeAthena.alistarExercito(bronze3);
        defensoresDeAthena.alistarExercito(gold2);
        defensoresDeAthena.ordenarExercito();
        
        assertEquals(bronze1,defensoresDeAthena.getSaintsIndice(0));
        assertEquals(bronze2,defensoresDeAthena.getSaintsIndice(1));
        assertEquals(bronze3,defensoresDeAthena.getSaintsIndice(2));
        assertEquals(silver1,defensoresDeAthena.getSaintsIndice(3));
        assertEquals(silver2,defensoresDeAthena.getSaintsIndice(4));
        assertEquals(gold1,defensoresDeAthena.getSaintsIndice(5));
        assertEquals(gold2,defensoresDeAthena.getSaintsIndice(6));
    }
}

