using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Entidades
{
    public class Pacote
    {
        public int IdPacote { get; set; }
        public String NomePacote { get; set; }
        public String DescricaoPacote { get; set; }
        public decimal valorDiariaPacote { get; set; }
    }
}
