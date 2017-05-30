using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidoController : ApiController
    {
        PedidoRepositorio pedidoRepositorio = new PedidoRepositorio();
        // criar o produto
        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();
            if (!pedido.validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));
            pedidoRepositorio.Criar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
            var mensagens = new List<string>();
            if (!pedido.validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));
            pedidoRepositorio.Alterar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Get()
        {
            var pedidos = pedidoRepositorio.Listar();
            return Ok(pedidos);
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            pedidoRepositorio.Excluir(id);

            return Ok();
        }

    }
}
