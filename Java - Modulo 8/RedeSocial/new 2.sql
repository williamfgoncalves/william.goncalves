create table Usuarios(
IdUsuario number(12) not null,
Email varchar2(100) not null, 
Senha varchar2(100) not null,
Nome varchar2(50) not null,
DataNascimento date not null,
Sexo char(1) not null,
constraint pk_usuario primary key(IdUsuario));

create table Amigos(
IdAmigos number(12) not null,
IdUsuario number(12) not null, 
IdAmigo number(12) not null,
constraint pk_amigos primary key(IdAmigos),
constraint fk_Usuario foreign key(IdUsuario) references Usuario,
constraint fk_Amigo foreign key(IdAmigo) references Usuario);

create table postagem(
IdPostagem number(12) not null,
Texto varchar2(500) not null,
urlImagem varchar2(300),
dataPostagem date not null,
IdCurtida number(12),
constraint pk_idPostagem primary key (IdPostagem));

create table curtidas(
IdCurtida number(12) not null,
IdPostagem number(12) not null,
IdUsuario number(12) not null,
constraint pk_Curtida primary key(IdCurtida));


select * from usuario s
inner join amigos a
on a.idamigo = s.idusuario;


drop table amigos

insert into usuario(IDUSUARIO, EMAIL, SENHA, NOME, DATANASCIMENTO, SEXO)
values(1,'william.fernando92@gmail.com','123456','William',TO_DATE('06-04-1996', 'DD-MM-YYYY'),'M');
insert into usuario(IDUSUARIO, EMAIL, SENHA, NOME, DATANASCIMENTO, SEXO)
values(2,'alexia@gmail.com','123456','Alexia',TO_DATE('14-02-2000', 'DD-MM-YYYY'),'F');
insert into usuario(IDUSUARIO, EMAIL, SENHA, NOME, DATANASCIMENTO, SEXO)
values(3,'alana@gmail.com','123456','Alana',TO_DATE('27-06-1999', 'DD-MM-YYYY'),'F');
insert into usuario(IDUSUARIO, EMAIL, SENHA, NOME, DATANASCIMENTO, SEXO)
values(4,'deordines@gmail.com','123456','Deordines',TO_DATE('18-08-1993', 'DD-MM-YYYY'),'M');
insert into usuario(IDUSUARIO, EMAIL, SENHA, NOME, DATANASCIMENTO, SEXO)
values(5,'mirella@gmail.com','123456','Mirella',TO_DATE('10-05-1994', 'DD-MM-YYYY'),'F');



drop table postagem
drop table curtidas

Alter table Postagem add constraint pk_idPostagem primary key (IdPostagem),
add constraint fk_curtida foreign key (idCurtida) references Curtidas);

Alter table Curtidas add constraint fk_IdPostagemCurtida foreign key (idPostagem) references Postagem(IdPostagem);
Alter table Curtidas add constraint fk_IdUsuarioCurtidor foreign key (IdUsuario) references Usuario(idUsuario);