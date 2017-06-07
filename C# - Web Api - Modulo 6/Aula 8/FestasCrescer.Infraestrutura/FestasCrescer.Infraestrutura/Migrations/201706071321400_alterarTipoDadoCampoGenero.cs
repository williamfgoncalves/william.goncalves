namespace FestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alterarTipoDadoCampoGenero : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Clientes", "Genero", c => c.String());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Clientes", "Genero", c => c.Int(nullable: false));
        }
    }
}
