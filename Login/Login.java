package Main;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmLogin;
	private JTextField username;
	private JPasswordField password;
	private frmMain frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("1");
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		frame = new frmMain();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setAlwaysOnTop(true);
		frmLogin.setBackground(new Color(240, 248, 255));
		frmLogin.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmLogin.getContentPane().setBackground(new Color(255, 250, 250));
		frmLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmLogin.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frmLogin.setTitle("Đăng nhập");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblusername = new JLabel("Tên đăng nhập");
		lblusername.setIcon(new ImageIcon(getClass().getResource("/Images\\tai xuong (2).jpg")));
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setForeground(new Color(0, 0, 128));
		lblusername.setBackground(new Color(240, 255, 240));
		lblusername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblusername.setBounds(48, 69, 124, 28);
		frmLogin.getContentPane().add(lblusername);
		
		JLabel lblpass = new JLabel(" Mật khẩu");
		lblpass.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass.setIcon(new ImageIcon(getClass().getResource("/Images\\img_228829 (2).png")));
		lblpass.setForeground(new Color(0, 0, 128));
		lblpass.setBackground(new Color(240, 255, 240));
		lblpass.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblpass.setBounds(48, 108, 124, 27);
		frmLogin.getContentPane().add(lblpass);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		username.setBounds(184, 69, 166, 27);
		frmLogin.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		password.setBounds(184, 108, 166, 27);
		frmLogin.getContentPane().add(password);
		
		JButton btnlogin = new JButton("Đăng nhập");
		btnlogin.setBackground(new Color(245, 222, 179));
		btnlogin.setForeground(new Color(0, 0, 128));
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText() == ""| password.getText() =="") {
					JOptionPane.showMessageDialog(frmLogin, "Lỗi thử lại",  "Thông báo",2);
				}
				
				else {
					java.sql.Connection con;
					PreparedStatement ps;
					try {
						con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/quanlyhieuthuoc","root","12345");
						ps = con.prepareStatement("Select * from nguoidung where tendangnhap=? and matkhau=?");
						ps.setString(1, username.getText());
						ps.setString(2, password.getText());
						ResultSet rs = ps.executeQuery();
						
						if(rs.next()) {
							//JOptionPane.showMessageDialog(frmLogin,"Thành công", "Thông báo", 1);
							frame.setVisible(true);
							frmLogin.dispose();
						} 
							else {
								JOptionPane.showMessageDialog(frmLogin,"Vui lòng nhập lại", "Thông báo", 2);
								username.setText("");
								password.setText("");
								username.requestFocus();
							}
						}
				 catch (SQLException e1) {
						Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,e1);
					}
				}
			}

		

		});
		btnlogin.setBounds(75, 173, 97, 27);
		frmLogin.getContentPane().add(btnlogin);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(0, 0, 128));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThot.setBackground(new Color(245, 222, 179));
		btnThot.setBounds(218, 173, 97, 27);
		frmLogin.getContentPane().add(btnThot);
	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	
		
	}

	
}
