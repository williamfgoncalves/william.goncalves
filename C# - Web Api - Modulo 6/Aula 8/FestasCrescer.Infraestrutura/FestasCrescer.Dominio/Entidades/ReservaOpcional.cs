using FestasCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    class ReservaOpcional
    {
        Reserva reserva;
        Opcional opcional;
        public int quantidade { get; private set; }
    }
}
