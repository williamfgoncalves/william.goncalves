Create table LogAposta(
  IDLogAposta       integer not null,
  IDApostaAntigo    integer not null,
  IDApostaNovo      integer,
  IDConcursoAntigo  integer not null,
  IDConcursoNovo    integer,
  DataHoraAntigo    date not null,
  DataHoraNovo      date,
  Usuario           varchar2(50),
  DataAlteracao     date,
  v_operacao        Char(1),
    constraint PK_LogAposta 
       primary key (IDLogAposta)
);

Create table LogNumeroAposta(
  IDLogNumeroAposta     integer not null,
  IDNumeroApostaAntigo  integer not null,
  IDNumeroApostaNovo    integer,
  IDApostaAntigo        integer not null,
  IDApostaNovo          integer,
  NumeroNovo            number(2),
  NumeroAntigo          number(2) not null,
  Usuario               varchar2(50),
  DataAlteracao         date,
  v_operacao            Char(1),
  constraint PK_LogNumeroAposta
       primary key (IDLogNumeroAposta),
       foreign key (IDAposta) references Aposta(IDAposta)
);

select * from aposta
desc numero_aposta
select * from numero_aposta;
drop table LogAposta;
drop table LogNumeroAposta;
create sequence SeqIDLogAposta;
create sequence SeqIDLogNumeroAposta;

create or replace trigger TR_AUD_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  v_Aposta        Integer;
  v_Concurso      Integer;
  v_operacao      Char(1);
Begin

  if INSERTING then
     v_operacao    := 'I';
	 v_Aposta      := :new.IDAposta;
     v_Concurso    := :new.Concurso;
  elsif UPDATING then
	 v_operacao    := 'U';
	 v_Aposta      := :new.IDAposta;
     v_Concurso    := :new.Concurso;
  else
     v_operacao    := 'D';
	 v_Aposta      := :new.IDAposta;
     v_Concurso    := :new.Concurso;
  end if;
	Insert into LogAposta (IDLogAposta, IDAposta, IDConcurso, Usuario, DataAlteracao, v_operacao)
    values (SeqIDLogAposta.nextval, v_Aposta, v_Concurso, user, sysdate, v_operacao)
 end TR_AUD_APOSTA;