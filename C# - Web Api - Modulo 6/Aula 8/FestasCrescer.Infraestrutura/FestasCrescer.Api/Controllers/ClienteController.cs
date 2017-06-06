using FestasCrescer.Api.Models;
using FestasCrescer.Dominio.Entidades;
using FestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Clientes")]
    public class ClienteController : ApiController
    {
        ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet]
        public IHttpActionResult BuscarCliente()
        {
            var Clientes = repositorio.Obter();
            return Ok(new { dados = Clientes });
        }

        [HttpGet]
        [Route("{Id:int}")]
        public IHttpActionResult BuscarClientePorId(int id)
        {
            var Cliente = repositorio.ObterPorId(id);
            return Ok(new { dados = Cliente });
        }

        [HttpPost]
        public IHttpActionResult Post(ClienteModel clienteModel)
        {
            var cliente = new Cliente(clienteModel.NomeCliente, clienteModel.CPF, clienteModel.Endereco, clienteModel.Genero, clienteModel.DataNascimento, clienteModel.Numero, clienteModel.Numero);
            repositorio.Criar(cliente);
            return Ok(new { dados = cliente });
        }

        [HttpPut]
        [Route("{Id:int}")]
        public IHttpActionResult EditarCliente(int id, Cliente cliente)
        {
            if (cliente.IdCliente == id)
            {
                repositorio.Editar(cliente);
                return Ok(new { dados = cliente });
            }
            else
            {
                return BadRequest("Cliente não encontrado!");
            }
        }

        [HttpDelete]
        [Route("{Id:int}")]
        public IHttpActionResult DeletarCliente(int id)
        {
            var Cliente = repositorio.Remover(id);
            return Ok(new { dados = Cliente });
        }
    }
}
