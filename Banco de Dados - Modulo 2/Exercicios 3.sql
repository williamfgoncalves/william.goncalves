-- Exercicio 1
SELECT IDEmpregado,
		NomeEmpregado,
		DATEDIFF(year, DataNascimento, '1980-01-01') as idade_Momento_Admissao
FROM Empregado

-- Exercicio 2
SELECT TOP 1 Cargo,
		   COUNT(Cargo) Numero_Cargos
FROM Empregado
GROUP BY Cargo
ORDER BY Numero_Cargos DESC

-- Exercicio 3
SELECT UF,
	   COUNT(Nome) AS Quantidade_Cidades
FROM Cidade
GROUP BY UF
ORDER BY Quantidade_Cidades DESC

-- Exercicio 4
insert into Departamento values (5, 'Inovação', 'SÃO LEOPOLDO')

begin transaction
go

UPDATE Empregado set IDDepartamento = 5 where DATEPART ( MONTH , DataAdmissao ) = 12 AND Cargo != 'Atendente'

commit