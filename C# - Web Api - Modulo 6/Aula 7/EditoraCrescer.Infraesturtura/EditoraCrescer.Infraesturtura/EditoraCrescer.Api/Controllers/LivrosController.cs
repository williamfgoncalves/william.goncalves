using EditoraCrescer.Infraesturtura;
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
    [RoutePrefix("Api/Livros")]

    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarLivros()
        {
            var Livros = repositorio.Obter();
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        public IHttpActionResult BuscarLivrosPublicados(int quantidadePular, int quantidadeTrazer)
        {
            var Livros = repositorio.BuscarLivrosPublicados(quantidadePular, quantidadeTrazer);
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        [Route("Resumido")]
        public IHttpActionResult BuscarLivrosResumido()
        {
            var Livros = repositorio.ObterLivroResumido();
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult BuscarLivrosPorID(int isbn)
        {
            var Livros = repositorio.ObterPorId(isbn);
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult BuscarLivrosPorGenero(string genero)
        {
            var Livros = repositorio.ObterPorGenero(genero);
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        [Route("GeneroResumido/{genero}")]
        public IHttpActionResult BuscarLivrosPorGeneroResumido(string genero)
        {
            var Livros = repositorio.ObterPorGeneroResumido(genero);
            return Ok(new { dados = Livros });
        }

        [HttpGet]
        [Route("Lancamentos")]
        public IHttpActionResult BuscarLivrosSeteUltimosDias()
        {
            var Livros = repositorio.ObterLivrosSeteUltimosDias();
            return Ok(new { dados = Livros });
        }

        [BasicAuthorization(Roles = "Administrador")]
        [HttpPost]
        public IHttpActionResult CriarLivro(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [HttpPut]
        [Route("{isbn:int}")]
        public IHttpActionResult EditarLivro(int isbn, Livro livro)
        {
            if(livro.Isbn == isbn)
            {
                repositorio.Editar(livro);
            }
            else
            {
                BadRequest("Livro não encontrado!");
            }

            return Ok(new { dados = livro });
        }

        [HttpDelete]
        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            var livro = repositorio.Remover(isbn);
            return Ok(new { dados = livro });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
};