public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int contador = 0;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        for(int i = 0; i < this.golpes.length; i++){
            Golpe golpeAtual = golpes[i];
            if(golpeAtual == null){
                golpes[i] = golpe;
                break;
            }  
        }
        /*if(contador >= 0 && contador <3){
            this.golpes[contador] = golpe;
            contador++;
        }*/
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
}