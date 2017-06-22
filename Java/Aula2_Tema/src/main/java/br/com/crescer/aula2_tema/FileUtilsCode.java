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
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
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
        if(!string.isEmpty()){
            try {
                File file = new File(string);
                file.getParentFile().mkdirs();
                final boolean b = new File(string).createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean rm(String string) {
        if(!string.isEmpty()){
            try{
                File file = new File(string);
                if(!file.isFile()){
                    return false;
                }
                file.delete();
                return true;
            }catch(Exception e){
            }
        }
        return false;
    }

    @Override
    public String ls(String string) {
        String retorno;
        File file = new File(string);
         if(file.isDirectory()){
            return retorno = Arrays.toString(file.list());
         }
         return retorno = file.getAbsoluteFile().toString();
    }

    @Override
    public boolean mv(String in, String out) {
        File fileIn = new File(in);
        Path pathIn = fileIn.toPath();
        
        if(!fileIn.isDirectory()){
            try {
                Files.move(pathIn, Paths.get(out, fileIn.getName()), REPLACE_EXISTING);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(FileUtilsCode.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
}
