using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class PacoteRepositorio
    {
        private Contexto Contexto = new Contexto();

        public List<Pacote> Obter()
        {
            return Contexto.Pacotes.ToList();
        }

        public Pacote ObterPorId(int id)
        {
            return Contexto.Pacotes.FirstOrDefault(x => x.IdPacote == id);
        }

        public void Criar(Pacote pacote)
        {
            Contexto.Pacotes.Add(pacote);
            Contexto.SaveChanges();
        }

        public Pacote Editar(Pacote pacote)
        {
            Contexto.Entry(pacote).State = EntityState.Modified;
            Contexto.SaveChanges();
            return pacote;
        }

        public Pacote Remover(int id)
        {
            var pacote = Contexto.Pacotes.FirstOrDefault(x => x.IdPacote == id);
            Contexto.Pacotes.Remove(pacote);
            Contexto.SaveChanges();
            return pacote;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
