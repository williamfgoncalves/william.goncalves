create table Usuario(
IdUsuario number(12) not null,
Email varchar2(100) not null, 
Senha varchar2(100) not null,
Nome varchar2(50) not null,
DataNascimento date not null,
Sexo char(1) not null,[
constraint pk_usuario primary key(IdUsuario));

create table Amigos(
IdUsuario number(12) not null, 
IdAmigo number(12) not null,
constraint fk_Usuario foreign key(IdUsuario) references Usuario,
constraint fk_Amigo foreign key(IdAmigo) references Amigos);

create table Solicitacao(
IdSolicitante number(12) not null, 
IdSolicitado number(12) not null,
constraint fk_Solicitante foreign key(IdSolicitante) references Solicitacao,
constraint fk_Solicitado foreign key(IdSolicitado) references Solicitacao);