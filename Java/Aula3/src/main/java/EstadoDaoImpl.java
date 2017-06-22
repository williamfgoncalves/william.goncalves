
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstadoDaoImpl implements EstadoDao{
    
    private static final String INSERT_CIDADE = "INSERT INTO ESTADO (ID, NOME, UF, PAIS) VALUES (?,?,?,?)";
    private static final String UPDATE_CIDADE = "UPDATE ESTADO SET NOME = ? UF = ? PAIS = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM ESTADO WHERE ID = ?";
    
    @Override
    public void insert(Estado t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(INSERT_CIDADE)) {
            preparedStatement.setLong(1, t.getId());
            preparedStatement.setString(2, t.getNome());
            preparedStatement.setString(3, t.getUF());
            preparedStatement.setLong(4, t.getIdPais());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Estado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Estado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado loadBy(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
