public class Batalha{

    private Saint saint1;
    private Saint saint2;

    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar()throws Exception{
        boolean primeiroAtaca = false;
        boolean segundoAtaca = false;

        if(saint1.getValorArmadura() == saint2.getValorArmadura() ||
        saint1.getValorArmadura() > saint2.getValorArmadura()){
            saint1.getProximoMovimento().executar();
            primeiroAtaca = true;
        }else{
            saint2.getProximoMovimento().executar();
            segundoAtaca = true;
        }

        do{
            if(segundoAtaca){
                saint1.getProximoMovimento().executar();
                primeiroAtaca = true;
                segundoAtaca = false;
            }else if(primeiroAtaca){
                saint2.getProximoMovimento().executar();
                segundoAtaca = true;
                primeiroAtaca = false;
            }
        }while((saint1.getStatus() != Status.MORTO) && (saint2.getStatus() != Status.MORTO));
    }
}