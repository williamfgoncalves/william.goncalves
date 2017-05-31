using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace Chat.Controllers
{
    public class MensagemController : ApiController
    {
        public static List<Mensagem> Mensagens = new List<Mensagem>();
        private object locker = new object();
        private static int controlarIdMensagem = 0;

        public IEnumerable<Mensagem> Get()
        {
            return Mensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                Regex regexIluminati = new Regex("andre nunes", RegexOptions.IgnoreCase);
                mensagem.Texto = regexIluminati.Replace(mensagem.Texto, "$$$$$ $$$$$");

                lock (locker)
                {
                    Mensagens.Add(mensagem);
                    mensagem.IdMensagem = ++controlarIdMensagem;
                    mensagem.DataEnvio = DateTime.Now;
                    return Ok(mensagem);
                }
            }
        }
    }
}
