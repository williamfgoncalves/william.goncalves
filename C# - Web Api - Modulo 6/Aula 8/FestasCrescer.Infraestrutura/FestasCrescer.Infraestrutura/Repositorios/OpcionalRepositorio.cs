using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class OpcionalRepositorio
    {
        private Contexto Contexto = new Contexto();

        public List<Opcional> Obter()
        {
            return Contexto.Opcionais.ToList();
        }

        public Opcional ObterPorId(int id)
        {
            return Contexto.Opcionais.FirstOrDefault(x => x.IdOpcional == id);
        }

        public void Criar(Opcional opcional)
        {
            Contexto.Opcionais.Add(opcional);
            Contexto.SaveChanges();
        }

        public Opcional Editar(Opcional opcional)
        {
            Contexto.Entry(opcional).State = EntityState.Modified;
            Contexto.SaveChanges();
            return opcional;
        }

        public Opcional Remover(int id)
        {
            var opcional = Contexto.Opcionais.FirstOrDefault(x => x.IdOpcional == id);
            Contexto.Opcionais.Remove(opcional);
            Contexto.SaveChanges();
            return opcional;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
