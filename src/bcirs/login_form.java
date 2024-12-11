/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcirs;

import ADMIN.admin_dashboard;
import Extra_Frames.Connection_Error;
import Extra_Frames.log_Check;
import USERS.user_dashboard;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import config.PasswordHasher;
import config.Session;
import config.dbConnector;
import enhancer.GradientPanel;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author SCC-COLLEGE
 */
public class login_form extends javax.swing.JFrame {

    /**
     * Creates new form login_form
     */
    public login_form() {
        initComponents();
        user.setBorder(new EmptyBorder(0,10,0,0));
        pass.setBorder(new EmptyBorder(0,10,0,0));
        
       
    }
    
     

    Color Red = new Color(255,0,0);
    Color Hover = new Color(0,102,255);
    Color Release = new Color(27,57,77);

    static String status;
    static String type;
    static String hspass; 
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_usn = '" + username + "' AND u_pass = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            
            if(resultSet.next()){
                
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                hspass =  resultSet.getString("u_pass");
                Session sess = Session.getInstance();
                sess.setUid(resultSet.getInt("u_id"));
                sess.setFname(resultSet.getString("u_fname"));
                sess.setLname(resultSet.getString("u_lname"));
                sess.setEmail(resultSet.getString("u_email"));
                sess.setUsername(resultSet.getString("u_usn"));
                sess.setType(resultSet.getString("u_type"));
                sess.setStatus(resultSet.getString("u_status"));
                
                return true;
            }else{
                return false;
            }
            
        }catch (SQLException ex) {
            return false;
        }

    }
    
      public String getUserId(String username) {
       
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String userId = null;

        try {
         
            String sql = "SELECT u_id FROM tbl_user WHERE u_usn = ?";
            pstmt = dbc.connect.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userId = rs.getString("u_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
       
        }
        return userId;
    }
    
    public void logEvent(String userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
        pstmt.setString(2, event);
        pstmt.setString(3, userId);
        pstmt.setString(4, description);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
    }
}
    
    
    class customTextField extends JTextField {

        public customTextField(String pathName) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(getClass().getResource(pathName)));
            setLayout(new BorderLayout());
            add(label, BorderLayout.EAST);

        }

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
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        ex = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        forgotps = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        reg = new javax.swing.JLabel();
        xps = new javax.swing.JLabel();
        nousn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        hide.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        hide.setForeground(new java.awt.Color(153, 153, 153));
        hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye-crossed.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        jPanel1.add(hide);
        hide.setBounds(440, 310, 40, 35);

        show.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        show.setForeground(new java.awt.Color(153, 153, 153));
        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel1.add(show);
        show.setBounds(440, 310, 40, 35);

        jLabel1.setBackground(new java.awt.Color(220, 242, 241));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purok Link");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 60, 580, 90);

        user.setBackground(new java.awt.Color(242, 242, 242));
        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(57, 55, 77));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(90, 220, 390, 35);

        pass.setBackground(new java.awt.Color(242, 242, 242));
        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(90, 310, 390, 35);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 115, 122));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage and organize purok information with us! ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 120, 580, 60);

        ex.setBackground(new java.awt.Color(27, 55, 77));
        ex.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ex.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 151, -1, -1));
        ex.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 272, -1, -1));

        cancel.setBackground(new java.awt.Color(27, 55, 77));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close (2).png"))); // NOI18N
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        ex.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 30, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo__1_-removebg-preview (1).png"))); // NOI18N
        ex.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 560));

        jPanel1.add(ex);
        ex.setBounds(580, 0, 590, 560);

        forgotps.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        forgotps.setForeground(new java.awt.Color(27, 55, 77));
        forgotps.setText("Forgot pasword?");
        forgotps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotpsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotpsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotpsMouseExited(evt);
            }
        });
        jPanel1.add(forgotps);
        forgotps.setBounds(350, 350, 130, 30);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 270, 90, 40);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 55, 77));
        jLabel5.setText("Username");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 180, 90, 40);

        jButton1.setBackground(new java.awt.Color(27, 55, 77));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOG IN");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 390, 390, 40);

        reg.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        reg.setForeground(new java.awt.Color(27, 55, 77));
        reg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reg.setText(" Sign up now");
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regMouseExited(evt);
            }
        });
        jPanel1.add(reg);
        reg.setBounds(210, 470, 140, 40);

        xps.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        xps.setForeground(new java.awt.Color(255, 0, 0));
        xps.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(xps);
        xps.setBounds(280, 280, 200, 30);

        nousn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        nousn.setForeground(new java.awt.Color(255, 0, 0));
        nousn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(nousn);
        nousn.setBounds(200, 190, 280, 30);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Don't have an  account?");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(90, 430, 390, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        nousn.setText("");
        xps.setText("");
        
        PasswordHasher pH = new PasswordHasher();       
        String password = pH.hashPassword(pass.getText());

        if (user.getText().isEmpty() || pass.getText().equals("")) {
            if (user.getText().isEmpty()) {
                nousn.setText("Field Required.");  
            }
            if (pass.getText().equals("")) {
                xps.setText("Field Required.");
            }
        } else {
            String username = user.getText();
            String userId = getUserId(username);
            String event;
            String description;

            if (loginAcc(username, password)) {
                if (!status.equals("Active")) {            
                    log_Check lc = new log_Check();
                    lc.setVisible(true);
                    this.dispose();
                    event = "LOGIN_ATTEMPT";
                    description = "Login successful but user status is not active";
                    logEvent(userId, event, description);
                } else {         
                    if (type.equals("Admin")) {                 
                        JOptionPane.showMessageDialog(null, "Log in successfully.");
                        admin_dashboard ads = new admin_dashboard();
                        ads.setVisible(true);
                        this.dispose();
                        event = "LOGIN_SUCCESS";
                        description = "Admin logged in successfully";
                        logEvent(userId, event, description);
                    } else if (type.equals("User")) {                  
                        JOptionPane.showMessageDialog(null, "Log in successfully.");
                        user_dashboard uds = new user_dashboard();
                        uds.setVisible(true);
                        this.dispose();
                        event = "LOGIN_SUCCESS";
                        description = "User logged in successfully";
                        logEvent(userId, event, description);
                    } else {
                        Connection_Error ce = new Connection_Error();
                        ce.setVisible(true);
                        this.dispose();
                        event = "LOGIN_ATTEMPT";
                        description = "Connection error";
                        logEvent(userId, event, description);
                    }     
                }            
            } else {          
                nousn.setText("Invalid Username or Password."); 
                event = "LOGIN_FAILURE";
                description = "Invalid username or password";
                logEvent(userId, event, description);
            }       
        }
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
       register_form regf = new register_form();
       
        regf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regMouseClicked

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void regMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseEntered
     reg.setForeground(Hover);
    }//GEN-LAST:event_regMouseEntered

    private void regMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseExited
     reg.setForeground(Release);
    }//GEN-LAST:event_regMouseExited

    private void forgotpsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpsMouseExited
        forgotps.setForeground(Release);
    }//GEN-LAST:event_forgotpsMouseExited

    private void forgotpsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpsMouseEntered
        forgotps.setForeground(Hover);
    }//GEN-LAST:event_forgotpsMouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
       jButton1.setBackground(Hover);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
       jButton1.setBackground(Release);
    }//GEN-LAST:event_jButton1MouseExited

    private void forgotpsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpsMouseClicked
        forgotpass_form fpf = new forgotpass_form();
        fpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgotpsMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    Color BlueBT = new Color(89,182,255);
    Color MainC = new Color(27,55,77);
    
    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
// Close the application
    System.exit(0);        
    }//GEN-LAST:event_cancelActionPerformed

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
      hide.setVisible(false);
      show.setVisible(true);
      pass.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMousePressed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        hide.setVisible(true);
        show.setVisible(false);
        pass.setEchoChar('\u25CF');
    }//GEN-LAST:event_showMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancel;
    private javax.swing.JPanel ex;
    private javax.swing.JLabel forgotps;
    private javax.swing.JLabel hide;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nousn;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel reg;
    private javax.swing.JLabel show;
    private javax.swing.JTextField user;
    private javax.swing.JLabel xps;
    // End of variables declaration//GEN-END:variables
}
