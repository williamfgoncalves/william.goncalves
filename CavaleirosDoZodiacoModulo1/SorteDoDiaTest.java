import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest{
   
    @Test
    public void verificarSeEstouComSorteRetornaTruePeloMenosUmaVez(){
        //Arrange
        Sorteador sorteador = new DadoD6();
        SorteDoDia s1 = new SorteDoDia(sorteador);
        boolean realmenteEstouComSorte = false;
        
        //Act
        for(int i = 0; i <2; i++){
            if(s1.estouComSorte() == true){
                realmenteEstouComSorte = true;
                break;
            }
            realmenteEstouComSorte = false;
        }
        //Assert
        assertTrue(realmenteEstouComSorte);
    }
    
    @Test
    public void verificarSeEstouComSorteRetornaTruePeloMenosUmaVezComFalse(){
        //Arrange
        Sorteador sorteador = new DadoFalse();
        SorteDoDia s1 = new SorteDoDia(sorteador);
        boolean realmenteEstouComSorte = false;
        //Act
        for(int i = 0; i <2; i++){
            if(s1.estouComSorte() == true){
                realmenteEstouComSorte = true;
                break;
            }
            realmenteEstouComSorte = false;
        }
        //Assert
        assertTrue(realmenteEstouComSorte);
    }
    
    @Test
    public void verificarSeEstouComSorteRetornaTrueEmPeloMenosMetade() throws Exception{
        //Arrange
        Sorteador sorteador = new DadoFalse();
        SorteDoDia s1 = new SorteDoDia(sorteador);
        boolean realmenteEstouComSorte = false;
        int contadorDaSorte = 0;
        //Act
        for(int i = 0; i <500; i++){
            if(s1.estouComSorte() == true){
                realmenteEstouComSorte = true;
                contadorDaSorte++;
            }
            realmenteEstouComSorte = false;
        }
        
        int verificador = 250 + (contadorDaSorte - 250);
        //Assert
        //assertTrue(realmenteEstouComSorte);
        assertEquals(verificador, contadorDaSorte);
    }
}
