begin 
  DBMS_OUTPUT.PUT_LINE('Buenas Tardes!');
end;

DECLARE
  vNome_Completo  varchar2(30);
  vAno            number(4);
  vData           date;
BEGIN
  -- Atribuindo um valor para a variavel
  vNome_Completo := 'Maria da Silva';
  vData          := sysdate+1000;
  vAno           := to_char(vData, 'yyyy');

    -- Imprimindo as variaveis 
  DBMS_OUTPUT.PUT_LINE(vNome_Completo);
  DBMS_OUTPUT.PUT_LINE('Em 1000 dias estaremos em: ' || to_char(vAno)); -- os pipes sao para concatenação
END;

  BEGIN
  
    -- Consultando o total de registros
    Select count(1) from Cliente;
  
  END;

--Exercicio 1
 DECLARE
    CURSOR Cidade_Cursor IS
    select Nome, Uf, count(Nome) as NUM_CIDADES_REPETIDAS
      from Cidade
      group by nome, uf
      having count(nome) > 1;
    CURSOR Cliente_Cursor IS  
    select cl.nome as nomeCliente, c.Nome as ClienteCidade, c.Uf
      from Cidade c
      inner join cliente cl
      on c.IdCidade = cl.IdCidade;
  begin
    FOR item IN Cidade_Cursor LOOP
      FOR item2 IN Cliente_Cursor LOOP
        IF item.nome = item2.ClienteCidade THEN
          DBMS_OUTPUT.PUT_LINE(item2.nomeCliente);
        END IF;  
      END LOOP;  
    END LOOP;
  end;

-- Exercicio 2
DECLARE
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



