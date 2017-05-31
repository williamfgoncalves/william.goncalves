using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    // app start tem um arquivo com os comandos
    // Exemplo,pois o controller no final é automático
    public class ExemploController : ApiController
    {
        private static List<Heroi> herois = new List<Heroi>(); // lista de herois

        public IEnumerable<Heroi> Get()
        {
            if(herois == null)
            {
                return herois;
            }
            else
            {
                return herois;
            }
        }

        private static int id = 0;
        public IHttpActionResult Post(Heroi heroi)
        {
            if(heroi == null)
            {
                return BadRequest();
            }
            else
            {
                herois.Add(heroi);
                heroi.Id = ++id;
                return Ok(heroi);
            }
        }
    }
}
