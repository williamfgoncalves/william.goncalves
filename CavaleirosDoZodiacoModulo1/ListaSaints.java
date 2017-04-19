import java.util.ArrayList;
import java.util.stream.Collectors;

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
        this.listaSaints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome){
        /*for(Saint saint : this.listaSaints){
            if(saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;*/
        return this.listaSaints.stream()
            .filter(s -> s.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
            /*for(Saint saint : listaSaints){
                if(saint.getArmadura().getCategoria().equals(categoria)){
                     saintCategoriaInformada.add(saint);
                }
            }
        return saintCategoriaInformada;*/
        return (ArrayList<Saint>)this.listaSaints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(categoria))
            .collect(Collectors.toList());
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
    
     public Saint getSaintMaiorVida() {
        
        if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint maiorVida = this.listaSaints.get(0);
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMaior = saint.getVida() > maiorVida.getVida();
            if (encontreiMaior) {
                maiorVida = saint;
            }
        }
        
        return maiorVida;
    }


    
    public Saint getSaintMenorVida() {
        
        if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint menorVida = this.listaSaints.get(0);
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMenor = saint.getVida() < menorVida.getVida();
            if (encontreiMenor) {
                menorVida = saint;
            }
        }
        
        return menorVida;
    }
    
    public void ordenarSaint(){
        boolean controle = false;
        do{
            controle = false;
            for(int i =0; i < listaSaints.size()-1; i++){ 
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i+1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if(precisaTrocar){
                    Saint troca = atual;
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i+1, proximo);
                    controle = true;
                }
            }
        }while(controle); 
    }

    public void ordenar(TipoOrdenacao tipoOrdenacao){
       if(tipoOrdenacao.equals(TipoOrdenacao.ASCENDENTE)){
            boolean controle = false;
            do{
                controle = false;
                for(int i =0; i < listaSaints.size()-1; i++){ 
                    Saint atual = this.listaSaints.get(i);
                    Saint proximo = this.listaSaints.get(i+1);
                    boolean precisaTrocar = atual.getVida() > proximo.getVida();
                    if(precisaTrocar){
                        Saint troca = atual;
                        this.listaSaints.set(i, proximo);
                        this.listaSaints.set(i+1, proximo);
                        controle = true;
                    }
                }
            }while(controle); 
        }else if(tipoOrdenacao.equals(TipoOrdenacao.DESCENDENTE)){
            boolean controle = false;
            do{
                controle = false;
                for(int i =0; i < listaSaints.size()-1; i++){ 
                    Saint atual = this.listaSaints.get(i);
                    Saint proximo = this.listaSaints.get(i+1);
                    boolean precisaTrocar = atual.getVida() < proximo.getVida();
                    if(precisaTrocar){
                        this.listaSaints.set(i, proximo);
                        this.listaSaints.set(i+1, atual);
                        controle = true;
                    }
                }
            }while(controle);  
        }
    } 
    
    public int getSize(){
        return listaSaints.size();
    }
    
    public ArrayList<Saint> unir(){
        return null;
    }
    
    public ArrayList<Saint> diff(){
        return null;
    }
    
    public ArrayList<Saint> intersec(){
        return null;
    }
}
