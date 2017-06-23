
import java.io.File;

public class Main {
    public static void main(String[] args) {
        
        //CidadeDaoImpl c = new CidadeDaoImpl();
        //Cidade cid = new Cidade();
        //cid.setId(5565L);
        //cid.setNome("Noya City");
       // cid.setIDEstado(12);
       // c.insert(cid);
       SQLUtilsImpl sui = new SQLUtilsImpl();
       //sui.runFile("C:\\Users\\William\\Documents\\testarArquivo\\queryTeste.sql");
       //System.out.println(sui.executeQuery("SELECT * FROM CIDADE WHERE ID = 3000"));
       //File file = new File("C:\\Users\\William\\Documents\\testarArquivo\\Pais.csv");
       //sui.importCSV(file);
        System.out.println(sui.importCSV("SELECT * FROM ESTADO WHERE ID > 20").getName());
    }
}
