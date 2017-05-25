using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoPagamento
{
    class CalcularINSS : ICalcular
    {
        public Desconto calcular(double totalProventos)
        {
            double aliquota = totalProventos <= 1500 ? totalProventos <= 1000 ?
                totalProventos * 0.09 : totalProventos * 0.08 : 0.1;

            double valorINSS = Math.Round(totalProventos * aliquota, 2);

            return new Desconto(aliquota, valorINSS);

            throw new NotImplementedException();
        }
    }
}
