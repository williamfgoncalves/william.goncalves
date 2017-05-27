using Chat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Chat.Controllers
{
    public class UsuarioController : ApiController
    {
        private static List<Usuario> Usuarios = new List<Usuario>();
        private object locker = new object();

        public IEnumerable<Usuario> Get()
        {
            return Usuarios;
        }

        public IHttpActionResult Post(Usuario Usuario)
        {
            if (Usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (locker)
                {
                    Usuarios.Add(Usuario);
                }

                return Ok(Usuario);
            }
        }
    }
}
