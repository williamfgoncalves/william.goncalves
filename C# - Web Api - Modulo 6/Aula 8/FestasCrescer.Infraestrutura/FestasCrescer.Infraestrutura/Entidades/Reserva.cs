using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Entidades
{
    public class Reserva
    {
        public int IdReserva { get; set; }
        public int IdFesta { get; set; }
        public Festa Festa { get; set; }
        public int IdCliente { get; set; }
        public Cliente Cliente { get; set; }
        public int IdPacote { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcionais { get; set; }
        public decimal TotalValorEstimado { get; set; }
        public DateTime DataReserva { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal TotalValorPago { get; set; }
    }
}
