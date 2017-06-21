package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TestParcelatorUtils implements Parcelator{
    
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        
        BigDecimal valorParcela;
        
        BigDecimal numeroParcelarM = new BigDecimal(numeroParcelas);
        BigDecimal taxaJurosM = new BigDecimal(taxaJuros);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataPrimeiroVencimento);
        Map<String,BigDecimal> parcela = new TreeMap<String, BigDecimal>();
        
        for(int i = 0; i < numeroParcelas; i++){
            if(i!=0){
              cal.add(Calendar.MONTH, 1);
            }
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = df.format(dataPrimeiroVencimento);
            
            valorParcela = gerarValorParcela(valorParcelar, numeroParcelarM, taxaJurosM);
            parcela.put(dataFormatada, valorParcela);
        }
        
        return parcela;
    }
    
    public BigDecimal gerarValorParcela(BigDecimal valorParcelar, BigDecimal numeroParcelas, BigDecimal taxaJuros){
        BigDecimal valorParcela = (valorParcelar.divide(numeroParcelas)); 
        BigDecimal valorJuros = (valorParcela.multiply(taxaJuros)).divide(new BigDecimal(100));
        valorParcela = valorParcela.add(taxaJuros);
        return valorParcela;
    }
}
