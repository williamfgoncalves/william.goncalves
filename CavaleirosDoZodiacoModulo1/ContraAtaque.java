public class ContraAtaque implements Movimento{

    private Saint golpeador, golpeado;
    private Sorteador sorteador;

    public ContraAtaque(Saint golpeador, Saint golpeado, Sorteador sorteador){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }

    public void executar()throws Exception{
        boolean aptoContratacar = golpeado.getVida() < 50 && (golpeado.getArmaduraVestida() == false);
        boolean possoContratacar = sorteador.sortear() > 4;

        if(aptoContratacar){
            if(possoContratacar){
                golpeador.getProximoGolpe().zerarProximoAtaque();
                golpeador.perderVida((golpeador.getVida()*25)/100);
            }
            golpeador.golpear(golpeado);
            return;
        }
        golpeador.golpear(golpeado);
        return;
    }
}
