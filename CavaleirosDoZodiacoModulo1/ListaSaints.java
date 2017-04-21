import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints{
    
    ArrayList<Saint> listaSaints = new ArrayList<>();
    
    public ListaSaints(){
        this.listaSaints = listaSaints;
    }
    
    public ArrayList<Saint> getListaSaint(){
        return this.listaSaints;
    }
    
    public void adicionarSaint(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint getSaintLista(int indice){
       return this.listaSaints.get(indice);
    }
    
    public ArrayList <Saint> retornaTodos(){
        return listaSaints;
    }
    
    public void remover(Saint saint){
        this.listaSaints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome){
        for(Saint saint : this.listaSaints){
            if(saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;
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
    
    public void ordenar(){
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenar(TipoOrdenacao tipoOrdenacao){
    boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
    boolean controle = false;
        do{
            controle = false;
            for(int i =0; i < listaSaints.size()-1; i++){ 
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i+1);
                boolean precisaTrocar = 
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();
                    if(precisaTrocar){
                        this.listaSaints.set(i, proximo);
                        this.listaSaints.set(i+1, proximo);
                        controle = true;
                    }
            }
        }while(controle); 
    } 
    
    public int getSize(){
        return listaSaints.size();
    }
    
    public ArrayList<Saint> unir(ArrayList<Saint> listaRecebida){
         
        ArrayList<Saint> novaListaSaints = new ArrayList<>();
        novaListaSaints = this.retornaTodos();
        novaListaSaints.addAll(listaRecebida);
         
        if(novaListaSaints.isEmpty()){
           return null;
        }
        return novaListaSaints;
    }
    
    public ArrayList<Saint> diff(ArrayList<Saint> listaRecebida){
        ArrayList<Saint> novaListaSaintsComDiferentes = new ArrayList<>();
        boolean controle;
        
        if(listaRecebida.isEmpty()){
            return null;
        }
        
        for(int i = 0; i < listaSaints.size(); i++){
            controle = false;
            for(int j = 0; j < listaRecebida.size(); j++){
                if(listaSaints.get(i).equals(listaRecebida.get(j))){
                    controle = true;
                }
            }
            if(!controle){
                novaListaSaintsComDiferentes.add(listaSaints.get(i));
            }    
        }
        return novaListaSaintsComDiferentes;
    }
    
    public ArrayList<Saint> intersec(ArrayList<Saint> listaRecebida){
        ArrayList<Saint> novaListaSaintsComDiferentes = new ArrayList<>();
        boolean controle;
        
        if(listaRecebida.isEmpty()){
            return null;
        }
        
        for(int i = 0; i < listaSaints.size(); i++){
            controle = false;
            for(int j = 0; j < listaRecebida.size(); j++){
                if(listaSaints.get(i).equals(listaRecebida.get(j))){
                    controle = true;
                }
            }
            if(controle){
                novaListaSaintsComDiferentes.add(listaSaints.get(i));
            }    
        }
        return novaListaSaintsComDiferentes;
    }
    
    public String getCSV(){
        
        if(listaSaints.isEmpty()){
            return null;
        }
        
        String separador = System.getProperty("line.separator");
        StringBuilder stringSaints = new StringBuilder(512);

        stringSaints.append(this.listaSaints.get(0).getCSV());
        
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            stringSaints.append(separador);
            stringSaints.append(saint.getCSV());
        }
        return stringSaints.toString();
    }
}
