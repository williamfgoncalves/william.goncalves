using FestasCrescer.Api.Models;
using FestasCrescer.Dominio.Entidades;
using FestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Reserva")]

    public class ReservaController : ApiController
    {
        private ClienteRepositorio Crepositorio = new ClienteRepositorio();
        private FestaRepositorio Frepositorio = new FestaRepositorio();
        private PacoteRepositorio Prepositorio = new PacoteRepositorio();
        private ReservaRepositorio repositorio = new ReservaRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarReservas()
        {
            var reservas = repositorio.Obter();
            return Ok(new { dados = reservas });
        }

        //Orcamento
        [HttpPost]
        public IHttpActionResult CriarReserva(ReservaModel model)
        {
            var festa = Frepositorio.ObterPorId(model.IdFesta);
            var cliente = Crepositorio.ObterPorId(model.IdCliente);
            var pacote = Prepositorio.ObterPorId(model.IdPacote);
            var opcional = model.Opcionais;
            var reserva = new Reserva(festa, cliente,pacote, model.Opcionais, model.TotalValorEstimado, model.DataReserva, model.DataEntregaPrevista);
            repositorio.Criar(reserva);
            return Ok(new { dados = cliente });
        }
    }
}
