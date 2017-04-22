import java.lang.Exception;

public class Golpear implements Movimento{
    private Golpe golpe;
    Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.golpe = golpeador.getProximoGolpe();
    }

    public void executar()throws Exception{
        int fatorDano = golpeador.getArmaduraVestida() ?
                (golpeador.getProximoGolpe().getFatorDano())*(1+golpeador.getValorArmadura()) 
        : golpeador.getProximoGolpe().getFatorDano();

        golpeado.perderVida(fatorDano);
    }
}
