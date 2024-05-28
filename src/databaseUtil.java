import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Connection to the database
public class databaseUtil{

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/books";
    private static final String USER = "root";
    private static final String PASSWORD = "GetMoney20!";

    public static Connection getconnection() throws SQLException{

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
