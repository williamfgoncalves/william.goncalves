using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Reserva
    {
        public int IdReserva { get; set; }
        public Festa Festa { get; set; }
        public Cliente Cliente { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcionais { get; set; }
        public decimal TotalValorEstimado { get; set; }
        public DateTime DataReserva { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal TotalValorPago { get; set; }

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
