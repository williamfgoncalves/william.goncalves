------------------------------------------------------------------------------------------------

SELECT TOP(1) PrimeiroNome, COUNT(*) AS Contagem
	FROM (SELECT SUBSTRING(Cliente.Nome, 1, CHARINDEX(' ', Cliente.Nome)) AS PrimeiroNome
	FROM Cliente) AS Resultado
	GROUP BY Resultado.PrimeiroNome
	ORDER BY Contagem DESC; 

	-----------------------------------------------------------------------------------

SELECT count(P.IDPedido) AS QuantidadeTotalDosPedidos, SUM(p.ValorPedido) AS ValorTotalDosPedidos
	FROM Pedido p
	WHERE p.IDPedido IN(
	SELECT p.IDPedido FROM Pedido WHERE MONTH(P.DataPedido) = 04 AND YEAR(P.DataPedido) = 2017);

	--------------------------------------------------------------------------------------------
SELECT TOP 1 Cid.UF, COUNT(Cid.UF) AS numeroClientes
	FROM Cliente Cli INNER JOIN Cidade Cid
	ON Cid.IDCidade = Cli.IDCidade
	GROUP BY Cid.UF
	ORDER BY COUNT (cid.UF) desc

SELECT TOP 1 Cid.UF, COUNT(Cid.UF) AS numeroClientes
	FROM Cliente Cli INNER JOIN Cidade Cid
	ON Cid.IDCidade = Cli.IDCidade 
	GROUP BY Cid.UF
	ORDER BY COUNT (cid.UF) ASC

----------------------------------------------------------------------------------------------------

Select * from Produto
Insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao) VALUES ('Galocha Maragato', 35.67, 77.95, 'A')

---------------------------------------------------------------------------------------------------------

SELECT *
FROM Produto p
WHERE NOT EXISTS
    (SELECT * 
     FROM PedidoItem pdIt
	 WHERE pdIt.IDProduto = p.IDProduto)

---------------------------------------------------------------------------------------------------------
	 
SELECT TOP 30 prod.Nome,
	SUM((prod.PrecoVenda - prod.PrecoCusto) * pedItem.Quantidade) as Lucro
FROM PedidoItem pedItem
INNER JOIN Produto prod ON prod.IDProduto = pedItem.IDProduto
INNER JOIN Pedido ped ON ped.IDPedido = pedItem.IDPedido
WHERE ped.DataPedido BETWEEN CONVERT(DATE, '01/01/2016', 103) AND CONVERT(DATE, '31/12/2016 23:59:59', 103)
GROUP BY prod.Nome
ORDER BY Lucro DESC;