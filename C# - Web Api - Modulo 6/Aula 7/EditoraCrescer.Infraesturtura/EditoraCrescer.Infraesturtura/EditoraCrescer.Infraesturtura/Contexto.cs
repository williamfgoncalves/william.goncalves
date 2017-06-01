using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Maps;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ConexaoBanco")
        { }

        public DbSet<Autor> Autores { get; set; } // tabelas do banco
        public DbSet<Livro> Livros { get; set; } // tabelas do banco
        public DbSet<Revisor> Revisores { get; set; } // tabelas do banco

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new RevisorMap());
        }
    }
}
