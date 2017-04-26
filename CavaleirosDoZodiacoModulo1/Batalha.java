public class Batalha{

    private Saint saint1;
    private Saint saint2;

    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar()throws Exception{
        int valorSaint1 = saint1.getArmadura().getCategoria().getValor();
        int valorSaint2 = saint2.getArmadura().getCategoria().getValor();
        int fatorDano = 10;
        Saint saintAtacante = null;

        if(valorSaint1 >= valorSaint2){
            saint2.perderVida(fatorDano);
            saintAtacante = saint1;
        }else{
            saint1.perderVida(fatorDano);
            saintAtacante = saint2;
        }

        boolean ninguemMorreu = true;
        while(ninguemMorreu){
            saintAtacante = (saintAtacante == saint1) ? saint2 : saint1;
            saintAtacante.getProximoMovimento().executar();
            ninguemMorreu = (saint1.getStatus() != Status.MORTO) && (saint2.getStatus() != Status.MORTO);
        }
    }
}