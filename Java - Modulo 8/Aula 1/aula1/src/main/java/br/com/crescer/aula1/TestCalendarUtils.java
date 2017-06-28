
package br.com.crescer.aula1;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

public class TestCalendarUtils implements CalendarUtils{
    
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final String TEMPLATE = "%s ano(s), %s messe(s) e %s dia(s)";

    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return retornarEnum(day);
    }

    @Override
    public String tempoDecorrido(Date date) {
        CALENDAR.setTime(new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime()));
        return String.format(TEMPLATE, (CALENDAR.get(YEAR) - 1970), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH));
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
    
    private Date getHoraZero(Date date) {
        CALENDAR.setTime(date);
        CALENDAR.set(CALENDAR.get(YEAR), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH), 0, 0, 0);
        return CALENDAR.getTime();
    }
}
