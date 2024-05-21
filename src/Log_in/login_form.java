/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log_in;

import ADMIN.admin_dashboard;
import USERS.user_dashboard;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import config.PasswordHasher;
import config.Session;
import config.dbConnector;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

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
    Color Release = new Color(57,55,77);

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
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        forgotps = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        reg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        xps = new javax.swing.JLabel();
        nousn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(220, 242, 241));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Welcome back!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 50, 210, 41);

        user.setBackground(new java.awt.Color(242, 242, 242));
        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(57, 55, 77));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(95, 162, 253, 35);

        pass.setBackground(new java.awt.Color(242, 242, 242));
        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(95, 236, 253, 35);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 115, 122));
        jLabel2.setText("Lirum mipsum este la dirres tues jaer fella tesje.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 100, 245, 16);

        jPanel2.setBackground(new java.awt.Color(27, 55, 77));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_223PX.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(62, 62, 62)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel6)
                .addGap(121, 121, 121)
                .addComponent(jLabel7)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(450, 0, 450, 420);

        forgotps.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        forgotps.setForeground(new java.awt.Color(27, 55, 77));
        forgotps.setText("Forgot pasword?");
        forgotps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotpsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotpsMouseExited(evt);
            }
        });
        jPanel1.add(forgotps);
        forgotps.setBounds(261, 282, 87, 17);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(95, 211, 50, 16);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 55, 77));
        jLabel5.setText("Username");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(95, 137, 53, 16);

        jButton1.setBackground(new java.awt.Color(27, 55, 77));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOG IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(95, 306, 253, 35);

        reg.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        reg.setForeground(new java.awt.Color(27, 55, 77));
        reg.setText(" Sign up");
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
        reg.setBounds(270, 350, 60, 20);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Don't have an  account?");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(120, 350, 148, 20);

        xps.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        xps.setForeground(new java.awt.Color(255, 0, 0));
        xps.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(xps);
        xps.setBounds(180, 210, 170, 20);

        nousn.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        nousn.setForeground(new java.awt.Color(255, 0, 0));
        nousn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(nousn);
        nousn.setBounds(180, 140, 170, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
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
       
         if(user.getText().isEmpty() || pass.getText().equals("")){
             if(user.getText().isEmpty()){
                nousn.setText("Field Required");  
             }
             if(pass.getText().equals(""))
                xps.setText("Field Required"); 
        }
         else{
                    
                      if(loginAcc(user.getText(),password))
         {            
             if(!status.equals("Active")){            
                    log_Check lc = new log_Check();
                    lc.setVisible(true);
                    this.dispose();
         }          
            else{         
                if(type.equals("Admin")){                 
                      JOptionPane.showMessageDialog(null, "Log in successfully.");
                      admin_dashboard ads = new admin_dashboard();
                      
                      ads.setVisible(true);
                      this.dispose();                    
                }else if(type.equals("User")){                  
                       JOptionPane.showMessageDialog(null, "Log in successfully.");
                       user_dashboard uds = new  user_dashboard();

                       uds.setVisible(true);
                       this.dispose();                     
                 }
                else{
                        JOptionPane.showMessageDialog(null, "Account does not exist! ","Notice", JOptionPane.ERROR_MESSAGE);
                    }     
               }            
        }
       
           else{          
             nousn.setText("Invalid Username."); 
             xps.setText("Invalid Password.");
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
    private javax.swing.JLabel forgotps;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nousn;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel reg;
    private javax.swing.JTextField user;
    private javax.swing.JLabel xps;
    // End of variables declaration//GEN-END:variables
}
