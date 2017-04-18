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
    
    public void perderVida(double dano)throws InvalidParameterException{
        if(this.status != Status.MORTO){
            if(dano > this.vida){
                throw new InvalidParameterException("Não é possivel danos que ultrapassem o valor da vida");
            }else{
                this.vida -= dano;
                if(this.vida == 0){
                    this.status = Status.MORTO;
                }
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