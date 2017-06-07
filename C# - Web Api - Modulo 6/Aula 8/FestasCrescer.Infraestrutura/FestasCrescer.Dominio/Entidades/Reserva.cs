using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Reserva
    {
        public int IdReserva { get; private set; }
        public Festa Festa { get; private set; }
        public Cliente Cliente { get; private set; }
        public Pacote Pacote { get; private set; }
        public List<Opcional> Opcionais { get; private set; }
        public decimal TotalValorEstimado { get; private set; }
        public DateTime DataReserva { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaRealizada { get; private set; }
        public decimal TotalValorPago { get; private set; }

        protected Reserva() { }
        public Reserva(Festa festa, Cliente cliente, Pacote pacote, decimal totalValorEstimado, DateTime dataReserva, DateTime dataEntregaPrevista)
        {
            this.Festa = festa;
            this.Cliente = cliente;
            this.Pacote = pacote;
            this.TotalValorEstimado = totalValorEstimado;
            this.DataReserva = dataReserva;
            this.DataEntregaPrevista = dataEntregaPrevista;
        }
        
        public void RealizarEntrega(Reserva Reserva, decimal totalValorPago)
        {
            Reserva.DataEntregaRealizada = DateTime.Now;
            Reserva.TotalValorPago = totalValorPago;
        }
    }
}
