
package br.com.crescer.aula1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

public class Main {
    
  public static void main(String[] args) {
      
      StringBuilder builder = new StringBuilder();
      List<String> estadosArray = new ArrayList<>();
      
      for(Estados es : Estados.values()){
          estadosArray.add(es.getNome());
      }
      
      Collections.sort(estadosArray);
      
      for(String esa : estadosArray){
          builder.append(" , " + esa);
      }
      System.out.print(builder);
    }
}


/**/