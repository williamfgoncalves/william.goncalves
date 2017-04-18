public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int contador = 0;
    
    public void AdicionarGolpe(Golpe golpe){
        if(contador < 3){
            this.golpes[contador] = golpe;
        }
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
}