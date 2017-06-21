
package br.com.crescer.aula1;

import java.util.Calendar;
import java.util.Date;

public class TestCalendarUtils implements CalendarUtils{

    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return retornarEnum(day);
    }

    @Override
    public String tempoDecorrido(Date date) {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Calendar calReceived = Calendar.getInstance();
        calReceived.setTime(date);
        
        int ano = cal.get(Calendar.YEAR) - calReceived.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) - calReceived.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DATE) - calReceived.get(Calendar.DATE);
       
        return ano +" ano(s), " + mes + " mes(es) e " + dia + " dia(s)";
    }
    
    public DiaSemana retornarEnum(int day){
        
        DiaSemana dia = DiaSemana.DOMINGO;
        
        switch (day) {
            case 1: 
                dia = DiaSemana.DOMINGO;
                break;
            case 2: 
               dia = DiaSemana.SEGUNDA_FEIRA;
               break;
            case 3: 
               dia = DiaSemana.TERCA_FEIRA;
               break;
            case 4: 
               dia = DiaSemana.QUARTA_FEIRA;
               break;
            case 5: 
               dia = DiaSemana.QUINTA_FEIRA;
               break;
            case 6: 
               dia = DiaSemana.SEXTA_FEIRA;
               break;
            case 7: 
               dia = DiaSemana.SABADO;
               break;
        }
        
        return dia;
    }
}
