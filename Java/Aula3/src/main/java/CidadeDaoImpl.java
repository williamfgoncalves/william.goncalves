
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDaoImpl implements CidadeDao {

    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (ID, NOME, ESTADO) VALUES (?,?,?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ? ESTADO = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";

    @Override
    public void insert(Cidade t) {

        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(INSERT_CIDADE)) {
            preparedStatement.setLong(1, t.getId());
            preparedStatement.setString(2, t.getNome());
            preparedStatement.setLong(3, t.getIDEstado());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Cidade t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(UPDATE_CIDADE)) {
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setLong(2, t.getIDEstado());
            preparedStatement.setLong(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Cidade t) {
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(DELETE_CIDADE)) {
            preparedStatement.setLong(1, t.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Cidade loadBy(Long id) {
        final Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConexaoUtils.getConection().prepareStatement(LOAD_CIDADE)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    cidade.setId(resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                    cidade.setIDEstado(resultSet.getLong("ESTADO"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidade;
    }
}
