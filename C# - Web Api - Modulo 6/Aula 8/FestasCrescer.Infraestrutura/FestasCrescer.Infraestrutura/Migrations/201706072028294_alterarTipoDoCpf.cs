namespace FestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alterarTipoDoCpf : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Clientes", "CPF", c => c.String());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Clientes", "CPF", c => c.Long(nullable: false));
        }
    }
}
