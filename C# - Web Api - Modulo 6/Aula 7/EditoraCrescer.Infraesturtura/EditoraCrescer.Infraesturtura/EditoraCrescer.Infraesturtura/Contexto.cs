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
        public DbSet<Usuario> Usuarios { get; set; } // Tabela do banco
        public DbSet<Permissao> Permissoes { get; set; } //Tabela do banco

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new RevisorMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        }
    }
}
