using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Entidades
{
    public class Cliente
    {
        public int IdCliente { get; set; }
        public String NomeCliente { get; set; }
        public long CPF { get; set; }
        public String Endereco { get; set; }
        public Genero Genero;
        public DateTime DataNascimento { get; set; }
        public int Numero { get; set; }
        public String Email { get; set; }
    }
}
