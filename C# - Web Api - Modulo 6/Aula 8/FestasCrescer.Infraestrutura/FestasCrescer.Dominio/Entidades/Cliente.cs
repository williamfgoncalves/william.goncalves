using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int IdCliente { get; private set; }
        public String NomeCliente { get; private set; }
        public String CPF { get; private set; }
        public String Endereco { get; private set; }
        public String Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Numero { get; private set; }
        public String Email { get; private set; }

        protected Cliente() { }

        public Cliente(String nomeCliente, String cpf, String endereco, String genero, DateTime dataNascimento, int numero, String email)
        {
            this.NomeCliente = nomeCliente;
            this.CPF = cpf;
            this.Endereco = endereco;
            this.Genero = genero;
            this.DataNascimento = dataNascimento;
            this.Numero = numero;
            this.Email = email;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(NomeCliente))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            if (string.IsNullOrWhiteSpace(CPF))
                Mensagens.Add("Senha é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
