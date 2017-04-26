import java.util.Random;

public class DadoD10 implements Sorteador{

    final Random random = new Random();
    final int min = 1;
    final int max = 10;
    //classe sobreescrita de Sorteador
    public int sortear(){
        return random.nextInt(max - min + 1) + min;
    }
}
