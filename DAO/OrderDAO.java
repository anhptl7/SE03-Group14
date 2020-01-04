
package DAO;

import DBConnection.MySQLConnUtils;

import OBJ.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO {

    

    public boolean deleteOrder(Order sv) {
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM inhoadon WHERE mahoadon = ?");
            statement.setInt(1, sv.getMahoadon());
            statement.execute();

            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
	/*
	 * public boolean updateOrder(Order sv) { Connection conn = null; try { conn =
	 * MySQLConnUtils.getMySQLConnection(); PreparedStatement statement = conn.
	 * prepareStatement("UPDATE inhoadon SET MAHOADON = ?, TENTHUOC = ?, SOLUONG = ?, THANHTIEN = ? , WHERE MAHOADON = ?"
	 * ); statement.setString(1, sv.getMath()); statement.setString(2,
	 * sv.getTenth()); statement.setDouble(3, sv.getPrice()); statement.setInt(4,
	 * sv.getSl()); statement.setString(5, sv.getTenkh());
	 * 
	 * statement.execute(); return true;
	 * 
	 * } catch (ClassNotFoundException ex) {
	 * Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex); }
	 * catch (SQLException ex) {
	 * Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex); }
	 * return false; }
	 */

}