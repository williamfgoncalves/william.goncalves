using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int IdPacote { get; private set; }
        public String NomePacote { get; private set; }
        public String DescricaoPacote { get; private set; }
        public decimal ValorDiariaPacote { get; private set; }

        protected Pacote() { }

        public Pacote(String nomePacote, String descricaoPacote, decimal valorDiarioPacote)
        {
            this.NomePacote = nomePacote;
            this.DescricaoPacote = descricaoPacote;
            this.ValorDiariaPacote = valorDiarioPacote;
        }
    }
}
