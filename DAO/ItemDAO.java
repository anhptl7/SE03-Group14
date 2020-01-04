
package DAO;

import DBConnection.MySQLConnUtils;

import OBJ.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAO {

    public boolean insertItem(Item d) {
        try {
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO thuoc(mathuoc,tenthuoc,soluong,gia,donvi) VALUES (?,?,?,?,?)");
            statement.setString(1, d.getId());
            statement.setString(2, d.getName());
            statement.setString(3, d.getQuantity());
            statement.setString(4, d.getPrice());
            statement.setString(5, d.getUnit());
            statement.execute();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Item FindByCode(String id) {
        Item sv = new Item();
        Connection conn;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM thuoc WHERE mathuoc=?");
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
            	sv.setId(rs.getString("mathuoc"));
	        	sv.setName(rs.getString("tenthuoc"));
	        	sv.setQuantity(rs.getString("soluong"));
	        	sv.setPrice(rs.getString("gia"));
	        	sv.setUnit(rs.getString("donvi"));

                return sv;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }

    public boolean deleteItem(Item sv) {
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM thuoc WHERE mathuoc = ?");
            statement.setString(1, sv.getId());
            statement.execute();

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateItem(Item sv) {
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE thuoc SET tenthuoc  = ?, soluong = ?, gia = ?, donvi = ?  WHERE mathuoc = ?");
         //   statement.setString(1, sv.getId());
            statement.setString(1, sv.getName());
            statement.setString(2, sv.getQuantity());
            statement.setString(3, sv.getPrice());
            statement.setString(4, sv.getUnit());
            statement.setString(5, sv.getId());
           
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
