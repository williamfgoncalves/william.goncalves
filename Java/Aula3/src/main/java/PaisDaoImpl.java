
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisDaoImpl implements PaisDao{
    
    private static final String INSERT_PAIS = "INSERT INTO PAIS (ID, NOME, SIGLA) VALUES (?,?,?)";
    private static final String UPDATE_PAIS = "UPDATE PAIS SET NOME = ? SIGLA = ? WHERE ID = ?";
    private static final String DELETE_PAIS = "DELETE FROM PAIS WHERE ID = ?";
    private static final String LOAD_PAIS = "SELECT * FROM PAIS WHERE ID = ?";

    @Override
    public void insert(Pais t) {
        try (final PreparedStatement preparedStatement
                    = ConexaoUtils.getConection().prepareStatement(INSERT_PAIS)) {
                preparedStatement.setLong(1, t.getId());
                preparedStatement.setString(2, t.getNome());
                preparedStatement.setString(3, t.getSigla());
                preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
    }

    @Override
    public void update(Pais t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(UPDATE_PAIS)) {
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setString(2, t.getSigla());
            preparedStatement.setLong(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pais t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(DELETE_PAIS)) {
            preparedStatement.setLong(1, t.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Pais loadBy(Long id) {
        final Pais pais = new Pais();
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(LOAD_PAIS)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pais.setId(resultSet.getLong("ID"));
                    pais.setNome(resultSet.getString("NOME"));
                    pais.setSigla(resultSet.getString("SIGLA"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pais;
    }
    
}
