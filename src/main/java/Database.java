import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {


    public static java.sql.Connection con = null;

    public static void setup() throws SQLException {
        String url = "jdbc:mysql://localhost/";
        String user = "java";
        String pw = "bank123";
        try {
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connection succeeded!");
        } catch (SQLException e) {
            System.out.println("Could not connect.");
            e.printStackTrace();
        }
    }
}