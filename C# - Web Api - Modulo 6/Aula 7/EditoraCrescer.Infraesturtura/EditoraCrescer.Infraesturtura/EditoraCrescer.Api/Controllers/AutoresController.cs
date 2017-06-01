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
    [RoutePrefix("api/Autores")]

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
        public IHttpActionResult BuscarAutorPorid(int id)
        {
            var Autores = repositorio.ObterPorId(id);
            return Ok(new { dados = Autores });
        }

        [HttpGet]
        [Route("{Id:int}/Livros")]
        public IHttpActionResult BuscarLivroDosAutorPorid(int id, Autor autor)
        {
            if(autor.Id == id)
            {
                var LivrosAutor = repositorio.ObterLivrosAutor(id);
                return Ok(new { dados = LivrosAutor });
            }
            else
            {
                return BadRequest();
            }
        }

        [HttpPost]
        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok(new { dados = autor });
        }

        [HttpPut]
        [Route("{Id:int}")]
        public IHttpActionResult EditarAutor(int id, Autor autor)
        {
            if (autor.Id == id)
            {
                repositorio.Editar(autor);
                return Ok(new { dados = autor });
            }
            else
            {
                return BadRequest("Livro não encontrado!");
            }
        }

        [HttpDelete]
        [Route("{Id:int}")]
        public IHttpActionResult DeletarAutor(int id)
        {
            var autor = repositorio.Remover(id);
            return Ok(new { dados = autor });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
