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
        public static List<Usuario> Usuarios = new List<Usuario>();
        private object locker = new object();
        private static int controlarIdUsuario = 0;

        public IEnumerable<Usuario> Get()
        {
            return Usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (locker)
                {
                    Usuarios.Add(usuario);
                    usuario.IdUsuario = ++controlarIdUsuario;
                    return Ok(usuario);
                }
            }
        }
    }
}
