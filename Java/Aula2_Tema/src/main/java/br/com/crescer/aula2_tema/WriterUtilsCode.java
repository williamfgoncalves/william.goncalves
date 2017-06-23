/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2_tema;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class WriterUtilsCode implements WriterUtils{

    @Override
    public void write(String file, String conteudo) {
        File fileWrite = new File(file);
        if(fileWrite.toPath().getFileName().toString().contains(".csv") && fileWrite.isFile()){
            try {
                Writer writer = new FileWriter(file);
                BufferedWriter bufferWrite = new BufferedWriter(writer);
                bufferWrite.write(conteudo);
                bufferWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(WriterUtilsCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Ocorreu Algum erro!");
        }
    }
}
