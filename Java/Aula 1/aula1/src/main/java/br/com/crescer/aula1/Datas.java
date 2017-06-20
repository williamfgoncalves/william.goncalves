
package br.com.crescer.aula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class Datas {
    
    public static void main(String[] args) throws IOException {
        
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
   
        System.out.print("Digite uma data: ");
        String data = bufferedReader.readLine();
        
        System.out.print("Digite  o numero de dias: ");
        String dias = bufferedReader.readLine();
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }
  
  /* public static void adicionarDias(Date data, int dias){
       Calendar calendar;
       calendar.add(data);
   }
   
   public static void gerenciarDatas(){
       
   }*/
}
