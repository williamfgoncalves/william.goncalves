namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class corrigirNomeDataRevisao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
            DropColumn("dbo.Livros", "DataRevisão");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Livros", "DataRevisão", c => c.DateTime());
            DropColumn("dbo.Livros", "DataRevisao");
        }
    }
}
