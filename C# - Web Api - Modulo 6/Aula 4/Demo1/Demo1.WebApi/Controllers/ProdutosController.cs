using Demo1.Dominio.Entidades;
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
    public class ProdutosController : ApiController
    {
        ProdutoRepositorios produtoRepositorio = new ProdutoRepositorios();
        // criar o produto
        public IHttpActionResult Post(Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));
                produtoRepositorio.criar(produto);
                return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            var produtos = produtoRepositorio.listar();
            return Ok(produtos);
        }
    }
}
