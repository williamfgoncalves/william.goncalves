namespace FestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
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
                        valorDiariaPacote = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.IdPacote);
            
            CreateTable(
                "dbo.Reservas",
                c => new
                    {
                        IdReserva = c.Int(nullable: false, identity: true),
                        IdFesta = c.Int(nullable: false),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        TotalValorEstimado = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataReserva = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        TotalValorPago = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.IdReserva)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Festas", t => t.IdFesta, cascadeDelete: true)
                .ForeignKey("dbo.Pacotes", t => t.IdPacote, cascadeDelete: true)
                .Index(t => t.IdFesta)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.ReservaOpcionais",
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
            DropForeignKey("dbo.Reservas", "IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.ReservaOpcionais", "IdOpcionais", "dbo.Opcionais");
            DropForeignKey("dbo.ReservaOpcionais", "IdReserva", "dbo.Reservas");
            DropForeignKey("dbo.Reservas", "IdFesta", "dbo.Festas");
            DropForeignKey("dbo.Reservas", "IdCliente", "dbo.Clientes");
            DropIndex("dbo.ReservaOpcionais", new[] { "IdOpcionais" });
            DropIndex("dbo.ReservaOpcionais", new[] { "IdReserva" });
            DropIndex("dbo.Reservas", new[] { "IdPacote" });
            DropIndex("dbo.Reservas", new[] { "IdCliente" });
            DropIndex("dbo.Reservas", new[] { "IdFesta" });
            DropTable("dbo.ReservaOpcionais");
            DropTable("dbo.Reservas");
            DropTable("dbo.Pacotes");
            DropTable("dbo.Opcionais");
            DropTable("dbo.Festas");
            DropTable("dbo.Clientes");
        }
    }
}
