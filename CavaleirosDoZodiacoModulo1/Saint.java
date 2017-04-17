public class Saint{
    private String nome;
    private boolean armaduraVestida;
    private double vida = 100.0;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    protected int qtdSentidosDespertados;
    
    //construtor da classe
    public Saint(String nome, Armadura armadura){
        this.nome = nome; //agora nome recebe a string n
        this.armadura = armadura;
    }
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
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
    
    public double perderVida(double dano){
       return this.vida -= dano;
    }
    
    public double getVida(){
        return this.vida;
    }
}