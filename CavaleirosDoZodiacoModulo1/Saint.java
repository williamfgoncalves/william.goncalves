public class Saint{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    //construtor da classe
    public Saint(String nome, Armadura armadura){
        this.nome = nome; //agora nome recebe a string n
        this.armadura = armadura;
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
}