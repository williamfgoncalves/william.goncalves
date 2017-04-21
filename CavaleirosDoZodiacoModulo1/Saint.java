import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Saint{
    
    private String nome;
    private boolean armaduraVestida;
    private double vida = 100.0;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    protected int qtdSentidosDespertados;
    private int contador = 0;
    
    public Saint(String nome, Armadura armadura)throws Exception{
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria().getValor();
    }
    
    public Armadura getArmadura(){
        return this.armadura;
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
    
     public Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }

    public ArrayList<Golpe> getGolpes(){
        return getConstelacao().getGolpes();
    }
    
    public void aprenderGolpes(Golpe golpe){
        getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe () {      
        ArrayList<Golpe> golpes = getGolpes(); 
        int posicao = this.contador % golpes.size(); 
        this.contador++; 
        return golpes.get(posicao); 
    }
    
    public String getCSV(){
        return
            this.nome + "," +
            this.getVida() + "," +
            this.getConstelacao().getNome() + "," +
            this.getArmadura().getCategoria() + "," +
            this.status + "," +
            this.genero + "," +
            this.getArmaduraVestida();
    }
}