/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import bcirs.login_form;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC-COLLEGE
 */
public class Doc_Payment extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public Doc_Payment() {
        initComponents();
        roundUPanel();
     
    }

    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
  
     private void roundUPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 680, 150);
       
    
  }
  
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        req = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 87, 228));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(124, 124, 124));
        jLabel2.setText("Amount Due:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 30));

        username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        username.setForeground(new java.awt.Color(0, 87, 228));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("account name");
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pay with GCash as");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 40));

        amount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(0, 87, 228));
        amount.setText("PHP AMOUNT");
        jPanel3.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(124, 124, 124));
        jLabel6.setText("___________________________");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 280, 40));

        req.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        req.setForeground(new java.awt.Color(255, 255, 255));
        req.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        req.setText("PAY NOW");
        req.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reqMouseClicked(evt);
            }
        });
        jPanel3.add(req, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 300, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(124, 124, 124));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/u_default/image_2024-06-22_201821340.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 340, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 340, 230));

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 159, 900, 260));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/u_default/image_2024-06-22_201215388 (3).png"))); // NOI18N
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 160, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/u_default/image_2024-06-22_200623612.png"))); // NOI18N
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 280, 80));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 0, 900, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
           try{
            dbConnector dbc = new dbConnector();
           ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'");
           
           if(rs.next()){
               int id = sess.getUid();
               String firstName = rs.getString("u_fname"); 
                username.setText(rs.getString("u_fname") + rs.getString("u_lname"));
                
           }
           
           }catch(SQLException ex){
                 System.out.println(""+ex);
         
        }
                     
       }
    }//GEN-LAST:event_formWindowActivated

    private void reqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reqMouseClicked
       
       
     JOptionPane.showMessageDialog(null, "Request added successfully!");
     User_Reports ur = new User_Reports();
     ur.setVisible(true);
     this.dispose();
        
        
    }//GEN-LAST:event_reqMouseClicked

    
      public void logEvent(int userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
        pstmt.setString(2, event);
        pstmt.setInt(3, userId);
        pstmt.setString(4, description);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
       
    }
    
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doc_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doc_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doc_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doc_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doc_Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel amount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel req;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}