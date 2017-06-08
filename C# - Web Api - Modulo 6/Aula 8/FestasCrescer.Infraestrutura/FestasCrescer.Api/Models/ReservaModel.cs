using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FestasCrescer.Api.Models
{
    public class ReservaModel
    {
        public int IdFesta { get; set; }
        public int IdCliente { get; set; }
        public int IdPacote { get; set; }
        public List<int> Opcionais { get; set; }
        public decimal TotalValorEstimado { get; set; }
        public DateTime DataReserva { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal TotalValorPago { get; set; }
    }
}