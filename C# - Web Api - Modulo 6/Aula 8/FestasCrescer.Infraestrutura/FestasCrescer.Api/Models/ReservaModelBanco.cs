using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FestasCrescer.Api.Models
{
    public class ReservaModelBanco
    {
        public Festa Festa{ get; set; }
        public Cliente Cliente { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcionais { get; set; }
        public decimal TotalValorEstimado { get; set; }
        public DateTime DataReserva { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal TotalValorPago { get; set; }
    }
}