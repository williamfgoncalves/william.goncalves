using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        private Contexto Contexto = new Contexto();

        public dynamic Obter()
        {
            var reservas = Contexto.Reservas
                .Select(x => new
                {
                    NomeCliente = x.Cliente.NomeCliente,
                    NomeFesta = x.Festa.NomeFesta,
                    NomePacote = x.Pacote.NomePacote,
                    DataReserva = x.DataReserva,
                    DataEntregaPrevista = x.DataEntregaPrevista,
                    DataEntregaRealizada = x.DataEntregaRealizada,
                    ValorEstimado = x.TotalValorEstimado,
                    ValorPagar = x.TotalValorPago
                }).ToList();

            return reservas;
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
