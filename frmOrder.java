package GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import DAO.OrderDAO;
import DBConnection.MySQLConnUtils;
import DBConnection.TestConnect;
import Main.frmMain;
import OBJ.Order;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;


public class frmOrder extends javax.swing.JFrame {
	
	private int mahoadon, soluong,giaban_1;
	private String tenthuoc;

  
	OrderDAO orderDAO = new OrderDAO();

    public frmOrder() {
    	getContentPane().setBackground(new Color(250, 250, 210));
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Đơn hàng");
        //loadData();
    }

    private DefaultTableModel dtm = new DefaultTableModel();
    
    public void hienthiBanhang() throws ClassNotFoundException, SQLException {
		DefaultTableModel model3 = new DefaultTableModel();
		model3.addColumn("Mã hóa đơn");
		model3.addColumn("Tên thuốc");
		model3.addColumn("Số lượng");
		model3.addColumn("Giá");
		String sql = "SELECT * FROM thuoc WHERE mathuoc=?";
		PreparedStatement stmt = (PreparedStatement) MySQLConnUtils.getMySQLConnection().prepareStatement(sql);;
		stmt.setString(1, txt_math.getText());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			mahoadon = Integer.parseInt(txt_mahd.getText());
			tenthuoc = rs.getString("tenthuoc");
			String[] values = new String[3];
			soluong = Integer.parseInt(txt_sl.getText());
			int gia = rs.getInt("gia");
			giaban_1 = gia*soluong;
			values[0] = String.valueOf(mahoadon);
			values[1] = tenthuoc;
			values[2] = String.valueOf(soluong);
			values[3] = String.valueOf(giaban_1);			
			model3.addRow(values);
		}
		tbl_data.setModel(model3);
		
		String sqlInsert = "INSERT INTO inhoadon(MAHOADON,TENTHUOC,SOLUONG,THANHTIEN) " + " VALUES (?,?,?,?)";
		PreparedStatement stmt1 = (PreparedStatement) MySQLConnUtils.getMySQLConnection().prepareStatement(sqlInsert);
		stmt1.setInt(1, mahoadon );
		stmt1.setString(2, tenthuoc);
		stmt1.setInt(3, soluong);
		stmt1.setInt(4, giaban_1);
		stmt1.execute();
	}
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        txt_math = new javax.swing.JTextField();
        txt_sl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmd_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
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
        jLabel2.setText("ĐƠN HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(318, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addGap(282))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel2)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new Color(238, 232, 170));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Mã hóa đơn");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Mã thuốc");

        txt_mahd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txt_math.setFont(new java.awt.Font("Times New Roman", 1, 18));
        
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new Color(0, 0, 0));
        jLabel8.setText("Số lượng");
        txt_sl.setFont(new java.awt.Font("Times New Roman", 1, 18));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel5)
        					.addGap(53))
        				.addComponent(jLabel8)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
        			.addGap(21)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txt_math, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txt_mahd, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txt_sl, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(46)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_mahd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_math, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        				.addComponent(jLabel5))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_sl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8))
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        cmd_exit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmd_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        cmd_exit.setText("Exit");
        cmd_exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmd_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exitActionPerformed(evt);
            }
        });
        
        JButton btnNhp = new JButton("Nhập");
        btnNhp.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNhp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					try {
						btnActionPerformed(e);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
			
        });
        
        JButton btnInHan = new JButton("In hóa đơn");
        btnInHan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			btnInHanActionPerformed(e);
			}
        });
        btnInHan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(68)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(66)
        			.addComponent(btnNhp, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        			.addGap(183))
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(759, Short.MAX_VALUE)
        			.addComponent(cmd_exit, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(396, Short.MAX_VALUE)
        			.addComponent(btnInHan, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        			.addGap(354))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(32)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(106)
        					.addComponent(btnNhp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
        			.addGap(41)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnInHan, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addComponent(cmd_exit, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(39, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }
	protected void btnInHanActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Hoadon frame1 = new Hoadon();
			frame1.setVisible(true);
			this.setVisible(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
      
	}
	protected void btnActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
		hienthiBanhang();
	// TODO Auto-generated method stub
		/*Connection dbConnection = null;
        Statement statement = null;
       //Xóa hết các cột cũ
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã thuốc");
        dtm.addColumn("Tên thuốc");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Giá");
        
        String selectTableSQL = "SELECT * FROM thuoc WHERE mathuoc LIKE '%" + txt_math.getText() + "%'";
        try {
            dbConnection = MySQLConnUtils.getMySQLConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
            	String mathuoc = rs.getString("mathuoc");
                String tenthuoc = rs.getString("tenthuoc");
                //String price = rs.getString("gia");
                //String soluong = rs.getString("soluong");
                
                Vector row = new Vector();
                
                row.addElement(mathuoc);
                row.addElement(tenthuoc);
                //row.addElement(price);
                

                dtm.addRow(row);
              
            }
            tbl_data.setModel(dtm);

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

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
	*/
}
	
	protected void cmd_exitActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	frmMain frmmain = new frmMain();
    	frmmain.setVisible(true);
        this.dispose();
    	
	}

 
	private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {
		//txt_math.setEnabled(false);
        //txt_tenth.setEnabled(false);
        //cmd_them.setEnabled(false);
        int row = tbl_data.getSelectedRow();
        String math = tbl_data.getValueAt(row, 0).toString();
        
        Order sv = new Order();
        //sv = orderDAO.FindByCode(math);
        //txt_math.setText(sv.getMath());
        txt_mahd.setText(math);
        //txt_price.setText(String.valueOf(sv.getSl()));
        //txt_sl.setText(sv.getTenth());
        //
    }

   
    public void reset() {
        //txt_math.setEnabled(true);
       
        //cmd_them.setEnabled(true);
        txt_mahd.setText("");
        txt_math.setText("");
        //txt_price.setText("");
        txt_sl.setText(""); 
        //txt_tenkh.setText("");
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
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmOrder().setVisible(true);
            }
        });
    }

    private javax.swing.JButton cmd_exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
   // private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
   // private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_math;
    private javax.swing.JTextField txt_sl;
}
