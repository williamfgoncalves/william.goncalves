namespace FestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CricaoBancoDados : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        IdCliente = c.Int(nullable: false, identity: true),
                        NomeCliente = c.String(),
                        CPF = c.Long(nullable: false),
                        Endereco = c.String(),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                        Numero = c.Int(nullable: false),
                        Email = c.String(),
                    })
                .PrimaryKey(t => t.IdCliente);
            
            CreateTable(
                "dbo.Festas",
                c => new
                    {
                        IdFesta = c.Int(nullable: false, identity: true),
                        NomeFesta = c.String(),
                    })
                .PrimaryKey(t => t.IdFesta);
            
            CreateTable(
                "dbo.Opcionais",
                c => new
                    {
                        IdOpcional = c.Int(nullable: false, identity: true),
                        NomeOpcional = c.String(),
                        ValorDiariaOpcional = c.Decimal(nullable: false, precision: 18, scale: 2),
                        QuantidadeEstoqueOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.IdOpcional);
            
            CreateTable(
                "dbo.Pacotes",
                c => new
                    {
                        IdPacote = c.Int(nullable: false, identity: true),
                        NomePacote = c.String(),
                        DescricaoPacote = c.String(),
                        ValorDiariaPacote = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.IdPacote);
            
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Usuario_Id = c.Guid(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Usuarios", t => t.Usuario_Id)
                .Index(t => t.Usuario_Id);
            
            CreateTable(
                "dbo.Reservas",
                c => new
                    {
                        IdReserva = c.Int(nullable: false, identity: true),
                        TotalValorEstimado = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataReserva = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        TotalValorPago = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdFesta = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.IdReserva)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Festas", t => t.IdFesta, cascadeDelete: true)
                .ForeignKey("dbo.Pacotes", t => t.IdPacote, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdFesta)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ReservaOpcional",
                c => new
                    {
                        IdReserva = c.Int(nullable: false),
                        IdOpcionais = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdReserva, t.IdOpcionais })
                .ForeignKey("dbo.Reservas", t => t.IdReserva, cascadeDelete: true)
                .ForeignKey("dbo.Opcionais", t => t.IdOpcionais, cascadeDelete: true)
                .Index(t => t.IdReserva)
                .Index(t => t.IdOpcionais);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropForeignKey("dbo.Reservas", "IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.ReservaOpcional", "IdOpcionais", "dbo.Opcionais");
            DropForeignKey("dbo.ReservaOpcional", "IdReserva", "dbo.Reservas");
            DropForeignKey("dbo.Reservas", "IdFesta", "dbo.Festas");
            DropForeignKey("dbo.Reservas", "IdCliente", "dbo.Clientes");
            DropIndex("dbo.ReservaOpcional", new[] { "IdOpcionais" });
            DropIndex("dbo.ReservaOpcional", new[] { "IdReserva" });
            DropIndex("dbo.Reservas", new[] { "IdPacote" });
            DropIndex("dbo.Reservas", new[] { "IdFesta" });
            DropIndex("dbo.Reservas", new[] { "IdCliente" });
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropTable("dbo.ReservaOpcional");
            DropTable("dbo.Usuarios");
            DropTable("dbo.Reservas");
            DropTable("dbo.Permissoes");
            DropTable("dbo.Pacotes");
            DropTable("dbo.Opcionais");
            DropTable("dbo.Festas");
            DropTable("dbo.Clientes");
        }
    }
}
