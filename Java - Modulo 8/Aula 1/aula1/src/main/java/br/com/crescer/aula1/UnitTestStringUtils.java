package br.com.crescer.aula1;

public class UnitTestStringUtils {
    
    public static void main(String[] args) {
      TestStringUtils stringUtil = new TestStringUtils();
      System.out.println("Teste 1.1: " + TesteUm(stringUtil));
      System.out.println("Teste 1.2: " + TesteDois(stringUtil));
      System.out.println("Teste 1.3: " + TesteTres(stringUtil));
      System.out.println("Teste 1.4: " + TesteQuatro(stringUtil));
    }
  
    public static boolean TesteUm(TestStringUtils str){
        String a = "";
        String c = "Diow";
        return str.isEmpty(a);
    }
    
    public static boolean TesteDois(TestStringUtils str){
        String a = "Arroz";
        String c = "Zorra";
        a = str.inverter(a);
        int teste = c.compareToIgnoreCase(a);
        if(teste == 0){
            return true;
        }
        else{
            return false;
        } 
    }
    
    public static boolean TesteTres(TestStringUtils str){
        String c = "William";
        int numVogais = str.contaVogais(c);
        if(numVogais == 3)
            return true;
        else return false;
    }
    
    public static boolean TesteQuatro(TestStringUtils str){
        String c = "Ame a ema";
        boolean ePalindromo = str.isPalindromo(c);
        if(ePalindromo)
            return true;
        else return false;
    }
}
