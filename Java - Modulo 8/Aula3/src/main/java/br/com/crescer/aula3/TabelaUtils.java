package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

public class TabelaUtils {

    private static String DROP_TABLE = "DROP TABLE TESTE";
    private static String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";
    private static String INSERT_TESTE = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";

    public static void dropTable(Connection c) {
        try (final Statement statement = c.createStatement()) {
            statement.executeQuery(DROP_TABLE);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void createTable(Connection c) {
        try (final Statement statement = c.createStatement()) {
            statement.executeQuery(CREATE_TABLE);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void insertTable(Connection c) {
        try (final PreparedStatement preparedStatement = c.prepareStatement(INSERT_TESTE)){
            final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());
            
            for (Long id : list) {
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, String.format("%s pessoa de 999", id));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
