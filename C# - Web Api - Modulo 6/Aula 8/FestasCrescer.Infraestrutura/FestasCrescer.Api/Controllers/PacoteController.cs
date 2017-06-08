using FestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Pacote")]

    public class PacoteController : ApiController
    {
        private PacoteRepositorio repositorio = new PacoteRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarPacote()
        {
            var pacotes = repositorio.Obter();
            return Ok(new { dados = pacotes });
        }
    }
}
