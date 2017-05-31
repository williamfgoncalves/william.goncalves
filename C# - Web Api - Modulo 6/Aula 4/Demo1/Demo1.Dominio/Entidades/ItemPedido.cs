using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Entidades
{
    public class ItemPedido
    {
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }

        public bool validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (Quantidade<0)
                mensagens.Add("Quantidade invalida!");
            return mensagens.Count() == 0;
        }
    }
}
