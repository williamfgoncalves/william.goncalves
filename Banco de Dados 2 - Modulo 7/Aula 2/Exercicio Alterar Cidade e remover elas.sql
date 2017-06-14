create or replace package pck_CidadesDuplicadas as
  
  procedure CidadesDuplicadas;
  
  FUNCTION BuscaUFCidade
          (cIDcliente in Number) RETURN VARCHAR2;
          
  FUNCTION BuscaNomeCidade
          (cIDcliente in Number) RETURN VARCHAR2;
end;

create or replace package body pck_CidadesDuplicadas as

  procedure CidadesDuplicadas is
  
      cursor c_cidades is
           select Nome, UF, min(IdCidade) as IdDaCidadeDuplicada
           from   Cidade
           group by Nome, UF
           having count(1) > 1;
           
      cursor c_clientes (pNome in varchar2,
                         pUF   in varchar2) is
         select cli.IDCliente,
                cli.Nome as Nome_Cliente,
                cid.Nome as Nome_Cidade,
                cid.UF
        from   Cliente cli
        inner join Cidade cid on cid.IDCidade = cli.IDCidade
        where  cid.Nome = pNome;
        and    cid.UF   = pUF;
         
    begin
      FOR c in c_cidades LOOP     
          FOR i in c_clientes (c.Nome, c.UF) LOOP
               update Cliente set IdCidade = IdDaCidadeDuplicada where i.Nome_Cidade = BuscaNomeCidade(i.IdCliente) AND i.UF = BuscaUFCidade(i.IdCliente);
          END LOOP;
      END LOOP;
    end;
    
  CREATE OR REPLACE
  FUNCTION BuscaNomeCidade
          (cIDcliente in Number) RETURN VARCHAR2 AS
    vNomeCidade  varchar2;
  BEGIN
      Select c.Nome
      Into   vNomeCidade
      From   Cidade c
      inner join cliente cl
      on c.Idcidade = Cl.IdCidade;
    Return vNomeCidade;
  END;  
  
 CREATE OR REPLACE
 FUNCTION BuscaUFCidade
          (cIDcliente in Number) RETURN VARCHAR2 AS
    vUFCidade  varchar2;
  BEGIN
      Select c.UF
      Into   vUFCidade
      From   Cidade c
      inner join cliente cl
      on c.Idcidade = Cl.IdCidade;
    Return vUFCidade;
  END;

