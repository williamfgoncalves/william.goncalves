using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ProdutoRepositorios
    {
        //string de conexão com o servidor;
        string stringConexao = "Server=13.65.101.67;User id=william.goncalves;PassWord=123456;DataBase=aluno10db";

        public void criar(Produto produto)
        {
            //Abrir uma conexão
            using (var conexao = new SqlConnection(stringConexao))
            {
                //insert into TABELA (COLUNAS QUE DEVE RECEBER OS DADOS) values(VALORES INFORMADOS);
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "insert into produto (nome, preco, estoque) values(@nome, @preco, @estoque);";

                    //adionando paramentros para dentro da minha query
                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    comando.ExecuteNonQuery();//executa e retorna somente a quantidade de linhas afetas

                    //comando.ExecuteReader();//ler o resultado de um select
                    //comando.ExecuteScalar();//ler o primeiro retorno que a query der
                }

                // Obtém o último ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    produto.Id = (int)result;
                }
            }
        }

        public void Alterar(Produto produto)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE PRODUTO SET Nome = @nome, Preco = @preco, Estoque = @estoque WHERE Id = @id";
                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);
                    comando.Parameters.AddWithValue("@id", produto.Id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public List<Produto> listar()
        {
            var produtos = new List<Produto>();
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT id, nome, preco, estoque FROM produto";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        var produto = new Produto();

                        produto.Id = (int)dataReader["id"];
                        produto.Nome = (string)dataReader["nome"];
                        produto.Preco = (decimal)dataReader["preco"];
                        produto.Estoque = (int)dataReader["estoque"];

                        produtos.Add(produto);
                    }
                }
            }
            return produtos;
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Produto WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public Produto Obter(int id)
        {
            Produto produto = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, Nome, Preco, Estoque FROM Produto WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        produto = new Produto();
                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];
                        return produto;
                    }
                }
            }

            return produto;
        }
    }
}