using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    public class ReservaController : ApiController
    {
        /Orcamento
        public IHttpActionResult Post(ReservaModel model)
        {
            var festa = repositorio.ObterFEstaPorId(model.IdFesta);

            var reserva = new Reserva(festa);
            //repositorio.Salvar(reserva);
        }
    }
}
