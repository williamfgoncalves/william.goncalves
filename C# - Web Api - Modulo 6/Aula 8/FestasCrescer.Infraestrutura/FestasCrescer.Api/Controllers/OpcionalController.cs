using FestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Opcional")]

    public class OpcionalController : ApiController
    {
        private OpcionalRepositorio repositorio = new OpcionalRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarOpcional()
        {
            var opcionais = repositorio.Obter();
            return Ok(new { dados = opcionais });
        }
    }
}
