create or replace package body pck_CidadesDuplicadas as

  procedure AtualizarClientesCidades is
  
    cursor c_cidades is
        select min(cid.IdCidade) as IdDaCidadeDuplicada, cid.Nome, cid.UF
        from Cidade cid
        group by cid.Nome, cid.UF
        HAVING COUNT(1) > 1;
    
    cursor c_clientes(vNomeCidade IN VARCHAR2, vUFcidade IN VARCHAR2) is
        Select cl.IdCliente, 
            cid.Nome as     NomeCidadeCliente,
            cid.UF as       UFCidadeCliente,
            cl.IDCIDADE as idDaCidade
        From Cliente cl
        inner join Cidade cid
        on cl.Idcidade = cid.IdCidade
        where cid.NOME = vNomeCidade AND cid.UF = vUFcidade;
        
    begin
        FOR cid in c_cidades LOOP
                FOR clid in c_clientes(cid.Nome, cid.UF) LOOP
                    update Cliente cli
                    set cli.IdCidade = cid.IdDaCidadeDuplicada
                    where cli.IDCIDADE != cid.IdDaCidadeDuplicada AND cli.IDCLIENTE = clid.IdCliente;
                END LOOP;
            DELETE FROM Cidade WHERE Nome = cid.Nome AND IDCidade != cid.IdDaCidadeDuplicada;
        END LOOP;
    end AtualizarClientesCidades;
    
End pck_CidadesDuplicadas;