import java.security.InvalidParameterException;

public class Saint{
    
    private String nome;
    private boolean armaduraVestida;
    private double vida = 100.0;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    protected int qtdSentidosDespertados;
    private int contador = -1;
    
    public Saint(String nome, Armadura armadura)throws Exception{
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria().getValor();
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
    
    public Genero getGenero(){
        return this.genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public void perderVida(double dano)throws Exception{
        if(dano < 0){
            throw new InvalidParameterException("Voce nao pode adicionar dados negativos");
        }
        
        if(this.status != Status.MORTO){
            
            if(vida - dano <= 0){
                this.status = Status.MORTO;
                this.vida = 0;
            }
            else{
                this.vida -= dano;
            }
        }
    }
    
    public double getVida(){
        return this.vida;
    }
    
     public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    public Golpe[] getGolpes(){
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpes(Golpe golpe){
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public Golpe getProximoGolpe () {      
        contador++;
        if (contador == this.armadura.getConstelacao().getGolpes().length) {
            contador = 0;
        }
        return this.armadura.getConstelacao().getGolpes()[contador];
    }
}