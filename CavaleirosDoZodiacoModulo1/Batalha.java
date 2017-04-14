public class Batalha{
        
        public void iniciarBatalha(Saint s1, Saint s2){

        if(s1.getValorArmadura() == s2.getValorArmadura()){
            s2.perderVida();
        }else
        if(s1.getValorArmadura() > s2.getValorArmadura()){
            s2.perderVida();
        }else{
            s1.perderVida();
        }
    }
}
