import java.security.InvalidParameterException; // importação da biblioteca para gerenciar exceções

import java.util.ArrayList;// importação da biblioteca para gerenciar ArrayList

public abstract class Saint{

    private String nome;

    private double vida = 100.0;

    protected Armadura armadura;

    private boolean armaduraVestida;

    private String constelacao;

    private Genero genero = Genero.NAO_INFORMADO;

    private Status status = Status.VIVO;

    protected int qtdSentidosDespertados;

    private int contadorGolpes = 0;

    private int contadorMovimentos = 0;

    private ArrayList<Movimento> listaMovimentos = new ArrayList<>();

    private static int quantidadeDeSaints = 0; //atributo de classe pois usa static

    private static int acumuladorQtdSaints = 1;

    private int id;

    //Construtor da classe
    public Saint(String nome, String constelacao) throws Exception{
        this.nome = nome;
        this.constelacao = constelacao;
        this.id = ++Saint.acumuladorQtdSaints;
        Saint.quantidadeDeSaints++; // adicionado ao atrobuto cada vez que criamos saint;
    }

    protected void finalize() throws Throwable {
        Saint.quantidadeDeSaints--;
    }

    public static int getQuantidadeDeSaints(){
        return Saint.quantidadeDeSaints; // retorna o valor geral da classe saint
    }

    public static int getAcumuladorQtdSaints(){
        return Saint.acumuladorQtdSaints; // retorna o valor geral da classe saint
    }

    public String getNome(){
        return this.nome;
    }

    public int getValorArmadura(){

        return this.armadura.getCategoria().getValor();

    }

    public Armadura getArmadura(){
        return this.armadura;
    }

    public void vestirArmadura(){

        this.armaduraVestida = true;

    }

    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }

    public Genero getGenero(){

        return this.genero;

    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public Status getStatus(){

        return this.status;

    }

    public void perderVida(double dano)throws Exception{
        if(dano < 0){
            throw new InvalidParameterException("Voce nao pode adicionar dados negativos");
        }

        if(this.status != Status.MORTO){

            if(vida - dano <= 0){
                this.status = Status.MORTO;
                this.vida = 0;
            }
            else{
                this.vida -= dano;
            }
        }
    }

    public double getVida(){

        return this.vida;

    }

    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }

    public Constelacao getConstelacao(){

        return this.armadura.getConstelacao();

    }

    public ArrayList<Golpe> getGolpes(){
        return getConstelacao().getGolpes();
    }

    public void aprenderGolpes(Golpe golpe){

        getConstelacao().adicionarGolpe(golpe);

    }

    public Golpe getProximoGolpe () {      
        ArrayList<Golpe> golpes = getGolpes(); 
        int posicao = this.contadorGolpes % golpes.size(); 
        this.contadorGolpes++; 
        return golpes.get(posicao); 
    }

    public String getCSV(){

        return String.format("%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.getVida(),
            this.getConstelacao().getNome(),
            this.getArmadura().getCategoria(),
            this.status,
            this.genero,
            this.getArmaduraVestida());
    }

    public void adicionarMovimento(Movimento movimento){
        listaMovimentos.add(movimento);
    }

    public Movimento getProximoMovimento(){

        int posicao = this.contadorMovimentos % listaMovimentos.size();

        this.contadorMovimentos++;

        return listaMovimentos.get(posicao);

    }

    public int getId(){

        return this.id;

    }

}