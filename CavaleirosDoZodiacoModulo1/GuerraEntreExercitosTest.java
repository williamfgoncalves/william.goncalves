import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GuerraEntreExercitosTest{
   @Test
   public void verificaSeTaRolandoGuerra()throws Exception{
       
       Saint saint1 = new GoldSaint("Ikki", "Leão");
       saint1.adicionarMovimento(new VestirArmadura(saint1));
       saint1.aprenderGolpes(new Golpe("Soco", 30));
       Saint saint3 = new SilverSaint("Taurus", "Marte");
       saint3.adicionarMovimento(new VestirArmadura(saint3));
       saint3.aprenderGolpes(new Golpe("Chute", 20)); 
       Saint saint5 = new BronzeSaint("Groot", "Venus");
       saint5.adicionarMovimento(new VestirArmadura(saint5));
       saint5.aprenderGolpes(new Golpe("Voadora", 10)); 
       
       Saint saint2 = new GoldSaint("Aldebaran", "Leão");
       saint2.adicionarMovimento(new VestirArmadura(saint2));
       saint2.aprenderGolpes(new Golpe("Soco", 10)); 
       Saint saint4 = new SilverSaint("Lions", "Andromeda");
       saint4.adicionarMovimento(new VestirArmadura(saint4));
       saint4.aprenderGolpes(new Golpe("Soco", 20)); 
       Saint saint6 = new BronzeSaint("Vader", "Netuno");
       saint6.adicionarMovimento(new VestirArmadura(saint6));
       saint6.aprenderGolpes(new Golpe("Soco", 30));
       
       ExercitoQueAtacaEmOrdemAlternada impostores = new ExercitoQueAtacaEmOrdemAlternada();
       impostores.alistarExercito(saint1);
       impostores.alistarExercito(saint3);
       impostores.alistarExercito(saint5);
       
       ExercitoQueAtacaEmOrdemHierarquica defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
       defensoresDeAthena.alistarExercito(saint2);
       defensoresDeAthena.alistarExercito(saint4);
       defensoresDeAthena.alistarExercito(saint6);
       defensoresDeAthena.ordenarExercito();
       
       GuerraEntreExercitos tendeu = new GuerraEntreExercitos(defensoresDeAthena.getExercitoAthena(),
       impostores.getExercitoImpostor());
       tendeu.executar();
    }
}
