using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public Autor ObterPorId(int id)
        {
            return contexto.Autores.FirstOrDefault(x => x.Id == id);
        }

        public List<Livro> ObterLivrosAutor(int id)
        {
            var livros = contexto.Livros.Where(x => x.IdAutor == id).ToList();
            return livros;
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Autor Editar(Autor autor)
        {
            contexto.Entry(autor).State = EntityState.Modified;
            contexto.SaveChanges();
            return autor;
        }

        public Autor Remover(int id)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
            return autor;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
