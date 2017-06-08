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
        public Reserva(Festa festa, Cliente cliente, Pacote pacote, List<Opcional> opcionais, decimal totalValorEstimado, DateTime dataReserva, DateTime dataEntregaPrevista)
        {
            this.Festa = festa;
            this.Cliente = cliente;
            this.Pacote = pacote;
            this.Opcionais = opcionais;
            this.TotalValorEstimado = totalValorEstimado;
            this.DataReserva = dataReserva;
            this.DataEntregaPrevista = dataEntregaPrevista;
        }

        public decimal gerarValorTotal(decimal valorPacote, decimal valorOpcionais)
        {
            if(valorPacote == 0 || valorOpcionais == 0 )
            {
                return 0;
            }
            var numeroDias = (DataReserva.Date - DataEntregaPrevista.Date).Days;
            var valorTotalReserva = (valorPacote + valorOpcionais)*numeroDias;
            return valorTotalReserva;
        }

        public decimal gerarValorOpcionais( List<Opcional> opcionais)
        {
            decimal soma = 0;

            if (opcionais.Count === 0)
            {
                return soma;
            }

            foreach (var item in opcionais)
            {
                soma += item.ValorDiariaOpcional;
            }

            return soma;
        }

        public void RealizarEntrega(Reserva Reserva, decimal totalValorPago)
        {
            Reserva.DataEntregaRealizada = DateTime.Now;
            Reserva.TotalValorPago = totalValorPago;
        }
    }
}
