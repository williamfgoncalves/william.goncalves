
SELECT a.IDAssociado,
	a.Nome,
	a.IDCidade,
	c.Nome as Nome_Cidade
	FROM associado a inner join Cidade c
	on c.IDCidade = a.IDCidade;

SELECT a.IDAssociado,
	a.Nome,
	a.IDCidade,
	c.Nome as Nome_Cidade
	FROM associado a right join Cidade c
	on c.IDCidade = a.IDCidade;

SELECT a.IDAssociado,
	a.Nome,
	a.IDCidade,
	c.Nome as Nome_Cidade
	FROM associado a left join Cidade c
	on c.IDCidade = a.IDCidade;

SELECT emp.IDEmpregado,
	emp.NomeEmpregado,
	emp.IDGerente From
	Empregado emp inner join Empregado ger
	on emp.IDGerente = ger.IDEmpregado

-- Confrontando estes dados podemos dizer que a empresa que esta fazendo esta obra fez algum tipo de superfaturamento
-- Note que a empresa cresceu 34 milhoes em apenas um ano
-- Os valores entre a oferta da empresa e a sugunda colocada na licitação é mais de 10 vezes maior
-- A obra que era prevista para 5 meses levou 12 para ser concluida

Select IDCidade, Nome
From Cidade e
Where IDCidade IN (Select IDCidade
From Associado)--Exercicio 1SELECT emp.NomeEmpregado, ger.NomeEmpregado, dep.NomeDepartamento	FROM Empregado emp inner join Empregado ger	ON emp.IDEmpregado = ger.IDGerente	inner join Departamento dep	ON dep.IDDepartamento = emp.IDDepartamento;--Exercicio 2SELECT DISTINCT dep.IDDepartamento, dep.NomeDepartamento, emp.Salario		FROM Departamento dep inner join Empregado emp		ON dep.IDDepartamento = emp.IDDepartamento		AND emp.Salario = (SELECT MAX(Salario) FROM Empregado WHERE IDDepartamento IS NOT NULL)-- Exercico 3SELECT * into  CopiaEmpregado FROM EmpregadoUPDATE Empregado SET Salario = (Salario * 0.173) + Salario  WHERE IDEmpregado IN(SELECT IDEmpregado	FROM Empregado emp inner join Departamento dep	ON emp.IDDepartamento = dep.IDDepartamento	AND dep.Localizacao = 'SAO PAULO')SELECT * FROM CopiaEmpregadoSELECT * FROM EmpregadoSELECT * FROM Departamentoselect TOP(1)
       d.IDDepartamento   as IDDepartamento,
       d.NomeDepartamento as Departamento,
	   e.salario
From Empregado e
Inner Join Departamento d
                on e.IDDepartamento = d.IDDepartamento
Order by e.salario DESC;