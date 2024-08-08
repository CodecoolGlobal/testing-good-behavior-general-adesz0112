package Database;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.SQLException;

public class TestCleanUp {

    private DatabaseHelper dbHelper;

    public TestCleanUp() {
        String dbUrl = System.getenv("DATABASE_URL");
        String dbUser = System.getenv("DATABASE_USERNAME");
        String dbPassword = System.getenv("DATABASE_PASSWORD");

        try {
            dbHelper = new DatabaseHelper(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before("@cleanUpDatabase")
    public void cleanup() {
        try {
            dbHelper.clearTable("comments");
            dbHelper.clearTable("member_role");
            dbHelper.clearTable("member_roles");
            dbHelper.clearTable("members");
            dbHelper.clearTable("posts");
            dbHelper.clearTable("reports");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbHelper.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

