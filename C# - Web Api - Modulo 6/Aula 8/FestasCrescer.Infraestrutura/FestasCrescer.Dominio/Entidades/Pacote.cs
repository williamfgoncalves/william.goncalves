using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int IdPacote { get; set; }
        public String NomePacote { get; set; }
        public String DescricaoPacote { get; set; }
        public decimal ValorDiariaPacote { get; set; }

        protected Pacote() { };

        public Pacote(String nomePacote, String descricaoPacote, decimal valorDiarioPacote)
        {
            this.NomePacote = nomePacote;
            this.DescricaoPacote = descricaoPacote;
            this.ValorDiariaPacote = valorDiarioPacote;
        }
    }
}
