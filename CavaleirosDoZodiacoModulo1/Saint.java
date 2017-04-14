public class Saint{
    private String nome;
    private boolean armaduraVestida;
    private double vida = 100.0;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private StatusDeVida statusDeVida = StatusDeVida.VIVO;
    
    //construtor da classe
    public Saint(String nome, Armadura armadura){
        this.nome = nome; //agora nome recebe a string n
        this.armadura = armadura;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria();
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
    
    public StatusDeVida getStatusDeVida(){
        return this.statusDeVida;
    }
    
    public void perderVida(){
       this.vida -= 10.0;       
    }
    
    public double getVida(){
        return this.vida;
    }
}