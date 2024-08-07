package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    private Connection connection;

    public DatabaseHelper(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void clearTable(String tableName) throws SQLException {
        String sql = "TRUNCATE TABLE " + tableName + " CASCADE";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }


    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
