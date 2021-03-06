﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(NomeCliente))
                mensagens.Add("Insira um nome Valido!.");

            return mensagens.Count() == 0;
        }
    }
}
