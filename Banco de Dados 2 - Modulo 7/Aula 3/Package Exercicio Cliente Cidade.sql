create or replace package pck_CidadesDuplicadas as
    procedure AtualizarClientesCidades;
    procedure DeletaCidadeDuplicada;
    Function BuscaNomeCidade (cIDcliente Number) RETURN VARCHAR2;
    Function BuscaUFCidade (cIDcliente Number) RETURN  VARCHAR2;
end pck_CidadesDuplicadas;