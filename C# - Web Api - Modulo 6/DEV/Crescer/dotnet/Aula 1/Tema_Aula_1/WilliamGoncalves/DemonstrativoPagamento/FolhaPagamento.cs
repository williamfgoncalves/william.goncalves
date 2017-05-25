using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoPagamento
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            var valorHoras = Math.Round(salarioBase / horasCategoria, 777); // valor hora funcionario

            double valorTotalExtras = Math.Round(valorHoras * horasExtras, 2); // valor de horas extras 
            double valorTotalDescontos = Math.Round(valorHoras * horasDescontadas, 2); // valor de horas descontadas

            HorasCalculadas HorasExtrasCalculadas = new HorasCalculadas(horasExtras, valorTotalExtras); // total de horas extras calculadas
            HorasCalculadas HorasDescontadasCalculadas = new HorasCalculadas(horasDescontadas, valorTotalDescontos); // total de horas descontadas calculadas

            double totalProventos = Math.Round(salarioBase + (HorasExtrasCalculadas.ValorTotalHoras - HorasDescontadasCalculadas.ValorTotalHoras), 2); // valor total de ganhos mensais do funcionario

            Desconto INSS = new CalcularINSS().calcular(totalProventos);

            double salarioComINSS = totalProventos - INSS.Valor;

            Desconto IRRF = new CalcularINSS().calcular(salarioComINSS);

            double totalDescontos = INSS.Valor + IRRF.Valor;

            double TotalLiquido = Math.Round(totalProventos - totalDescontos, 2);

            double valorFGTS = Math.Round(totalProventos * 0.11, 2);

            Desconto FGTS = new Desconto(0.11, valorFGTS);
 
            return new Demonstrativo(salarioBase, horasCategoria, HorasExtrasCalculadas,
                HorasDescontadasCalculadas, totalProventos, INSS,
                IRRF, totalDescontos, TotalLiquido,
                FGTS);
        }
    }
}
