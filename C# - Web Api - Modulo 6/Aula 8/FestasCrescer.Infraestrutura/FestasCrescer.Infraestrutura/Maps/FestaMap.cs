using FestasCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Maps
{
    class FestaMap : EntityTypeConfiguration<Festa>
    {
        public FestaMap()
        {
            ToTable("Festas");
            HasKey(x => x.IdFesta);
        }
    }
}
