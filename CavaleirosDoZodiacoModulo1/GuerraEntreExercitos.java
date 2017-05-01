import java.util.ArrayList;

public class GuerraEntreExercitos implements Movimento{

    private ArrayList<Saint> defensoresDeAthena  = new ArrayList<>();
    private ArrayList<Saint> impostores  = new ArrayList<>();
    int tamanhoAtena = defensoresDeAthena.size();
    int tamanhoimpostores = impostores.size();
    
    public GuerraEntreExercitos(ArrayList<Saint> defensoresDeAthena, ArrayList<Saint> impostores){
        this.defensoresDeAthena = defensoresDeAthena;
        this.impostores = impostores;
    }

    public void executar()throws Exception{
        if(tamanhoAtena >= tamanhoimpostores)
            for(int i = 0; i < impostores.size(); i++){
                Saint defensor = defensoresDeAthena.get(i);
                Saint impostor = impostores.get(i);
                defensor.adicionarMovimento(new Golpear(defensor,impostor));
                impostor.adicionarMovimento(new Golpear(impostor,defensor));
                Batalha guerra = new Batalha(defensor,impostor);
                guerra.iniciar();
            }   
            
        else{
            for(int i = 0; i < defensoresDeAthena.size(); i++){
                Saint defensor = defensoresDeAthena.get(i);
                Saint impostor = impostores.get(i);
                defensor.adicionarMovimento(new Golpear(defensor,impostor));
                impostor.adicionarMovimento(new Golpear(impostor,defensor));
                Batalha guerra = new Batalha(defensor,impostor);
                guerra.iniciar();
            }

        }
    }
}
