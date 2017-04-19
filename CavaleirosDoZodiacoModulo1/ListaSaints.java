import java.util.ArrayList;

public class ListaSaints{
    
    ArrayList<Saint> listaSaints = new ArrayList<>();
    
    public ListaSaints(){
        this.listaSaints = listaSaints;
    }
    
    public void adicionarSaint(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint getSaintLista(int indice){
       return this.listaSaints.get(indice);
    }
    
    public ArrayList <Saint> retornaTodos(){
        return this.listaSaints;
    }
    
    public void remover(Saint saint){
        listaSaints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome){
        Saint saint = null;
            for(int i =0; i <= listaSaints.size(); i++){
                if(listaSaints.get(i).getNome().equals(nome)){
                     saint = new Saint(); 
                     saint = this.listaSaints.get(i);
                     return saint;
                }
            }
        return saint;
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> saintCategoriaInformada = new ArrayList<>();;
        for(int i =0; i <= listaSaints.size(); i++){
            if(listaSaints.get(i).getArmadura().getCategoria() == categoria){
                saintCategoriaInformada.add(listaSaints.get(i));
                return saintCategoriaInformada;
            }
        }
        return saintCategoriaInformada;
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> saintStatusInformado = new ArrayList<>();;
        for(int i =0; i <= listaSaints.size(); i++){
            if(listaSaints.get(i).getStatus() == status){
                saintStatusInformado.add(listaSaints.get(i));
            }
        }
        return saintStatusInformado;
    }
    
    public Saint getSaintMaiorVida(){
        Saint saint = null;
        double vidaAuxiliar = 0;
            
        for(int i =0; i <= listaSaints.size(); i++){
            if(listaSaints.get(i).getVida() > vidaAuxiliar){
                vidaAuxiliar = listaSaints.get(i).getVida();
                saint = listaSaints.get(i);
                return saint;
            }
        }
        return saint;
    }
    
    public Saint getSaintMenorVida(){
        Saint saint = null;
        double vidaAuxiliar = listaSaints.get(0).getVida();
            
        for(int i =0; i <= listaSaints.size(); i++){
            if(listaSaints.get(i).getVida() < vidaAuxiliar){
                vidaAuxiliar = listaSaints.get(i).getVida();
                saint = listaSaints.get(i);
                return saint;
            }
        }
        return saint;
    }
    
    public void ordenarSaint(){
        Saint saint = null;
        for(int i =0; i < listaSaints.size(); i++){ 
            for(int j = 0; j < listaSaints.size(); j++){
                if(listaSaints.get(j).getVida() > listaSaints.get(j+1).getVida()){
                   saint = this.listaSaints.get(i);
                   this.listaSaints.add(i, this.listaSaints.get(j));
                   this.listaSaints.add(j, saint);
                }
            }
        }
        
    }
    
    public int getSize(){
        return listaSaints.size();
    }

}
