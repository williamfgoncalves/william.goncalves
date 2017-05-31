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
    public class RevisoresController : ApiController
    {
        RevisoresRepositorio repositorio = new RevisoresRepositorio();

        public IHttpActionResult Get()
        {
            var Revisores = repositorio.Obter();
            return Ok(Revisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }
    }
}
