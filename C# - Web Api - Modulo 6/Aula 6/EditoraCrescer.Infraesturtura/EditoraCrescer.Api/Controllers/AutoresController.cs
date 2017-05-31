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
    [RoutePrefix("api/livros")]
    public class AutoresController : ApiController
    {
        AutoresRepositorio repositorio = new AutoresRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarAutor()
        {
            var Autores = repositorio.Obter();
            return Ok(new { dados = Autores });
        }

        [HttpGet]
        [Route("{Id:int}")]
        public IHttpActionResult BuscarAutorPorid()
        {
            var Autores = repositorio.Obter();
            return Ok(new { dados = Autores });
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok(new { dados = autor });
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }
    }
}
