using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Infraestrutura.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        //string de conexao com o banco
        string stringConexao = "Server=13.65.101.67;User id=william.goncalves;PassWord=123456;DataBase=aluno10db";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            //lista de produtos para o pedido
            List<ItemPedido> Itens;

            using(var conexao = new SqlConnection(stringConexao))
            {
                //abrindo conexao
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = ("Insert into pedido(nomeCliente,Itens) values (@nomeCliente, @Itens)");

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@Itens", pedido.Itens);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }
            }
            // realizar o insert do Pedido
            // obter o ultimo id do pedido (SELECT @@IDENTITY)

            // para cada item do pedido, realizar o insert do ItemPedido
            // obter o ultimo id do ItemPedido (SELECT @@IDENTITY)
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT id, nomeCliente, Itens FROM Pedido";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (List<ItemPedido>)dataReader["Itens"];

                        pedidos.Add(pedido);
                    }
                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
