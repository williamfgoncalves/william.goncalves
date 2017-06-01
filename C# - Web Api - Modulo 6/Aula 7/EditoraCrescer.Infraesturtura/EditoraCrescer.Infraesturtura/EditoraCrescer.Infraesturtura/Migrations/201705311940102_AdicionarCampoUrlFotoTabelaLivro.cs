namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarCampoUrlFotoTabelaLivro : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "UrlImagem", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Livros", "UrlImagem");
        }
    }
}
