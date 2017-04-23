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
        Golpear batalha;
        
        if(saint1.getValorArmadura() == saint2.getValorArmadura() ||
        saint1.getValorArmadura() > saint2.getValorArmadura()){
            primeiroAtaca = true;
            batalha = new Golpear(saint1, saint2);
            batalha.executar();
        }else{
            segundoAtaca = true;
            batalha = new Golpear(saint2, saint1);
            batalha.executar();
        }

        do{
            if(segundoAtaca){
                batalha =  new Golpear(saint1, saint2);
                batalha.executar();
                primeiroAtaca = true;
                segundoAtaca = false;
            }else if(primeiroAtaca){
                batalha =  new Golpear(saint2, saint1);
                batalha.executar();
                segundoAtaca = true;
                primeiroAtaca = false;
            }
        }while(saint1.getVida()> 0 && saint2.getVida()> 0);
    }
}