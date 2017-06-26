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
//    public void write(String stringFile, String conteudo) {
//        
//        if(stringFile.endsWith(".txt") || stringFile.endsWith(".csv")){
//            File file = new File(stringFile);
//            if(file.isDirectory())
//                throw new RuntimeException("Arquivo inválido.");
//            if(!file.exists()){
//                try {
//                    file.createNewFile();
//                } catch (IOException  e) {
//                    Logger.getLogger(WriterUtilsCode.class.getName()).log(Level.SEVERE, null, e);
//                }
//            }
//            try (final FileWriter fileWriter = new FileWriter(file, true);
//                BufferedWriter bufferWrite = new BufferedWriter(fileWriter);){
//                bufferWrite.write(conteudo);
//                bufferWrite.close();
//            }catch(Exception e){
//                throw new RuntimeException(e.getMessage());
//            }
//        } else{
//            throw new RuntimeException("Arquivo não é um txt ou csv.");     
//        }
//    }
    
    public void write(String file, String conteudo){
       
        try{
             File fileEscrever = new File(file);
             String extensao = getFileExtension(fileEscrever);
             if(!extensao.equalsIgnoreCase("txt")){
                 throw new Exception("Cara, isso ai num é um txt não.");
             }
             if(!fileEscrever.exists()){
                 FileUtis fileUtils = new FileUtilsCode();
                 fileUtils.mk(file);
             }
             
             final Writer writer = new FileWriter(fileEscrever);
             final BufferedWriter bWriter = new BufferedWriter(writer);
             bWriter.write(conteudo);
             bWriter.close();
        }
        catch(Exception e){
        e.printStackTrace();
        }
        }
        
     public static String getFileExtension(File file) {
    String name = file.getName();
    try {
        return name.substring(name.lastIndexOf(".") + 1);
    } catch (Exception e) {
        return "";
    }
    
}
    
}
