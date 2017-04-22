import java.lang.Exception;

public class Golpear implements Movimento{
    private Golpe golpe;
    Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.golpe = golpeador.getGolpes().get(0);
    }

    public void executar()throws Exception{
        if(!golpeador.getArmaduraVestida()){
            golpeado.perderVida(golpe.getfatorDano());
        }else if(golpeador.getArmaduraVestida()){
            if(golpeador.getArmadura().getCategoria().equals(Categoria.OURO)){
                    golpeado.perderVida(golpe.getfatorDano()
                    *(1+golpeador.getArmadura().getCategoria().getValor()));
            }
            else if(golpeador.getArmadura().getCategoria().equals(Categoria.PRATA)){
                golpeado.perderVida(golpe.getfatorDano()*(1+golpeador.getArmadura().getCategoria().getValor()));
            }
            else if(golpeador.getArmadura().getCategoria().equals(Categoria.BRONZE)){
                golpeado.perderVida(golpe.getfatorDano()*(1+golpeador.getArmadura().getCategoria().getValor()));
            }
        }
    }
}
