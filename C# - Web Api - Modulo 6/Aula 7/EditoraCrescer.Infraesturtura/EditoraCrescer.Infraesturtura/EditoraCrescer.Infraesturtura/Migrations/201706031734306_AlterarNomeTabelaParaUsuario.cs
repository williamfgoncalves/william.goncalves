namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarNomeTabelaParaUsuario : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Usarios", newName: "Usuarios");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.Usuarios", newName: "Usarios");
        }
    }
}
