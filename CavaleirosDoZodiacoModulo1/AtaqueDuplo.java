public class AtaqueDuplo implements Movimento{

    private Saint golpeador,golpeado;
    private Sorteador sorteador;
    private SorteDoDia sorteDoDia;

    public AtaqueDuplo(Saint golpeador, Saint golpeado, SorteDoDia sorteDoDia){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteDoDia = sorteDoDia;
    }

    public void executar()throws Exception{

        double danoAtaqueDuploFalhou = (golpeador.getVida()*5)/100;

        int fatorDano = sorteDoDia.consigoDeferirAtaqueDuplo() ?
                golpeador.getProximoGolpe().getFatorDano()*2
            : golpeador.getProximoGolpe().getFatorDano();

        golpeado.perderVida(fatorDano);

        if(!sorteDoDia.consigoDeferirAtaqueDuplo()){
            golpeador.perderVida(danoAtaqueDuploFalhou);
        }
    }
}
