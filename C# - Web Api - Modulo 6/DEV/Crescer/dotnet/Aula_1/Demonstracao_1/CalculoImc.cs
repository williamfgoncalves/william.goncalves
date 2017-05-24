using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstracao_1
{
    public class CalculoImc
    {
        public double Altura { get; set; }
        public double Peso { get; set; }

        public CalculoImc( double altura, double peso)
        {
            Altura = altura;
            Peso = peso;
        }

        public double calcularSeuIMC()
        {
            return (Altura * Altura)/ Peso;
        }
    }
}
