
package DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TestConnect {

    public static void main(String[] args) {
        selectRecordsFromDbUserTable();
    }

    private static void selectRecordsFromDbUserTable() {

        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from tb1";

        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

               // String student_name = rs.getString("MA_BAN_DOC");
                String nv = rs.getString("nv");
                //System.out.println("userid : " + student_name);
                System.out.println("tên : " + nv);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConnect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestConnect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestConnect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    
}
