CREATE TABLE LogAposta (
  IDLogAposta     integer not null,
  IDAposta        integer not null,
  IDConcurso      integer not null,
  Usuario         varchar2(50),
  Data            date default sysdate,  
  Operacao        char(1) not null,
  CONSTRAINT PK_LogAposta PRIMARY KEY (IDLogAposta)
);
CREATE SEQUENCE sqLogAposta;

Create table LogNumeroAposta (
  IDLogNumeroAposta     integer not null,
  IDLogAposta           integer not null,
  IDAposta              integer not null,
  IDNumeroAposta        integer not null,
  NumeroNovo            number(2),
  NumeroAntigo          number(2) not null,
  Usuario               varchar2(50),
  DataAlteracao         date,
  v_operacao            Char(1),
  CONSTRAINT PK_LogNumero_Aposta PRIMARY KEY (IDLogNumeroAposta),
  CONSTRAINT FK_Log_Aposta FOREIGN KEY (IDLogAposta) REFERENCES LogAposta(IDLogAposta)
);
create sequence SeqIDLogNumeroAposta;

CREATE OR REPLACE TRIGGER TR_AUD1_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Aposta
    FOR EACH ROW
DECLARE
  v_operacao char(1);
BEGIN
  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING THEN
     v_operacao := 'U';       
  ELSE
     v_operacao := 'D';
  END IF;
  INSERT INTO LogAposta (IDLogAposta, IDAposta,IDConcurso, Usuario, Data, Operacao) 
  VALUES (sqLogAposta.NEXTVAL, :new.IDAposta, :new.IDConcurso, user, SYSDATE, v_operacao);
END TR_AUD1_APOSTA;

CREATE OR REPLACE TRIGGER TR_AUD1_NUMERO_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Numero_Aposta
    FOR EACH ROW
DECLARE
  v_operacao char(1);
  v_IDAposta Numero_Aposta.IDAposta%TYPE;
BEGIN
  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING THEN
     v_operacao := 'U';       
  ELSE
     v_operacao := 'D';
  END IF;
  
  SELECT IDLogAposta INTO v_IDAposta FROM LogAposta WHERE IDAposta = :new.IDAposta;
  
  INSERT INTO LogNumeroAposta (IDLogNumeroAposta, IDLogAposta, IDAposta, IDNumeroAposta, NumeroNovo, NumeroAntigo, Usuario, Data, Operacao) 
  VALUES (sqLogNumeroAposta.NEXTVAL, v_IDAposta, :new.IDAposta, :new.IDNumeroAposta, :new.NumeroNovo, :new.NumeroAntigo, user, SYSDATE, v_operacao);
END TR_AUD1_NUMERO_APOSTA;

-- Exercicio 2

SELECT cid.UF, con.IDConcurso, SUM(a.IDAposta) Numero_Apostas , SUM(a.Valor) Valor_Arrecadado, 
SUM(ap.IDAposta_Premiada) Acertadores, SUM(ap.Valor) Premiacao
FROM Aposta a JOIN Cidade cid ON a.IDCidade = cid.IDCidade
JOIN Concurso con ON con.IDConcurso = a.IDConcurso
LEFT JOIN Aposta_Premiada ap ON ap.IDAposta = a.IDAposta
GROUP BY con.IDConcurso, cid.UF;

-- Exercicio 3

SELECT * FROM LogAposta lga
JOIN LogNumeroAposta lgna ON lga.IDLogAposta = lgna.IDLogAposta
JOIN Aposta a ON lga.IDAposta = a.IDAposta
JOIN Concurso c ON c.IDConcurso = a.IDConcurso
WHERE lga.Data > c.Data_Sorteio;
