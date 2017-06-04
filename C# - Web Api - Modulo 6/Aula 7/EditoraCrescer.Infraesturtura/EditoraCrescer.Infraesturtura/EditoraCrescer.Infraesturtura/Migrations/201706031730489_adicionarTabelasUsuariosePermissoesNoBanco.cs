namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarTabelasUsuariosePermissoesNoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Usuario_Id = c.Guid(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Usarios", t => t.Usuario_Id)
                .Index(t => t.Usuario_Id);
            
            CreateTable(
                "dbo.Usarios",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usarios");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropTable("dbo.Usarios");
            DropTable("dbo.Permissoes");
        }
    }
}
