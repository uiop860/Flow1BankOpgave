package bank.main;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {


    public static java.sql.Connection con = null;

    public static void setup() throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "bank";
        String pw = "bank123";
        try {
            con = DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
