package DLL;

import java.sql.*;
import java.text.ParseException;

/*import com.mysql.jdbc.Connection;*/
public class dbhelper {

    private String userName = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/notesdb?useSSL=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException sqlException) {
        System.out.println("Error: " + sqlException.getMessage());
        System.out.println("Error code: " + sqlException.getErrorCode());
    }

    public void showErrorMessage(NullPointerException nullPointerException) {
        System.out.println("Error: " + nullPointerException.getMessage());

    }

    public void showErrorMessage(ParseException parseException) {
        System.out.println("Error: " + parseException.getMessage());

    }

}
