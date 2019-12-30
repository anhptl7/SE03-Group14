
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "127.0.0.1";
        String dbName = "quanlyhieuthuoc";
        String userName = "root";
        String password = "12345";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
   
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+"?useUnicode=true&characterEncoding=utf-8";

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
