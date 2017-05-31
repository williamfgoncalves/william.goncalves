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

        public Livro ObterPorId(int isbn)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
        }

        public Livro ObterPorNome(string genero)
        {
            return contexto.Livros.FirstOrDefault(x => x.Genero.Contains(genero));
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