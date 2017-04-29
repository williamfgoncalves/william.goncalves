-- Exercicio 1
select * into CidadeAux from Cidade;

-- Exercicio 2
truncate table cidadeAux;

insert into CidadeAux (IDCidade,nome,UF)
select IDCidade,nome,UF from cidade where uf = 'RS';

-- Exercicio 3
create table produtos(
	IDProdutos int identity  not null,
	nomeCurto varchar(10) not null,
	nomeCriativo varchar (50) not null,
	dataCriacao datetime not null,
	localNoEstoque varchar(50) not null,
	quantidade int not null,
	preco float not null,	
);

-- Exercicio 4
insert into produtos (nomeCurto, nomeCriativo, dataCriacao,
 localNoEstoque, quantidade, preco) values ('Martelo', 'Martelinho de ouro',
convert(datetime,'10/05/2015', 103), 'Materiais de construcao', 100, 60.0);

insert into produtos (nomeCurto, nomeCriativo, dataCriacao,
 localNoEstoque, quantidade, preco) values ('Fenda', 'Chave de Fenda',
convert(datetime,'03/08/2015', 103), 'Materiais de construcao', 43, 25.0);