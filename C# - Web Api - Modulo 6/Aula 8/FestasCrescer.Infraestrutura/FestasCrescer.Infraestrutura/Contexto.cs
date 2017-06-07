using FestasCrescer.Dominio.Entidades;
using FestasCrescer.Infraestrutura.Maps;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ConexaoBanco")
        { }

        public DbSet<Cliente> Clientes { get; set; } // tabelas do banco
        public DbSet<Festa> Festas { get; set; } // tabelas do banco
        public DbSet<Opcional> Opcionais { get; set; } // tabelas do banco
        public DbSet<Pacote> Pacotes { get; set; } // Tabela do banco
        public DbSet<Reserva> Reservas { get; set; } //Tabela do banco
        public DbSet<Usuario> Usuarios { get; set; } // Tabela do banco
        public DbSet<Permissao> Permissoes { get; set; } //Tabela do banco

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new FestaMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ReservaMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        }
    }
}
