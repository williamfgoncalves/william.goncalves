-- Criando tabela do banco de dados
create table Carro (
        placa           varchar(7) ,
        cor             varchar(20),
        marca           varchar(30),
        modelo          varchar(30),
        proprietario    varchar(150),
        email           varchar(100),
        telefone        varchar(100)
    );

-- Inserindo dados no banco
insert into Carro 
      (placa, 
       cor, 
       marca,
       modelo,
       proprietario,
       email,
       telefone) 
values
      ('ABC3401', 
       'branco',
       'fiat', 
       'palio',
       'carlos da silva', 
       'carlos.silva@company.com', 
       '9987-0102');

-- Selecionando todos os dados do banco
Select * 
From Carro;

-- Selecionar carro conforme o proprietario
Select * 
From Carro 
Where proprietario = 'julia de souza';

-- alterando tabela
alter table carro alter column placa varchar(8);

-- inserindo dados no banco 
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ABC-3401', 'branco', 'fiat', 'palio', 'carlos da silva', 'carlos.silva@company.com', '9987-0102');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ITR-1304', 'preto', 'citroen', 'C4', 'maria ribeiro', 'maria.ribeiro@company.com', '9764-1325');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('IAB-0101', 'preto', 'honda', 'civic', 'julia de souza', 'julia.souza@company.com', '9660-0669');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('MMA-9876', 'prata', 'fiat', 'siena', 'antonio silveira', 'antonio.silveira@company.com', '9495-2597');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('JIR-4576', 'branco', 'volkswagem', 'gol', 'pedro paulo de almeida', 'pedro.almeida@company.com', '8446-1332');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('POT-0660', 'amarelo', 'chevrolet', 'monza', 'alfredo silveira da silva', 'alfredo.silva@company.com', '8669-0909');

-- inserindo dados no banco 
insert into carro 
   (placa, cor, marca, modelo, proprietario, email, telefone) 
  values 
   ('IAB-0101', 'preto', 'honda', 'civic', 'augusta cavalcante', 'augusta.cavalcante@company.com', '8778-4556');

   insert into carro
     (placa, cor, marca, modelo, proprietario, email, telefone) 
   values
     ('IXT-7181', 'cinza', 'volkswagen', 'passat', 'julia de souza', 'julia.souza@company.com', '9660-0669');

	 
-- Selecionando colunas de modelo, marca e placa de carro que forem da marca Volkswagen 
Select modelo, marca, placa
From Carro 
Where marca = 'volkswagen';

-- Criando a tabela pais 
Create table Pais
    ( IDPais   int         not null,
      Nome     varchar(50) not null,
      Sigla    varchar(3),
         constraint PK_Pais primary key (IDPais) -- chave primaria
    }
	
-- Inserindo na tabela País	
insert into Pais
	(Nome, Sigla)
	values('Brasil', 'BRA');
	
-- Selecionando todas linhas e colunas que tenham IDPais igual  1
select * from Pais where IDPais = 1;

-- Adicionando  a tabela pais uma coluna de DDI
alter table Pais add DDI varchar(5);

-- Deletando a tabela País
Drop table Pais;


-- Criando a tabela país com restrições UNIQUE e CHECK
Create table Pais
    ( IDPais   int  IDENTITY  not null,
      Nome     varchar(50)    not null,
      Sigla    varchar(3),
	  Situacao char(1),
	  constraint PK_PAIS primary key (IDPais),
	  constraint UK_PAIS_Nome unique (Nome), -- Adicionando tabela que tera apenas registro unico!
	  constraint CC_PAIS_Situacao check (Situacao in ('A', 'i')) -- Situacao tem apenas dois valores validos, A ou I
    )

-- Inserindo na tabela País dados respeitando a modelagem acima.
insert into Pais (Nome, Sigla, Situacao) values('Brazil','BRA','A');
insert into Pais (Nome, Sigla, Situacao) values('Peru','PER','A');
insert into Pais (Nome, Sigla, Situacao) values('Chile','CHI','I');

-- Adicionando a tabela país a chave primaria apos a tabela ja ter sido criado.
alter table pais add constraint PK_PAIS primary key (IDPais);

-- Selecionando todas as linhas e colunas de país que tenha a situação A.
select * from Pais where Situacao = 'A';