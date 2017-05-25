using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoPagamento
{
    class CalcularIRRF : ICalcular
    {
        public Desconto calcular(double salarioComINSS)
        {
            double aliquota = salarioComINSS <= 4271.59 ?
               salarioComINSS <= 3418.59 ? salarioComINSS <= 2563.91 ?
               salarioComINSS <= 1710.78 ? .0 : .075 : .15 : .225 : 0.275;

            double valorIRRF = Math.Round(salarioComINSS * aliquota, 2);

            return new Desconto(aliquota, valorIRRF);

            throw new NotImplementedException();
        }
    }
}
