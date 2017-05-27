using System;

namespace Chat.Models
{
    public class Mensagem
    {
        private int IdMensagem { get; set; }
        private int IdUsuario { get; set; }
        private string Texto { get; set; }
        private DateTime DataEnvio { get; set; }
    }
}