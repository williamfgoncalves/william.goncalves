-- Exercicio 1
SELECT Projeto,
		DATEDIFF(day, Data_Inicio_Prev, Data_Inicio_Real) as Dias_De_Atraso_De_Obra,
		DATEDIFF(month, Data_Inicio_Prev, Data_Fim_Prev) as Meses_Previstos_De_Obra,
		DATEDIFF(month, Data_Inicio_Real, Data_Fim_Real) as Meses_Reais_De_Obra
FROM Licitacao

-- exercicio 2
SELECT DISTINCT TOP 10 Empresa_Licitante,
	SUM(Valor_Realizado) as faturamento_Anual,
	SUM(Valor_Realizado) / SUM(Profissionais) as salario_Medio_Empregados
FROM Licitacao
GROUP BY Empresa_Licitante
ORDER BY salario_Medio_Empregados DESC

-- exercicio 3
SELECT TOP 10 Imposto_Municipal,
       Municipio
from licitacao
order by imposto_Municipal DESC


-- exercicio 4
select	Projeto
from Licitacao
where DATENAME(weekday, Data_Inicio_Real) between 'Saturday' AND 'Sunday'

-- Exercicio 5
SELECT	Empresa_Licitante
FROM Licitacao
GROUP BY Empresa_Licitante
HAVING SUM(Valor_Realizado) > MAX((Faturamento_1Ano_Anterior*50)/100) 

-- Exercicio 6
SELECT Projeto, Municipio, Estado, Format(Valor_Realizado, '#.00'), CustoReal =
	 CASE Esfera   
		WHEN 'Federal'   THEN Format(Valor_Realizado - Imposto_Federal, '#.00')
		WHEN 'Estadual'  THEN Format(Valor_Realizado - Imposto_Estadual, '#.00')
		WHEN 'Municipal' THEN Format(Valor_Realizado - Imposto_Municipal,  '#.00')
	 END  
FROM Licitacao
ORDER By CustoReal DESC

select * from Licitacao

-- Exercicio 7
select Municipio, Empresa_Licitante,
	(Faturamento_1Ano_Anterior - Faturamento_2Ano_Anterior) as Crescimento_De_Receita_Com_Apenas_Uma_Obra,
	(Lance_2Colocado - Valor_Previsto ) as valorDeDiferencaEntreLances,
	DATEDIFF(month, Data_Inicio_Real, Data_Fim_Prev) as Meses_Previstos_De_Obra,
	DATEDIFF(month, Data_Inicio_Prev, Data_Fim_Real) as Meses_De_Duracao_Obra
	from Licitacao
where Identificador = 17255;

-- Confrontando estes dados podemos dizer que a empresa que esta fazendo esta obra fez algum tipo de superfaturamento
-- Note que a empresa cresceu 34 milhoes em apenas um ano
-- Os valores entre a oferta da empresa e a sugunda colocada na licitação é mais de 10 vezes maior
-- A obra que era prevista para 5 meses levou 12 para ser concluida