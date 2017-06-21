
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class UnitTestParcelatorUtils{

    public static void main(String[] args) throws ParseException {
      TestParcelatorUtils parcelatorUtil = new TestParcelatorUtils();
      System.out.println("Teste 1.1: " + TesteUm(parcelatorUtil));
    }
    
    public static Map<String, BigDecimal> TesteUm(TestParcelatorUtils parcelatorUtil) throws ParseException{
        String data = "05/05/2016";
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDataFormat.parse(data);
        return parcelatorUtil.calcular(new BigDecimal(1000), 10, 0.1, date); 
    }
}
