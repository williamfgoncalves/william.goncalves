using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Dominio.Entidades
{
    public class Festa
    {
        public int IdFesta { get; private set; }
        public String NomeFesta { get; private set; }

        protected Festa() { }

        public Festa(string nomeFesta)
        {
            this.NomeFesta = nomeFesta;
        }
    }
}
