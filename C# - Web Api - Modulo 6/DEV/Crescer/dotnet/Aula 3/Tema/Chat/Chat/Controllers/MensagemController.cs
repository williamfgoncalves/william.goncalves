using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Chat.Controllers
{
    public class MensagemController : ApiController
    {
        private static List<Mensagem> Mensagens = new List<Mensagem>();
        private object locker = new object();

        public IEnumerable<Mensagem> Get()
        {
            return Mensagens;
        }

        public IHttpActionResult Post(Mensagem Mensagem)
        {
            if (Mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (locker)
                {
                    Mensagens.Add(Mensagem);
                }

                return Ok(Mensagem);
            }
        }
    }
}
