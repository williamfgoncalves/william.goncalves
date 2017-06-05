using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public int ObterRevisorPorId(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            return revisor.Id;
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Editar(Revisor revisor)
        {
            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();
            return revisor;
        }

        public Revisor Remover(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
