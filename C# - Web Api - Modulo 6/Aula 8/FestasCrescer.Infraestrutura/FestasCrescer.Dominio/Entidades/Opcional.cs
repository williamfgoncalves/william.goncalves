using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Opcional
    {
        public int IdOpcional { get; private set; }
        public String NomeOpcional { get; private set; }
        public decimal ValorDiariaOpcional { get; private set; }
        public int QuantidadeEstoqueOpcional { get; private set; }

        protected Opcional() { }

        public Opcional(String nomeOpcional, decimal valorDiarioOpcional, int quantidadeOpcional)
        {
            this.NomeOpcional = nomeOpcional;
            this.ValorDiariaOpcional = valorDiarioOpcional;
            this.QuantidadeEstoqueOpcional = quantidadeOpcional;
        }
    }
}
