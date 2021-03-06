﻿using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio
    {
        private Contexto Contexto = new Contexto();

        public List<Cliente> Obter()
        {
            return Contexto.Clientes.ToList();
        }

        public Cliente ObterPorId( int id)
        {
            return Contexto.Clientes.FirstOrDefault( x=> x.IdCliente == id);
        }

        public bool Criar(Cliente cliente)
        {
            if (podeCadastrar(cliente.CPF))
            {
                Contexto.Clientes.Add(cliente);
                Contexto.SaveChanges();
                return true;
            }
            return false;
        }

        public Cliente Editar(Cliente cliente)
        {
            Contexto.Entry(cliente).State = EntityState.Modified;
            Contexto.SaveChanges();
            return cliente;
        }

        public Cliente Remover(int id)
        {
            var cliente = Contexto.Clientes.FirstOrDefault(x => x.IdCliente == id);
            Contexto.Clientes.Remove(cliente);
            Contexto.SaveChanges();
            return cliente;
        }

        public bool podeCadastrar(string cpf)
        {
            var cliente = Contexto.Clientes.Where(x => x.CPF.Contains(cpf)).FirstOrDefault();
            if (cliente != null)
            {
                return false;
            }
            return true;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
