using FestasCrescer.Api.App_Start;
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
        private OpcionalRepositorio Orepositorio = new OpcionalRepositorio();
        private ReservaRepositorio repositorio = new ReservaRepositorio();

        //[BasicAuthorization(Roles = "Administrador, Publicador, Revisor, Colaborador")]

        [BasicAuthorization]
        [HttpGet]
        public IHttpActionResult BuscarReservas()
        {
            var reservas = repositorio.Obter();
            return Ok(new { dados = reservas });
        }

        [BasicAuthorization]
        [Route("pendentes")]
        [HttpGet]
        public IHttpActionResult BuscarReservasPendentes()
        {
            var reservas = repositorio.ObterReservasPendentes();
            return Ok(new { dados = reservas });
        }

        [BasicAuthorization(Roles = "Administrador")]
        [Route("pendentes30Dias")]
        [HttpGet]
        public IHttpActionResult BuscarReservasPendentes3()
        {
            var reservas = repositorio.obterUltimosDias();
            return Ok(new { dados = reservas });
        }

        [BasicAuthorization]
        [HttpPost]
        public IHttpActionResult CriarReserva(ReservaModel model)
        {
            var orcamento = repositorio.MontarObjeto(model.IdFesta,model.IdCliente,model.IdPacote,model.Opcionais,model.TotalValorEstimado, model.DataReserva, model.DataEntregaPrevista);
            repositorio.Criar(orcamento);
            return Ok(new { dados = orcamento });
        }

        [BasicAuthorization]
        [HttpPost]
        [Route("cadastroBanco")]
        public IHttpActionResult CriarReservaBanco(ReservaModelBanco model)
        {
            var reserva = new Reserva(model.Festa, model.Cliente, model.Pacote, model.Opcionais, model.TotalValorEstimado, model.DataReserva, model.DataEntregaPrevista);
            repositorio.Criar(reserva);
            return Ok();
        }

        [BasicAuthorization]
        [HttpPut]
        [Route("{IdReserva:int}")]
        public IHttpActionResult DevolverReserva(int IdReserva)
        {
            var reserva = repositorio.ObterPorId(IdReserva);
            reserva.RealizarEntrega(reserva);
            repositorio.Editar(reserva);
            return Ok();
        }
    }
}
