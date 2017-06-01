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

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public dynamic ObterLivroResumido()
        {
            return contexto.Livros.Select(x => new { x.Isbn, x.Titulo, x.UrlImagem, x.Autor.Nome, x.Genero }).ToList();
        }

        public Livro ObterPorId(int isbn)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
        }

        public Livro ObterPorGenero(string genero)
        {
            return contexto.Livros.FirstOrDefault(x => x.Genero.Contains(genero));
        }

        public dynamic ObterPorGeneroResumido(string genero)
        {
            var livros = contexto.Livros.Select(x => new { x.Isbn, x.Titulo, x.UrlImagem, x.Autor.Nome, x.Genero }).ToList();
            return livros.Where(x => x.Genero.Contains(genero)).ToList();
        }

        public dynamic ObterLivrosSeteUltimosDias()
        {
            var data = DateTime.Now.AddDays(-7);
            var livros = contexto.Livros.Where(x => x.DataPublicacao > data )
                .Select(x => new {x.Isbn, x.Titulo, x.UrlImagem, x.Autor.Nome, x.Genero }).ToList();
            return livros;
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
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == id);
            contexto.Livros.Remove(livro);
            return livro;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}