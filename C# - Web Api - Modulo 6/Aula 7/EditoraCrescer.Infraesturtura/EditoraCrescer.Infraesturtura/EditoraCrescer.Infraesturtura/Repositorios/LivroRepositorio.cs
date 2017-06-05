using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        private AutoresRepositorio autorRepositorio = new AutoresRepositorio();
        private RevisoresRepositorio revisorRepositorio = new RevisoresRepositorio();

        public List<Livro> Obter()
        {
            return contexto.Livros.Include("Autor").ToList();
        }

        public dynamic BuscarLivrosPublicados(int quantidadePular, int quantidadeTrazer)
        {
            return contexto.Livros.Select(x => new { Id = x.Isbn, Titulo = x.Titulo, Capa = x.UrlImagem, Genero = x.Genero, NomeAutor = x.Autor.Nome })
                    .OrderBy(x => x.NomeAutor)
                    .Skip(quantidadePular)
                    .Take(quantidadeTrazer);
        }

        public dynamic ObterLivroResumido()
        {
            return contexto.Livros.Select(x => new { x.Isbn, x.Titulo, x.UrlImagem, x.Autor.Nome, x.Genero }).ToList();
        }

        public Livro ObterPorId(int isbn)
        {
            var livro = contexto.Livros.Include("Autor").
                FirstOrDefault(x => x.Isbn == isbn);

            return livro;
        }

        public Livro ObterPorGenero(string genero)
        {
            return contexto.Livros.FirstOrDefault(x => x.Genero.Contains(genero));
        }

        public dynamic ObterPorGeneroResumido(string genero)
        {
            return contexto.Livros.Select(x => new { x.Isbn, x.Titulo, x.UrlImagem, x.Autor.Nome, x.Genero })
                .Where(x => x.Genero.Contains(genero)).ToList();
        }

        public dynamic ObterLivrosSeteUltimosDias()
        {
            var data = DateTime.Now.AddDays(-7);
            return contexto.Livros.Where(x => x.DataPublicacao > data )
                .Select(x => new {x.Isbn, Titulo = x.Titulo, Capa = x.UrlImagem, NomeAutor = x.Autor.Nome, Genero = x.Genero }).ToList();
        }

        public Livro Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }

        public Livro Editar(Livro livro)
        {
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
            return livro;
        }

        public Livro Remover(int id)
        {
            return contexto.Livros.Remove(contexto.Livros.FirstOrDefault(x => x.Isbn == id));
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}