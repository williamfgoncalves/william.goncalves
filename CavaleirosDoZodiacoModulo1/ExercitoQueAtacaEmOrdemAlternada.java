import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemAlternada implements ExercitoDeSaints{

    private ArrayList<Saint> impostores = new ArrayList<>();

    public void alistarExercito(Saint saint){
        this.impostores.add(saint);
    }

    public void ordenarExercito(){
        for(int i = 0; i < impostores.size(); i++){
            if(impostores.get(i).getValorArmadura() == 1){
                
            }else if(impostores.get(i).getValorArmadura() == 2){

            }else{
            
            }
        }
    }
    
    public ArrayList <Saint> getExercitoImpostor(){
        return impostores;
    }
}
