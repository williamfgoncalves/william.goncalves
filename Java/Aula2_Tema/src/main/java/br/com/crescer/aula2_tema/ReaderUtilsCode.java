/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2_tema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderUtilsCode implements ReaderUtils{
    
    @Override
    public String read(String string) {
        File fileOpen = new File(string);
        Path path = fileOpen.toPath();
        String retorno = "";
        
        if(path.getFileName().toString().contains(".txt") || fileOpen.isFile()){
            Reader reader;
            try {
                reader = new FileReader(string);
                BufferedReader bufferReader = new BufferedReader(reader);
                retorno = bufferReader.readLine();
            } catch (Exception ex) {
                Logger.getLogger(ReaderUtilsCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            retorno = "Erro ao procurar o arquivo.";
        }
       return retorno;
    }
}
