using FestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Festa")]

    public class FestaController : ApiController
    {
        private FestaRepositorio repositorio = new FestaRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarFestas()
        {
            var festas = repositorio.Obter();
            return Ok(new { dados = festas });
        }
    }
}
