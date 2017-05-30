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
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    // Criacao do comando de update
                    comando.CommandText =
                        @"UPDATE PEDIDO SET NomeCliente = @NomeCliente";
                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }
            }
        }

        public void Criar(Pedido pedido)
        {

            using(var conexao = new SqlConnection(stringConexao))
            {
                //abrindo conexao

                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    //inserindo pedido no banco
                    comando.CommandText = ("Insert into Pedido (NomeCliente) values (@NomeCliente)");
                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

               using (var comando = conexao.CreateCommand())
               {
                    //iterando itens dentro de pedido
                   foreach(ItemPedido item in pedido.Itens)
                   {
                        //inserindo na tabela de pedido os itens do respectivo pedido 
                        comando.CommandText = ("Insert into ItemPedido(PedidoId, ProdutoId, Quantidade) values (@PedidoId, @ProdutoId, @Quantidade)");
                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();

                        //atualizando ó estoque dos produtos adicionados no pedido
                        comando.CommandText = ("Update Produto set Estoque = Estoque - @Quantidade WHERE Id = @itemProdutoId");
                        comando.Parameters.AddWithValue("@itemProdutoId", item.ProdutoId);
                        comando.ExecuteNonQuery();
                        comando.Parameters.Clear(); // limpando os paramentros do comando para um novo while
                    }
               }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";
                    comando.Parameters.AddWithValue("@id", id);
                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>(); // criando a lista de pedidos para jogar na tela

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    //selecionando as informações do pedido fazendo inner join com a item pedido
                    comando.CommandText = @"SELECT p.Id AS IdPedido, p.NomeCliente, ip.Id AS IdItemPedido, ip.ProdutoId, ip.Quantidade FROM Pedido p JOIN ItemPedido ip ON p.Id = ip.PedidoId";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        int idAtual = (int)dataReader["IdPedido"]; // pegando o id do pedido para os testes

                        if (pedidos.Where(p => p.Id == idAtual).Count() == 1)
                        {
                            pedidos.Where(p => p.Id == idAtual).First().Itens.Add(new ItemPedido()
                            {
                                Id = (int)dataReader["IdItemPedido"],
                                ProdutoId = (int)dataReader["ProdutoId"],
                                Quantidade = (int)dataReader["Quantidade"]
                            });
                        }
                        else
                        {
                            pedidos.Add(new Pedido()
                            {
                                Id = idAtual,
                                NomeCliente = (string)dataReader["NomeCliente"],
                                Itens = new List<ItemPedido>()
                                {
                                    new ItemPedido {
                                        Id = (int)dataReader["IdItemPedido"],
                                        ProdutoId = (int)dataReader["ProdutoId"],
                                        Quantidade = (int)dataReader["Quantidade"]
                                    }
                                }
                            }
                            );
                        }
                    }
                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = new Pedido();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT p.Id AS IdPedido, p.NomeCliente, ip.Id AS IdItemPedido, ip.ProdutoId, ip.Quantidade FROM Pedido p JOIN ItemPedido ip ON p.Id = ip.PedidoId AND p.Id = @Id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        int idAtual = (int)dataReader["IdPedido"];

                        if (pedido.Id == idAtual)
                        {
                            pedido.Itens.Add(new ItemPedido()
                            {
                                Id = (int)dataReader["IdItemPedido"],
                                ProdutoId = (int)dataReader["ProdutoId"],
                                Quantidade = (int)dataReader["Quantidade"]
                            });
                        }
                        else
                        {
                            pedido.Id = idAtual;
                            pedido.NomeCliente = (string)dataReader["NomeCliente"];

                            pedido.Itens = new List<ItemPedido>()
                            {
                                new ItemPedido
                                {
                                    Id = (int)dataReader["IdItemPedido"],
                                    ProdutoId = (int)dataReader["ProdutoId"],
                                    Quantidade = (int)dataReader["Quantidade"]
                                }
                             };

                        }
                    }
                }
            }

            return pedido;
        }
    }
}
