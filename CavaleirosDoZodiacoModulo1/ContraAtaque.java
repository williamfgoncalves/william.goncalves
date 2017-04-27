public class ContraAtaque implements Movimento{
    
    private Saint golpeador, golpeado;
    
    public ContraAtaque(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    private boolean podeContratacar = golpeado.getVida() < 50 && (golpeado.getArmaduraVestida() == false);
    
    public void executar()throws Exception{
        
        if(podeContratacar){
            
        }
    }
}
