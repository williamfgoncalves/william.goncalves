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
    SELECT IDCLIENTE
    FROM CLIENTE WHERE IDCLIENTE NOT IN(
    SELECT C.CLIENTE FROM CLIENTE C
    INNER JOIN PEDIDO PE 
    ON C.IDCLIENTE = PE.IDCLIENTE
    WHERE PE.DATAPEDIDO >= ADD_MONTHS(TRUNC(SYSDATE), - 6));