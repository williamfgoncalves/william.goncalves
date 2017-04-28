public class AtaqueDuplo implements Movimento{

    private Saint golpeador,golpeado;
    

    public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar()throws Exception{

        boolean consigoDeferirAtaqueDuplo = new DadoD10().sortear() < 4;
        int fatorDano = 0;
        double danoAtaqueDuploFalhou = (golpeador.getVida()*5)/100;
        
        if(golpeador.getArmaduraVestida()){            
            fatorDano = consigoDeferirAtaqueDuplo ?
                (golpeador.getProximoGolpe().getFatorDano()*(1+golpeador.getValorArmadura()))*2
                : golpeador.getProximoGolpe().getFatorDano()*(1+golpeador.getValorArmadura());
            }
        else{
            fatorDano = consigoDeferirAtaqueDuplo ?
                golpeador.getProximoGolpe().getFatorDano()*2
                : golpeador.getProximoGolpe().getFatorDano();
        }
        
        golpeado.perderVida(fatorDano);

        if(!consigoDeferirAtaqueDuplo){
            golpeador.perderVida(danoAtaqueDuploFalhou);
        }
    }
}
