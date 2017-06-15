create or replace package body pck_CidadesDuplicadas as
 
 function BuscaNomeCidade (cIDcliente in Number) RETURN VARCHAR2 AS
          vNomeCidade Varchar2(30);
  BEGIN
      Select c.Nome
      Into vNomeCidade
      From Cliente cl
      inner join Cidade c
      on cl.Idcidade = c.IdCidade
      where cl.IdCliente = cIDcliente;
    Return vNomeCidade;
  End;  

 Function BuscaUFCidade (cIDcliente in Number) RETURN VARCHAR2 AS
    vUFCidade Varchar2(2);
  BEGIN
      Select c.UF
      Into   vUFCidade
      From Cliente cl
      inner join Cidade c
      on cl.Idcidade = c.IdCidade
      where cl.IdCliente = cIDcliente;
    Return vUFCidade;
  End;

  procedure AtualizarClientesCidades is
    cursor c_cidades is
        select cid.Nome, cid.UF, min(cid.IdCidade) as IdDaCidadeDuplicada
        from Cidade cid
        group by cid.Nome, cid.UF;
    begin
      FOR c in c_cidades LOOP     
               update Cliente
               set IdCidade = c.IdDaCidadeDuplicada
               where pck_CidadesDuplicadas.BuscaNomeCidade(IdCliente) = c.Nome
                AND
               pck_CidadesDuplicadas.BuscaUFCidade(IdCliente) = c.UF;
      END LOOP;
    end AtualizarClientesCidades;
    
  procedure DeletaCidadeDuplicada is
    cursor c_cidades is
        select cid.Nome, cid.UF, min(cid.IdCidade) as IdDaCidadeDuplicada
        from Cidade cid
        group by cid.Nome, cid.UF;
    begin
      FOR c in c_cidades LOOP     
            Delete From Cidade 
            Where Nome = c.Nome AND UF = c.UF;
      END LOOP;
    end DeletaCidadeDuplicada;
    
End pck_CidadesDuplicadas;
End pck_CidadesDuplicadas;