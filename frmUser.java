package GUI;

import java.sql.Connection
;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DBConnection.MySQLConnUtils;
import DBConnection.TestConnect;
import Main.frmMain;
import OBJ.Users;
import DAO.UserDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;


public class frmUser extends javax.swing.JFrame {


   UserDAO userDAO = new UserDAO();

    public frmUser() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý người dùng");
        loadData();
    }

    private DefaultTableModel dtm = new DefaultTableModel();

    private void loadData() {

        Connection dbConnection = null;
        Statement statement = null;
        
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã người dùng");
        dtm.addColumn("Tên đăng nhập");
        dtm.addColumn("Mật khẩu");
        dtm.addColumn("Email");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Vai trò");

        String selectTableSQL = "SELECT * from nguoidung";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String id = rs.getString("manguoidung");
                String ten = rs.getString("tendangnhap");
                String mk = rs.getString("matkhau");
                String email = rs.getString("email");
                String name = rs.getString("hoten");
                String vaitro = rs.getString("vaitro");

                Vector row = new Vector();
                row.addElement(id);
                row.addElement(ten);
                row.addElement(mk);
                row.addElement(email);
                row.addElement(name);
                row.addElement(vaitro);

                dtm.addRow(row);

            }
            tbl_data.setModel(dtm);

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

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBackground(new Color(255, 255, 255));
        txt_id = new javax.swing.JTextField();
        txt_user = new javax.swing.JTextField();
        txt_mk = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_role = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        cmd_them = new javax.swing.JButton();
        cmd_sua = new javax.swing.JButton();
        cmd_xoa = new javax.swing.JButton();
        cmd_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6 "
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel1.setBackground(new Color(189, 183, 107));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("QUẢN LÝ NGƯỜI DÙNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(167, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addGap(135))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(29, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new Color(238, 232, 170));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel3.setForeground(new Color(0, 0, 128));
        jLabel3.setText("THÔNG TIN NGƯỜI DÙNG");

        jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Mã người dùng");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 17));
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Tên đăng nhập");

        txt_id.setFont(new java.awt.Font("Times New Roman", 1, 18)); 

        txt_user.setFont(new java.awt.Font("Times New Roman", 1, 18)); 

        jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 17)); 
        jLabel6.setForeground(new Color(0, 0, 0));
        jLabel6.setText("Mật khẩu");
        
        jLabel8.setFont(new Font("Times New Roman", Font.BOLD, 17)); 
        jLabel8.setForeground(new Color(0, 0, 0));
        jLabel8.setText("Email");

        jLabel9.setFont(new Font("Times New Roman", Font.BOLD, 17)); 
        jLabel9.setForeground(new Color(0, 0, 0));
        jLabel9.setText("Họ tên");

        jLabel10.setFont(new Font("Times New Roman", Font.BOLD, 17)); 
        jLabel10.setForeground(new Color(0, 0, 0));
        jLabel10.setText("Vai trò");


        txt_id.setFont(new java.awt.Font("Times New Roman", 1, 18)); 

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_role))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_user, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_role, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGap(18, 18, 18))
        );


        
        

        cmd_them.setFont(new java.awt.Font("Times New Roman", 1, 18));
        cmd_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png")));
        cmd_them.setText("Thêm");
        cmd_them.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmd_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	  cmd_themActionPerformed(evt);
            }
        });

        cmd_sua.setFont(new java.awt.Font("Times New Roman", 1, 18));
        cmd_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png")));
        cmd_sua.setText("Sửa");
        cmd_sua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmd_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 cmd_suaActionPerformed(evt);
            }
        });

        cmd_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        cmd_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dele.png"))); 
        cmd_xoa.setText("Xóa");
        cmd_xoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmd_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 cmd_xoaActionPerformed(evt);
            }
        });

        cmd_exit.setFont(new java.awt.Font("Times New Roman", 1, 14));
        cmd_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png")));
        cmd_exit.setText("Exit");
        cmd_exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmd_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(107)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(cmd_xoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cmd_them, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(cmd_exit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cmd_sua, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(50, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(27)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(28)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(cmd_them, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(cmd_sua, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(cmd_xoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(cmd_exit, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    protected void cmd_editActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	frmMain frmmain;
    	frmmain = new frmMain();
    	frmmain.setVisible(true);
        this.dispose();
		
	}

	private void cmd_themActionPerformed(java.awt.event.ActionEvent evt) {
        if (txt_id.getText().equals("") || txt_user.getText().equals("") || txt_mk.getText().equals("")  || txt_email.getText().equals("")  || txt_name.getText().equals("")  || txt_role.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
                Users d = new Users();

                d.setId(txt_id.getText());
                d.setUsername(txt_user.getText());
                d.setPassword(txt_mk.getText());
                d.setEmail(txt_email.getText());
                d.setFullname(txt_name.getText());
                d.setRole(txt_role.getText());
               

                userDAO.insertUser(d);
                JOptionPane.showMessageDialog(this, "Thành công!");
                loadData();
                reset();
            } 
     
    }


    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        txt_id.setEnabled(false);
        txt_user.setEnabled(false);
        cmd_them.setEnabled(false);
        int row = tbl_data.getSelectedRow();
        String id = tbl_data.getValueAt(row, 0).toString();
        Users sv = new Users();
        sv = userDAO.FindByCode(id);
        txt_id.setText(id);
        txt_user.setText(sv.getUsername());
        txt_mk.setText(sv.getPassword());
        txt_email.setText(sv.getEmail());
        txt_name.setText(sv.getFullname());
        txt_role.setText(sv.getRole());
      

    }

    private void cmd_xoaActionPerformed(java.awt.event.ActionEvent evt) {
        Users sv = new Users();
        sv.setId(txt_id.getText());
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Xóa", 2);

        if (confirm == JOptionPane.YES_OPTION) {
            if (userDAO.deleteUser(sv)) {
                loadData();
                reset();
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công!");
                //txt_id.setEnabled(true);
                cmd_them.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu thất bại!");
            }
        } else {
            //txt_id.setEnabled(true);
            cmd_them.setEnabled(true);
            reset();
        }
    }//GEN-LAST:event_cmd_xoaActionPerformed

    private void cmd_suaActionPerformed(java.awt.event.ActionEvent evt) {
        Users nd = new Users();

        nd.setId(txt_id.getText());
        nd.setUsername(txt_user.getText());
        nd.setPassword(txt_mk.getText());
        nd.setEmail(txt_email.getText());
        nd.setFullname(txt_name.getText());
        nd.setRole(txt_role.getText());
        
        userDAO.updateUser(nd);
        JOptionPane.showMessageDialog(this, "Thành công!");
        loadData();
        reset();
    }

   
    public void reset() {
        txt_id.setEnabled(true);
       
        cmd_them.setEnabled(true);
        txt_id.setText("");
        txt_user.setText("");
        txt_mk.setText("");
        txt_email.setText("");
        txt_name.setText("");
        txt_role.setText("");
        
    }

  
    
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUser().setVisible(true);
            }
        });
    }

    private javax.swing.JButton cmd_exit;
    private javax.swing.JButton cmd_sua;
    private javax.swing.JButton cmd_them;
    private javax.swing.JButton cmd_xoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_user;
    private javax.swing.JTextField txt_mk;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_role;

}
