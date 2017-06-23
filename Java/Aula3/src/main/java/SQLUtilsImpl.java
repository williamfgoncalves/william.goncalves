
import br.com.crescer.aula2_tema.WriterUtilsCode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
    public String executeQuery(String query){
        StringBuilder sbd = new StringBuilder();
        try {
            PreparedStatement preparedStatement = ConexaoUtils.getConection().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int coluna = rsmd.getColumnCount();
            gerarCabecalho(coluna, sbd, rsmd);
            gerarLinhas(rs,coluna, sbd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sbd.toString();
    }

    @Override
    public void importCSV(File file){
        try {
            removerAutoCommit();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            final Reader reader = new FileReader(file);
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            String linha;
            Object objetos[] = null;
            String query = gerarQuery(file, bufferReader);
            
            while ((linha = bufferReader.readLine()) != null && !linha.isEmpty()) {
                objetos = linha.split(",");
                PreparedStatement preparedStatement = ConexaoUtils.getConection().prepareStatement(query);
                for (int i = 1; i <= objetos.length; i++) {
                    preparedStatement.setObject(i, objetos[i - 1]);
                }
                preparedStatement.executeQuery(query);
                preparedStatement.close();
            }
        //ConexaoUtils.getConection().commit();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public File importCSV(String query) {
        WriterUtilsCode write = new WriterUtilsCode();
        write.write("C:\\Users\\william.goncalves\\Documents\\TestarArquivo\\Estado.csv", executeQuery(query).toString());
        return new File("C:\\Users\\william.goncalves\\Documents\\TestarArquivo\\Estado.csv");
    }
    
    private void executaQuery(String s) throws SQLException{
        Statement statement = ConexaoUtils.getConection().createStatement();
        statement.executeQuery(s);
    }
    
    private void gerarCabecalho(int coluna, StringBuilder sbd, ResultSetMetaData rsmd) throws SQLException{
        for(int i=1; i<= coluna; i++){
            sbd.append(rsmd.getColumnName(i)).append(", ");
        }
        sbd.deleteCharAt(sbd.length() - 2);
        sbd.append("\n");     
    } 
    
    private void gerarLinhas(ResultSet rs, int coluna, StringBuilder sbd) throws SQLException{
        while(rs.next()){
               for(int i=1; i<= coluna; i++){
                   sbd.append(rs.getString(i)).append(", ");
               }
               sbd.deleteCharAt(sbd.length() - 2);
               sbd.append("\n");
         }
    }
    
    private String gerarQuery(File file, BufferedReader bufferReader) throws IOException {
          String tituto = file.getName().substring(0, file.getName().length() - 4);
          StringBuffer stringBuffer = new StringBuffer("INSERT INTO ");
          stringBuffer.append(tituto).append("(");
          String campos[]  = bufferReader.readLine().split(",");
          Arrays.asList(campos).forEach(a ->{
              stringBuffer.append(a).append(" ,");
          });
         stringBuffer.deleteCharAt(stringBuffer.length() - 1);
         stringBuffer.append(" ) VALUES ");
         StringBuffer values = new StringBuffer("(");
         for (int i = 0; i < campos.length; i++) {
            values.append("?,");
         }
         values.deleteCharAt(values.length() - 1);
         values.append(")");
         return stringBuffer.append(values).toString();
    }
    
    private void removerAutoCommit() throws SQLException {
        ConexaoUtils.getConection().setAutoCommit(false);
    }

}