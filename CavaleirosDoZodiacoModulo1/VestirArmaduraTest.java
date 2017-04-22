
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest{

    @Test
    public void vestirArmaduraSaint()throws Exception{
        SilverSaint Shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento =  new VestirArmadura(Shaina);
        movimento.executar();
        assertEquals(true,Shaina.getArmaduraVestida());
    }
}












