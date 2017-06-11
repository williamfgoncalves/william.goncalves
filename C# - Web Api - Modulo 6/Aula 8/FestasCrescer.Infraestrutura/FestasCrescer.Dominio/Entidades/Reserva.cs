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

        
        public Reserva() { }

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

        public decimal gerarValorTotal(decimal valorPacote, decimal valorOpcionais, DateTime dataInicial, DateTime dataFinal)
        {
            if(valorPacote == 0 || valorOpcionais == 0 )
            {
                return 0;
            }
            var numeroDias = (dataInicial.Date - dataFinal.Date).Days;
            var valorTotalReserva = (valorPacote + valorOpcionais)*numeroDias;
            return Math.Abs(valorTotalReserva);
        }

        public decimal gerarValorOpcionais(List<Opcional> opcionais)
        {
            decimal valorTotalOpcionais = 0;

            if (opcionais.Count == 0)
            {
                return valorTotalOpcionais;
            }

            foreach (var item in opcionais)
            {
                valorTotalOpcionais += item.ValorDiariaOpcional;
            }

            return valorTotalOpcionais;
        }

        public void RealizarEntrega(Reserva Reserva)
        {
            var dias = Math.Abs((Reserva.DataReserva.Date - Reserva.DataEntregaPrevista).Days);
            var valorTotal = Reserva.TotalValorEstimado;
            var diaPagar = valorTotal / dias;
            var valorPagarAtual = diaPagar * Math.Abs((Reserva.DataReserva.Date - DateTime.Now.Date).Days);
            Reserva.DataEntregaRealizada = DateTime.Now;
            Reserva.TotalValorPago = valorPagarAtual;
        }
    }
}
