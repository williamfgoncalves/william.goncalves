import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemHierarquica implements ExercitoDeSaints{
    
    private ArrayList<Saint> defendoresDeAthena = new ArrayList<>();
    
    public void alistarExercito(Saint saint){
        this.defendoresDeAthena.add(saint);
    }
    
    public ArrayList<Saint> getExercitoAthena(){
        return defendoresDeAthena;
    }
    
    public void ordenarExercito(){
        boolean ascendente = false;
        boolean controle = false;
        do{
            controle = false;
            for(int i =0; i < this.defendoresDeAthena.size()-1; i++){ 
                Saint atual = this.defendoresDeAthena.get(i);
                Saint proximo = this.defendoresDeAthena.get(i+1);
                boolean precisaTrocar = 
                    ascendente ? atual.getValorArmadura() < proximo.getValorArmadura() :
                    atual.getValorArmadura() > proximo.getValorArmadura();
                if(precisaTrocar){
                    this.defendoresDeAthena.set(i, proximo);
                    this.defendoresDeAthena.set(i+1, atual);
                    controle = true;
                }
            }
        }while(controle); 
    }
}
