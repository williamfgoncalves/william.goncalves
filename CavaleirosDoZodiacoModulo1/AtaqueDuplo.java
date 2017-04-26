public class AtaqueDuplo implements Movimento{
    
    private Saint golpeador,golpeado;
    private Sorteador sorteador;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador= sorteador;
    }
    
    public void executar()throws Exception{
        int resultado = sorteador.sortear();
    }
}
