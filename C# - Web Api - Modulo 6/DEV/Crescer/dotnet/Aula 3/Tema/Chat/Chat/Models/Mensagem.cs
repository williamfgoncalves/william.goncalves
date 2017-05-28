using System;

namespace Chat.Models
{
    public class Mensagem
    {
        public int IdMensagem { get; set; }
        public Usuario usuario { get; set; }
        public string Texto { get; set; }
        public DateTime DataEnvio { get; set; }
    }
}