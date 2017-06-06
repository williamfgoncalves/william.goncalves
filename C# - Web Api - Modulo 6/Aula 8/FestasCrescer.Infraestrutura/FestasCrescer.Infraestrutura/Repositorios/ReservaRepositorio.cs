using FestasCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    class ReservaRepositorio
    {
        private Contexto Contexto = new Contexto();

        public List<Reserva> Obter()
        {
            return Contexto.Reservas.ToList();
        }

        public Reserva ObterPorId(int id)
        {
            return Contexto.Reservas.FirstOrDefault(x => x.IdReserva == id);
        }

        public void Criar(Reserva reserva)
        {
            Contexto.Reservas.Add(reserva);
            Contexto.SaveChanges();
        }

        public Reserva Editar(Reserva reserva)
        {
            Contexto.Entry(reserva).State = EntityState.Modified;
            Contexto.SaveChanges();
            return reserva;
        }

        public Reserva Remover(int id)
        {
            var reserva = Contexto.Reservas.FirstOrDefault(x => x.IdReserva == id);
            Contexto.Reservas.Remove(reserva);
            Contexto.SaveChanges();
            return reserva;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
