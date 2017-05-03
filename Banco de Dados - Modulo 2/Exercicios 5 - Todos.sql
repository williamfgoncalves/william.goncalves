--Exercicio 1
SELECT emp.NomeEmpregado, ger.NomeEmpregado, dep.NomeDepartamento
	FROM Empregado emp inner join Empregado ger
	ON emp.IDEmpregado = ger.IDGerente
	inner join Departamento dep
	ON dep.IDDepartamento = emp.IDDepartamento;

--Exercicio 2
SELECT DISTINCT dep.IDDepartamento, dep.NomeDepartamento, emp.Salario
	FROM Departamento dep inner join Empregado emp
	ON dep.IDDepartamento = emp.IDDepartamento
	AND emp.Salario = (SELECT MAX(Salario) FROM Empregado WHERE IDDepartamento IS NOT NULL)

-- Exercico 3
SELECT * into  CopiaEmpregado FROM Empregado

begin transaction
go

UPDATE Empregado SET Salario = (Salario * 0.173) + Salario  WHERE IDEmpregado IN
	(SELECT IDEmpregado
	FROM Empregado emp inner join Departamento dep
	ON emp.IDDepartamento = dep.IDDepartamento
	AND dep.Localizacao = 'SAO PAULO')

commit
go

-- Exercicio 4
SELECT C.Nome, C.UF
FROM Cidade C
INNER JOIN CidadeAux Ca
ON C.Nome = Ca.Nome AND C.UF = Ca.UF

-- Exercicio 5
SELECT Nome, UF
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(1) > 1

-- Exercicio 6
SELECT * into  CopiaCidades FROM Cidade

begin transaction
go

UPDATE Cidade SET Nome = Nome + '*'  WHERE Nome+UF IN(
		SELECT Nome+UF
		FROM Cidade
		GROUP BY Nome, UF
		HAVING COUNT(1) > 1)
	AND IDCidade IN(
		SELECT MAX(IDCidade)
		FROM Cidade
		GROUP BY Nome, UF
		HAVING COUNT(1) > 1)
	
commit
go