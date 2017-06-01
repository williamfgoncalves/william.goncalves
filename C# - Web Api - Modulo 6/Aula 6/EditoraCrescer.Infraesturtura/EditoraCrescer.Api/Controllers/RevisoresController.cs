using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Revisores")]

    public class RevisoresController : ApiController
    {
        RevisoresRepositorio repositorio = new RevisoresRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarRevisor()
        {
            var Revisores = repositorio.Obter();
            return Ok(new { dados = Revisores });
        }

        [HttpGet]
        [Route("{Id:int}")]
        public IHttpActionResult BuscarRevisorPorId(int id)
        {
            var Revisores = repositorio.ObterRevisorPorId(id);
            return Ok(new { dados = Revisores });
        }

        [HttpPost]
        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok();
        }

        [HttpPut]
        [Route("{Id:int}")]
        public IHttpActionResult EditarAutor(int id, Revisor revisor)
        {
            if (revisor.Id == id)
            {
                repositorio.Editar(revisor);
                return Ok(new { dados = revisor });
            }
            else
            {
                return BadRequest("Revisor não encontrado!");
            }
        }

        [HttpDelete]
        [Route("{Id:int}")]
        public IHttpActionResult Delete(int id)
        {
            var revisor = repositorio.Remover(id);
            return Ok(new { dados = revisor });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
