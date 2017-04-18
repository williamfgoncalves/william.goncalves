import java.util.ArrayList;

public class Constelacao{
    private String nome;
    private ArrayList <Golpe> golpes = new ArrayList<>();
    private int contador = 0;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
		this.golpes.add(golpe);
    }
     
	public ArrayList<Golpe> retornaLista(){
        return this.golpes;
	}
}