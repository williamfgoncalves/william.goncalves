using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Maps
{
    class ReservaMap : EntityTypeConfiguration<Reserva>
    {
        public ReservaMap()
        {
            ToTable("Reservas");
            HasKey(x => x.IdReserva);
            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));
            HasRequired(x => x.Festa)
                .WithMany()
                .Map(x => x.MapKey("IdFesta"));
            HasRequired(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));
            /*HasMany(x => x.Opcionais).WithMany().Map(x =>
            {
                x.MapLeftKey("IdReserva");
                x.MapRightKey("IdOpcionais");
                x.ToTable("ReservaOpcionais");
            }*/);
        }
    }
}
