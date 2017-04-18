import java.util.ArrayList;

public class ListaSaints{
    ArrayList<Saint> listaSaints = new ArrayList<>();

    public void adicionarSaint(Saint saint){
            this.listaSaints.add(saint);
    }
    
    public void getSaintLista(int indice){
        for(int i = 0; i < listaSaints.size(); i++){
            if(i == indice){
               listaSaints.get(i);
            }
            i++;
        }
    }
}
