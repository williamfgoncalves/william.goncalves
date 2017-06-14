--Exercicio 1
 DECLARE
    CURSOR Cidade_Cursor IS
    select Nome, Uf, count(Nome) as NUM_CIDADES_REPETIDAS
      from Cidade
      group by Nome, Uf
      having count(Nome) > 1;
    CURSOR Cliente_Cursor (pNome in varchar2, pUf in varchar2) IS  
    select cl.idcliente, cl.nome as nomeCliente, c.Nome as ClienteCidade, c.Uf
      from cliente cl 
      inner join Cidade c
      on c.IdCidade = cl.IdCidade
      where  c.Nome = pNome
      and c.Uf = pUf;
  begin
    FOR item IN Cidade_Cursor LOOP
      dbms_output.put_line('Cidade: '|| item.Nome );
      FOR item2 IN Cliente_Cursor LOOP
        dbms_output.put_line('Cliente: '|| item2.nomeCliente);
      END LOOP;  
    END LOOP;
  end;

create index IX_Cidade_NomeUF
on Cidade (Nome, UF);
create index IX_ClienteCidade
on Cliente(IdCidade);

-- Exercicio 2
CREATE OR REPLACE 
PROCEDURE Atualiza_Valor_Pedido is
    
    valorPedidoAtualizado Pedido.ValorPedido%TYPE;
    indiceBegin Pedido.idPedido%TYPE;
    
    CURSOR PedidoCursor (indiceDoFor in number) IS
        select quantidade, precounitario
        from pedidoitem
        where idpedido = indiceDoFor;
    begin
        indiceBegin := :idpedido;
        valorPedidoAtualizado := 0;
    FOR item IN PedidoCursor(indiceBegin) LOOP
        valorPedidoAtualizado := valorPedidoAtualizado + (item.quantidade * item.precounitario);
    END LOOP;
    
    UPDATE Pedido
    SET VALORPEDIDO = valorPedidoAtualizado
    WHERE IDPEDIDO = indiceBegin;
end;

CREATE OR REPLACE
PROCEDURE Atualiza_Valor_Pedido (pIDPedido IN INTEGER) AS
  vValorPedido  Pedido.ValorPedido%type;
BEGIN

   Select SUM(Quantidade * PrecoUnitario)
   into   vValorPedido
   From   PedidoItem
   Where  IDPedido = pIDPedido;
   
   Update Pedido
   Set    ValorPedido = vValorPedido
   Where  IDPedido    = pIDPedido;

END;


-- Exercicio 3 
DECLARE 
    CURSOR ClienteCursor IS
    SELECT IDCLIENTE, NOME, SITUACAO
    FROM CLIENTE WHERE IDCLIENTE NOT IN(
        SELECT IDCLIENTE
        FROM PEDIDO PE
        WHERE PE.DATAPEDIDO > ADD_MONTHS(TRUNC(SYSDATE), -6));
    begin
    FOR item IN ClienteCursor LOOP
        UPDATE CLIENTE
        SET SITUACAO = 'I'
        WHERE item.IDCLIENTE = IDCLIENTE;
    END LOOP;
end;

-- Exercicio 4

DECLARE
    CURSOR ProdutoMesCursor(IdProdutoProcurado IN NUMBER, DataAserPesquisada IN VARCHAR) IS
        SELECT PI.IDPRODUTO, SUM(PI.QUANTIDADE) AS QUANTIDADEPRODUTOS
        FROM PEDIDO PE
        INNER JOIN PEDIDOITEM PI
        ON PE.IDPEDIDO = PI.IDPEDIDO
        WHERE TO_CHAR(PE.DATAPEDIDO, 'YYYY/MM') = DataAserPesquisada
        AND PI.IDPRODUTO = IdProdutoProcurado
        GROUP BY PI.IDPRODUTO;
    CURSOR MateriaisNecessarios(IdProdutoProcurado IN NUMBER) IS
        SELECT MT.DESCRICAO, PMT.QUANTIDADE
        FROM MATERIAL MT
        INNER JOIN PRODUTOMATERIAL PMT
        ON MT.IDMATERIAL = PMT.IDMATERIAL
        WHERE PMT.IDPRODUTO = IdProdutoProcurado AND PMT.QUANTIDADE IS NOT NULL;
        Zerar NUMBER := 0;
    BEGIN
        FOR item IN ProdutoMesCursor(4246, '2017/04') LOOP
            FOR item2 IN MateriaisNecessarios(item.IdProduto) LOOP
               dbms_output.put_line(item2.descricao || ' - ' || TO_CHAR(item2.QUANTIDADE * item.QUANTIDADEPRODUTOS));
            END LOOP;
        END LOOP;
    END;