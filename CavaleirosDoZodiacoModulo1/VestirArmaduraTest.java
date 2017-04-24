
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest{

    @Test
    public void vestirArmaduraSaint()throws Exception{
       //Arrange
       SilverSaint Shaina = new SilverSaint("Shaina", "Serpente");
       Movimento movimento =  new VestirArmadura(Shaina);
       //Act
       movimento.executar();
       //Assert
       assertTrue(Shaina.getArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmadura()throws Exception{
        //Arrange
       SilverSaint Shaina = new SilverSaint("Shaina", "Serpente");
       Movimento movimento =  new VestirArmadura(Shaina);
       //Act
       //Assert
       assertFalse(Shaina.getArmaduraVestida());
    }
    
    @Test(expected=NullPointerException.class)
    public void vestirArmaduraSaintNulo()throws Exception{
        //Arrange
       SilverSaint Shaina = null;
       Movimento movimento =  new VestirArmadura(Shaina);
       //Act
       movimento.executar();
    }
}












