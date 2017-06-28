
package br.com.crescer.aula1;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class TestStringUtils implements StringUtils{

    @Override
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
    
    @Override
    public String inverter(String string) {
        if(string.isEmpty()){
            return string;
        }
        string = new StringBuffer(string).reverse().toString();
        return string;
    }

    @Override
    public int contaVogais(String string) {
        //String regex = "[b-df-hj-np-tv-z]";
       int v = string.length() - string.replaceAll("[aeiouAEIOU]", "").length();
       return v;
    }

    @Override
    public boolean isPalindromo(String string) {
         
        String invertida;
        string = string.replaceAll(" ", "");
        invertida = inverter(string);
         
        string = normalize(string);
        invertida = normalize(invertida);
         
        if(string.compareToIgnoreCase(invertida) == 0){
            return true;
        }else{
            return false;
        }
    }
    
    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
