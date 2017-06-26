package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestParcelatorUtils implements Parcelator{
    
    private static final DateFormat formatarData = new SimpleDateFormat("dd/MM/yyyyy");
    private static final Calendar dataParcela = Calendar.getInstance();

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        
        final BigDecimal numParcelas = BigDecimal.valueOf(numeroParcelas);
        final BigDecimal txJuros = BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
        final BigDecimal valorTotal = valorParcelar.multiply(txJuros);
        final BigDecimal valorParcela = valorTotal.divide(numParcelas,2, RoundingMode.HALF_UP);
        BigDecimal valorResto = valorParcela.multiply(numParcelas).subtract(valorTotal);
        final Map<String, BigDecimal> parcelas = new LinkedHashMap();
        dataParcela.setTime(dataPrimeiroVencimento);
      
        for(int i = 0; i < numeroParcelas; i++){
            parcelas.put(formatarData.format(dataParcela.getTime()), valorParcela.subtract(valorResto));
            valorResto = BigDecimal.ZERO;
            dataParcela.add(Calendar.MONTH, 1);
        }
        return parcelas;
    }
}
