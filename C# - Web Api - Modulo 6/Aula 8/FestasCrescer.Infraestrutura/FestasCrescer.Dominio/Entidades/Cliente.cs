using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int IdCliente { get; private set; }
        public String NomeCliente { get; private set; }
        public long CPF { get; private set; }
        public String Endereco { get; private set; }
        public String Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Numero { get; private set; }
        public String Email { get; private set; }

        protected Cliente() { }

        public Cliente(String nomeCliente, long cpf, String endereco, String genero, DateTime dataNascimento, int numero, String email)
        {
            this.NomeCliente = nomeCliente;
            this.CPF = cpf;
            this.Endereco = endereco;
            this.Genero = genero;
            this.DataNascimento = dataNascimento;
            this.Numero = numero;
            this.Email = email;
        }
    }
}
