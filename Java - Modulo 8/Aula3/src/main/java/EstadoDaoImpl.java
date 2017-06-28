
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDaoImpl implements EstadoDao{
    
    private static final String INSERT_ESTADO = "INSERT INTO ESTADO (ID, NOME, UF, PAIS) VALUES (?,?,?,?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ? UF = ? PAIS = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";
    
    @Override
    public void insert(Estado t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(INSERT_ESTADO)) {
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
    try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(UPDATE_ESTADO)) {
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setString(2, t.getUF());
            preparedStatement.setLong(3, t.getIdPais());
            preparedStatement.setLong(4, t.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Estado t) {
        try (final PreparedStatement preparedStatement
                    = ConexaoUtils.getConection().prepareStatement(DELETE_ESTADO)) {
                preparedStatement.setLong(1, t.getId());
                preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
    }

    @Override
    public Estado loadBy(Long id) {
        final Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(LOAD_ESTADO)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUF(resultSet.getString("UF"));
                    estado.setIdPais(resultSet.getLong("PAIS"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }
    
}
