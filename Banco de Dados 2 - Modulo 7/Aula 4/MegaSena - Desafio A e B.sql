---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
   Function buscarUltimoID return number as
    vUltimoId Concurso.IdConcurso%TYPE;
    begin
        Select max(IdConcurso)
        into vUltimoId
        From Concurso;
        return vUltimoId;
    end buscarUltimoID;
--- -------------------------------------------------------------------------------    
  Function valorBrutoUltimoConcurso return number as
    vValorBrutoApostas aposta.valor%TYPE;
    begin
        Select sum(valor)
        into vValorBrutoApostas
        From Aposta
        where IdConcurso = pck_megasena.buscarUltimoID;
        vValorBrutoApostas := vValorBrutoApostas * 0.435;
        return vValorBrutoApostas;
    end valorBrutoUltimoConcurso;
    
  Function buscarValorAcumulado return number as
    vValorAcumulado concurso.acumulou%TYPE;
    vQuantidadeAcumulada CONCURSO.ACUMULADO_PROXIMO_05%TYPE;
    begin
        Select acumulou
        into vValorAcumulado
        From Concurso
        where IdConcurso = pck_megasena.buscarUltimoID;
        
        vQuantidadeAcumulada := 0;
        
            if(vValorAcumulado != 0) then
                select ACUMULADO_PROXIMO_05
                into vQuantidadeAcumulada
                from concurso
                where IdConcurso = pck_megasena.buscarUltimoID;
            end if;
            
        return vQuantidadeAcumulada;
    end buscarValorAcumulado;
    
  procedure geraProximoConcurso as
   begin
        salvaConcurso(pck_megasena.buscarUltimoID + 1, sysdate, pck_megasena.buscarValorAcumulado + pck_megasena.valorBrutoUltimoConcurso);
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  function buscarPremioQuadra(pConcurso integer)return number as
  v_ValorPremioQuadra number;
  begin
      SELECT Premio_quadra 
      INTO v_ValorPremioQuadra
      FROM Concurso
      Where Idconcurso = pConcurso;
      return v_ValorPremioQuadra;
  end;
  
  function buscarPremioQuina(pConcurso integer)return number as
  v_ValorPremioQuina number;
  begin
      SELECT Premio_quadra 
      INTO v_ValorPremioQuina
      FROM Concurso
      Where Idconcurso = pConcurso;
      return v_ValorPremioQuina;
  end;
  
  function buscarPremioSena(pConcurso integer)return number as
  v_ValorPremioSena number;
  begin
      SELECT Premio_quadra 
      INTO v_ValorPremioSena
      FROM Concurso
      Where Idconcurso = pConcurso; 
      return v_ValorPremioSena;
  end;
  
  function QuantidadeVencedoresQuadra (pConcurso integer)return integer as
  v_VencedoresQuadra integer;
  begin
        SELECT count(1) 
        INTO v_VencedoresQuadra 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 4;
        return v_VencedoresQuadra;
  end;
  
  function QuantidadeVencedoresQuina(pConcurso integer)return integer as
  v_VencedoresQuina integer;
  begin
        SELECT count(1) 
        INTO v_VencedoresQuina 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 5;
        return v_VencedoresQuina;
  end;
  
  function QuantidadeVencedoresSena (pConcurso integer)return integer as
  v_VencedoresSena integer;
  begin
        SELECT count(1) 
        INTO v_VencedoresSena 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 6;
        return v_VencedoresSena;
  end;
  
  procedure atualizaAcertadores (pConcurso in integer) as
   vPrimeiraDezena number;
   vSegundaDezena number;
   vTerceiraDezena number;
   vQuartaDezena number;
   vQuintaDezena number;
   vSextaDezena number;
   vnumAcertos number;
   
   vValorPremioQuadraBuscado number;
   vValorPremioQuinaBuscado number;
   vValorPremioSenaBuscado number;
   
   vNumGanhaQuadraBuscado integer;
   vNumGanhaQuinaBuscado integer;
   vNumGanhaSenaBuscado integer;
   
   Cursor apostas is
       select a.IdAposta
       from concurso con
       inner join aposta a
       on a.IDCONCURSO = con.IDCONCURSO
       where con.IDCONCURSO = pConcurso;
       --traz todas as apostas relacionadas ao concurso e filtra por aquelas que tem o concurso que estamos procurando
    Cursor numerosApostas(vIdDaAposta integer) is
       select na.numero as numAposta
       from NUMERO_APOSTA na
       inner join aposta a
       on na.idAposta = a.IDAPOSTA
       inner join concurso c
       on a.IdConcurso = c.IDCONCURSO
       where a.idAposta = vIdDaAposta;
       -- Pegando os numeros da aposta que esta vinculada a alguma aposta que estoa vinculadas a algum concurso filtrando pelo numero da aposta
   begin
   
   select PRIMEIRA_DEZENA into vPrimeiraDezena from concurso where IDCONCURSO = pConcurso;
   select SEGUNDA_DEZENA into vSegundaDezena from concurso where IDCONCURSO = pConcurso;
   select TERCEIRA_DEZENA into vTerceiraDezena from concurso where IDCONCURSO = pConcurso;
   select QUARTA_DEZENA into vQuartaDezena from concurso where IDCONCURSO = pConcurso;
   select QUINTA_DEZENA into vQuintaDezena from concurso where IDCONCURSO = pConcurso;
   select SEXTA_DEZENA into vSextaDezena from concurso where IDCONCURSO = pConcurso;
   
   FOR apt in apostas LOOP
        vnumAcertos := 0;
        FOR numApt in numerosApostas(apt.IdAposta) LOOP
            IF numApt.numAposta = vPrimeiraDezena THEN
               vnumAcertos := vnumAcertos + 1;
            ELSIF numApt.numAposta = vSegundaDezena THEN
               vnumAcertos := vnumAcertos + 1;
            ELSIF numApt.numAposta = vTerceiraDezena THEN
               vnumAcertos := vnumAcertos + 1;
            ELSIF numApt.numAposta = vQuartaDezena THEN
               vnumAcertos := vnumAcertos + 1;
            ELSIF numApt.numAposta = vQuintaDezena THEN
               vnumAcertos := vnumAcertos + 1;
            ELSIF numApt.numAposta = vSextaDezena THEN
               vnumAcertos := vnumAcertos + 1;
            END IF;
     END LOOP;
        IF vnumAcertos > 3 THEN
            INSERT INTO Aposta_premiada (Idaposta, Acertos, Valor) 
            VALUES (apt.IdAposta,vnumAcertos, 0);
        END IF;
   END LOOP;
   
   vValorPremioQuadraBuscado  := buscarPremioQuadra(pConcurso);
   vNumGanhaQuadraBuscado := QuantidadeVencedoresQuadra(pConcurso);
   
   vValorPremioQuinaBuscado  := buscarPremioQuina(pConcurso);
   vNumGanhaQuinaBuscado := QuantidadeVencedoresQuina(pConcurso);
   
   vValorPremioSenaBuscado  := buscarPremioSena(pConcurso);
   vNumGanhaSenaBuscado := QuantidadeVencedoresSena(pConcurso);
   
   UPDATE Aposta_premiada
   SET Valor = (vValorPremioQuadraBuscado/vNumGanhaQuadraBuscado)
   WHERE Acertos = 4; 
   
   UPDATE Aposta_premiada
   SET Valor = (vValorPremioQuinaBuscado/vNumGanhaQuinaBuscado)
   WHERE Acertos = 5; 
   
   UPDATE Aposta_premiada
   SET Valor = (vValorPremioSenaBuscado/vNumGanhaSenaBuscado)
   WHERE Acertos = 6; 
   
end atualizaAcertadores;