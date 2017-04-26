public class ConstelacaoInvalidaException extends Exception{
    public ConstelacaoInvalidaException(){
        super("ISSO AQUI VAI DAR ERRO");
    }
    
    public ConstelacaoInvalidaException(String message){
        super(message);
    } 
}
