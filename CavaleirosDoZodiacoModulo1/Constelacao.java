public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int contador = 2;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        if(contador >= 0){
            this.golpes[contador] = golpe;
            contador--;
        }
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
}