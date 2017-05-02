import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemAlternada implements ExercitoDeSaints{

    private ArrayList<Saint> impostores = new ArrayList<>();

    public void alistarExercito(Saint saint){
        this.impostores.add(saint);
    }

    public void ordenarExercito(){

        ArrayList<Saint> bronze = new ArrayList<>();
        ArrayList<Saint> prata = new ArrayList<>();
        ArrayList<Saint> ouro = new ArrayList<>();
        int tamanhoImpostores = impostores.size();

        while(impostores.size() != 0){
            if(impostores.get(0).getValorArmadura() == 1){
                bronze.add(impostores.remove(0));
            }else if(impostores.get(0).getValorArmadura() == 2){
                prata.add(impostores.remove(0));
            }else{
                ouro.add(impostores.remove(0));
            }
        }

        boolean aindaTemNaLista = true;

        while(aindaTemNaLista){
            boolean aindaTemDeBronze = bronze.size() != 0;
            boolean aindaTemDePrata = prata.size() != 0;
            boolean aindaTemDeOuro  = ouro.size() != 0;

            if(aindaTemDeBronze){
                impostores.add(bronze.remove(0));
            }
            if(aindaTemDePrata){
                impostores.add(prata.remove(0));
            }
            if(aindaTemDeOuro){
                impostores.add(ouro.remove(0));
            }
            aindaTemNaLista = aindaTemDeBronze || aindaTemDePrata || aindaTemDeOuro; 
        }
    }
    
    public Saint getSaintsIndice(int indice){
        return impostores.get(indice); 
    }

    public ArrayList <Saint> getExercitoImpostor(){
        return impostores;
    }
}
