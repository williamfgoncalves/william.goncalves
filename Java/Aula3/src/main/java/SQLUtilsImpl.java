
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLUtilsImpl implements SQLUtils{

    @Override
    public void runFile(String filename) {
        List<String> linhas;
        String query = "";
        File file = new File(filename);
        Path path = file.toPath();
        Reader reader;
        
        if(file.isFile() && path.getFileName().toString().contains(".sql")){
            try {
                linhas = Files.readAllLines(path);
                for(String line : linhas){
                    query = query + line;
                }
                executaQuery(query);
            } catch (Exception e) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            System.out.println("Você não mandou um arquivo!");
        }
    }

    @Override
    public String executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void executaQuery(String s) throws SQLException{
        Statement statement = ConexaoUtils.getConection().createStatement();
        statement.executeQuery(s);
    }
}
