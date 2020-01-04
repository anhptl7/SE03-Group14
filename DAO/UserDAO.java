
package DAO;

import DBConnection.MySQLConnUtils;

import OBJ.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public boolean insertUser(Users d) {
        try {
            Connection conn = null;
            conn = MySQLConnUtils.getMySQLConnection();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO nguoidung(manguoidung,tendangnhap,matkhau,email,hoten,vaitro) VALUES (?,?,?,?,?,?)");
            statement.setString(1, d.getId());
            statement.setString(2, d.getUsername());
            statement.setString(3, d.getPassword());
            statement.setString(4, d.getEmail());
            statement.setString(5, d.getFullname());
            statement.setString(6, d.getRole());
            
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Users FindByCode(String id) {
        Users sv = new Users();
        Connection conn;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nguoidung WHERE manguoidung=?");
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                sv.setId(rs.getString("manguoidung"));
                sv.setUsername(rs.getString("tendangnhap"));
                sv.setPassword(rs.getString("matkhau"));
                sv.setEmail(rs.getString("email"));
                sv.setFullname(rs.getString("hoten"));
                sv.setRole(rs.getString("vaitro"));

                return sv;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }

    public boolean deleteUser(Users sv) {
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM nguoidung WHERE manguoidung = ?");
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

    public boolean updateUser(Users nd) {
        Connection conn = null;
        try {
            conn = DBConnection.MySQLConnUtils.getMySQLConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE nguoidung SET tendangnhap = ?, matkhau = ?, email = ?, hoten = ?, vaitro = ? WHERE manguoidung = ?");
           
            statement.setString(1, nd.getUsername());
            statement.setString(2, nd.getPassword());
            statement.setString(3, nd.getEmail());
            statement.setString(4, nd.getFullname());
            statement.setString(5, nd.getRole());
            statement.setString(6, nd.getId());
            statement.execute();
            return true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
