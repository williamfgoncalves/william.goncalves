public class SorteDoDia{

    private Sorteador sorteador;

    public SorteDoDia(Sorteador sorteador){
        this.sorteador = sorteador;
    }

    public boolean estouComSorte(){
        int resultado = sorteador.sortear();
        return resultado % 2 == 0;
    }
}
