/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2_tema;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class FileUtilsCode implements FileUtis {

    @Override
    public boolean mk(String string) {
        if (string != null) {
            try {
                File file = new File(string);
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                return file.exists() || string.matches(".*\\..{3}") ? file.createNewFile() : file.mkdir();
            } catch (Exception e) {
            }
        }
        return false;
    }

    @Override
    public boolean rm(String string) {
        File file = new File(string);
        if (file.isDirectory()) {
            throw new RuntimeException("Arquivo inválido");
        }
        return file.delete();
    }

    @Override
    public String ls(String string) {
        
        String[] retorno;
        File file = new File(string);
        
        if (file.isDirectory()) {
            retorno =  new File(string).list();
            return String.join(", ", retorno);
        }else{
            return file.getAbsoluteFile().toString();
        }
    }

    @Override
    public boolean mv(String in, String out) {
        
        File fileIn = new File(in);
        File fileOut = new File(out);
        if(!fileIn.isFile()){
            throw new RuntimeException("Diretório não pode ser movido");
        }
        return fileIn.renameTo(fileOut);
    }

    public boolean isFile(String string) {
        return string.contains(".");
    }
}
