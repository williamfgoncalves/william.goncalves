public class ContraAtaque implements Movimento{

    private Saint golpeador, golpeado;
    private Golpear golpear;
    private boolean aptoContratacar = golpeado.getVida() < 50 && (golpeado.getArmaduraVestida() == false);
    private boolean possoContratacar = new DadoD10().sortear() > 4;

    public ContraAtaque(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar()throws Exception{

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
