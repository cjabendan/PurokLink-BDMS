/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log_in;

import ADMIN.admin_dashboard;
import USERS.user_dashboard;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    }

    static String status;
    static String type;
    static String fname;
    static String lname;
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_usn = '" + username + "' AND u_pass = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            
            if(resultSet.next()){
                
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                fname = resultSet.getString("u_fname");
                lname = resultSet.getString("u_lname");
                 
                return true;
            }else{
                return false;
            }
            
        }catch (SQLException ex) {
            return false;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        reg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(220, 242, 241));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Welcome back!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 50, 210, 41);

        user.setForeground(new java.awt.Color(57, 55, 77));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(95, 162, 253, 35);

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

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 55, 77));
        jLabel3.setText("Forgot pasword?");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(261, 282, 87, 17);

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
        reg.setText("Sign up");
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
        });
        jPanel1.add(reg);
        reg.setBounds(270, 350, 50, 20);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Don't have an  account?");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(110, 350, 160, 20);

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

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
         if(loginAcc(user.getText(),pass.getText()))
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
                      ads.admin_name.setText(" "+""+fname);
                      ads.setVisible(true);
                      this.dispose();                    
                }else if(type.equals("User")){                  
                       JOptionPane.showMessageDialog(null, "Log in successfully.");
                       user_dashboard uds = new  user_dashboard();
                       uds.userName.setText(" "+""+fname);
                       uds.setVisible(true);
                       this.dispose();                     
                 }else{
                        JOptionPane.showMessageDialog(null, "Account does not exist.");
                    }     
               }            
        }else{          
            JOptionPane.showMessageDialog(null, "User does not exist!");
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
       register_form regf = new register_form();
       
        regf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regMouseClicked

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
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel reg;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
