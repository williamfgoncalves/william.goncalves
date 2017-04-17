public class Batalha{
    
    private Saint s1;
    private Saint s2;
    private double dano = 10;
    
    public Batalha(Saint s1, Saint s2){
        this.s1 = s1;
        this.s2 = s2;
    }
    
    public void iniciar(){
    
       if(s1.getValorArmadura() == s2.getValorArmadura() || s1.getValorArmadura() > s2.getValorArmadura()){
            s2.perderVida(dano);
        }else{
            s1.perderVida(dano);
        }
    }
}
