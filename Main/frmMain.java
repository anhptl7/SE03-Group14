
package Main;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

import GUI.frmItem;
import GUI.frmOrder;
import GUI.frmUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class frmMain extends javax.swing.JFrame {

    public frmMain() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý hiệu thuốc");
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        content = new javax.swing.JPanel();
        anh = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnnd = new javax.swing.JMenu();
        mnnd.setBackground(new Color(143, 188, 143));
        mnnd.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mmndMouseClicked(e);
        	}
        });
        mnsp = new javax.swing.JMenu();
        mnsp.setBackground(new Color(189, 183, 107));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/5-reasons-to-become-pharmacist.jpg"))); 

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anh)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anh)
        );

        mnnd.setIcon(new ImageIcon(getClass().getResource("/Images/images (1).png"))); 
        mnnd.setText("Quản lý người dùng ");
        mnnd.setToolTipText("");

        jMenuBar1.add(mnnd);

        mnsp.setIcon(new ImageIcon(getClass().getResource("/Images/thuoc.jpg"))); 
        mnsp.setText("Quản lý sản phẩm");
        mnsp.setToolTipText("");
        mnsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	mnspMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnsp);

        setJMenuBar(jMenuBar1);
        
        mnhoadon = new JMenu("Hóa đơn");
        mnhoadon.setBackground(new Color(189, 183, 107));
        mnhoadon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mnhoadonMouseClicked(e);
        	}
        });
     
        mnhoadon.setIcon(new ImageIcon(getClass().getResource("/Images/hd.png")));
        jMenuBar1.add(mnhoadon);
        mnhthoat = new javax.swing.JMenu();
        mnhthoat.setBackground(new Color(189, 183, 107));
        mnhthoat.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cmd_thoatMouseClicked(e);
        	}
        });
        
                mnhthoat.setIcon(new ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
                mnhthoat.setText("Thoát");
            
                jMenuBar1.add(mnhthoat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    protected void cmd_thoatMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
    	Login lg;
    	lg = new Login();
    	lg.setVisible(true);
        this.dispose();
	}

	protected void mnhoadonMouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
    	frmOrder frmod;
    	frmod = new frmOrder();
    	frmod.setVisible(true);
        this.dispose();
	}

	protected void mmndMouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
    	frmUser frmnd;
    	frmnd = new frmUser();
    	frmnd.setVisible(true);
        this.dispose();
		
	}


    private void mnspMouseClicked(java.awt.event.MouseEvent evt) {
        frmItem frmit;
        frmit = new frmItem();
        frmit.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anh;
    private javax.swing.JMenu mnhthoat;
    private javax.swing.JPanel content;
    private javax.swing.JMenu mnnd;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnsp;
    private JMenu mnhoadon;
    // End of variables declaration//GEN-END:variables
}
