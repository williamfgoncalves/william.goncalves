using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class FestaRepositorio
    {
        private Contexto Contexto = new Contexto();

        public List<Festa> Obter()
        {
            return Contexto.Festas.ToList();
        }

        public Festa ObterPorId(int id)
        {
            return Contexto.Festas.FirstOrDefault(x => x.IdFesta == id);
        }

        public void Criar(Festa festa)
        {
            Contexto.Festas.Add(festa);
            Contexto.SaveChanges();
        }

        public Festa Editar(Festa festa)
        {
            Contexto.Entry(festa).State = EntityState.Modified;
            Contexto.SaveChanges();
            return festa;
        }

        public Festa Remover(int id)
        {
            var festa = Contexto.Festas.FirstOrDefault(x => x.IdFesta == id);
            Contexto.Festas.Remove(festa);
            Contexto.SaveChanges();
            return festa;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
