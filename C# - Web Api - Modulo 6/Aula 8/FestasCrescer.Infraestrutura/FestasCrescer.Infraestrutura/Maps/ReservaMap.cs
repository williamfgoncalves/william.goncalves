using FestasCrescer.Infraestrutura.Entidades;
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
            HasRequired(x => x.Festa)
                .WithMany()
                .HasForeignKey(x => x.IdFesta);
            HasRequired(x => x.Pacote)
                .WithMany()
                .HasForeignKey(x => x.IdPacote);
            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);
            HasMany(x => x.Opcionais).WithMany().Map(x =>
            {
                x.MapLeftKey("IdReserva");
                x.MapRightKey("IdOpcionais");
                x.ToTable("ReservaOpcionais");
            });
        }
    }
}
