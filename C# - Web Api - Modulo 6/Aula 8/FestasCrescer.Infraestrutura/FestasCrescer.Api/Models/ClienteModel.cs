using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FestasCrescer.Api.Models
{
    public class ClienteModel
    {
        public String NomeCliente { get;  set; }
        public long CPF { get;  set; }
        public String Endereco { get;  set; }
        public String Genero { get;  set; }
        public DateTime DataNascimento { get;  set; }
        public int Numero { get;  set; }
        public String Email { get;  set; }
    }
}