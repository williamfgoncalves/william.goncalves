package br.com.crescer.aula2_tema;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        FileUtilsCode ftc = new FileUtilsCode();
        ReaderUtilsCode rts = new ReaderUtilsCode();
        WriterUtilsCode wrc = new WriterUtilsCode();
        //boolean teste = ftc.mk("C:\\Users\\William\\Documents\\testarArquivo\\log\\log4.txt");
        //System.out.println(teste);
        
        //TESTE 1.1
        //System.out.println(ftc.mk("C:\\Users\\William\\Documents\\testarArquivo\\teste\\"));
        //TESTE 1.2   //System.out.println(teste);
        //TESTE 1.3
        //System.out.println(ftc.ls("C:\\Users\\William\\Documents\\testarArquivo\\log"));
        //TESTE 1.4   //System.out.println(ftc.mv("C:\\Users\\William\\Documents\\testarArquivo\\log\\log.txt", "C:\\Users\\William\\Documents\\testarArquivo\\log2\\"));
        //TESTE 2.1   //System.out.println(rts.read("C:\\Users\\William\\Documents\\testarArquivo\\log\\log2.txt"));
        //TESTE 3.1   //
        wrc.write("C:\\Users\\William\\Documents\\testarArquivo\\log\\log2.txt", "Ta pegando BIXO! u mpais da europa");
        System.out.println(rts.read("C:\\Users\\William\\Documents\\testarArquivo\\log\\log2.txt"));

    }
}
