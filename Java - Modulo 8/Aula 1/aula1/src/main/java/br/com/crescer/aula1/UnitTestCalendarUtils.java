package br.com.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UnitTestCalendarUtils {
    public static void main(String[] args) throws ParseException {
      
      TestCalendarUtils calendarUtil = new TestCalendarUtils();
      System.out.println("Teste 1.1: " + TesteUm(calendarUtil).toString());
      System.out.println("Teste 1.2: " + TesteDois(calendarUtil));
    }
    
    public static CalendarUtils.DiaSemana TesteUm(TestCalendarUtils clt) throws ParseException{
        String data = "06/04/1996";
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDataFormat.parse(data);
        CalendarUtils.DiaSemana dia = clt.diaSemana(date);
        return dia;
    }
    
    public static String TesteDois(TestCalendarUtils clt) throws ParseException{
        String data = "19/06/2017";
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDataFormat.parse(data);
        String diferencaDatas = clt.tempoDecorrido(date);
        return diferencaDatas;
    }
}
