/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import bcirs.login_form;
import config.PasswordHasher;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
public class Admin_Security_Code extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public Admin_Security_Code() {
        initComponents();
        sc.setBorder(new EmptyBorder(0,10,0,0));
        cps.setBorder(new EmptyBorder(0,10,0,0));    
    }
  
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
   
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        accPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        secPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sessUsn = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        d4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        saveCode = new javax.swing.JButton();
        a1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        hide1 = new javax.swing.JLabel();
        show1 = new javax.swing.JLabel();
        sc = new javax.swing.JPasswordField();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        cps = new javax.swing.JPasswordField();
        jLabel24 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        d2 = new javax.swing.JLabel();
        d3 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        dot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        adm_nav.setBackground(new java.awt.Color(255, 255, 255));
        adm_nav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235), 2));
        adm_nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adm_nav.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 2, -1, 446));

        accPane.setBackground(new java.awt.Color(255, 255, 255));
        accPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout accPaneLayout = new javax.swing.GroupLayout(accPane);
        accPane.setLayout(accPaneLayout);
        accPaneLayout.setHorizontalGroup(
            accPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        accPaneLayout.setVerticalGroup(
            accPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(accPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        dashC.setBackground(new java.awt.Color(255, 255, 255));
        dashC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashCMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 55, 77));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (2).png"))); // NOI18N
        jLabel3.setText(" Account");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout dashCLayout = new javax.swing.GroupLayout(dashC);
        dashC.setLayout(dashCLayout);
        dashCLayout.setHorizontalGroup(
            dashCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        dashCLayout.setVerticalGroup(
            dashCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(dashC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 147, -1));

        viewC.setBackground(new java.awt.Color(255, 255, 255));
        viewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewCMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock (2).png"))); // NOI18N
        jLabel5.setText(" Security");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout viewCLayout = new javax.swing.GroupLayout(viewC);
        viewC.setLayout(viewCLayout);
        viewCLayout.setHorizontalGroup(
            viewCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        viewCLayout.setVerticalGroup(
            viewCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        secPane.setBackground(new java.awt.Color(27, 57, 77));
        secPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout secPaneLayout = new javax.swing.GroupLayout(secPane);
        secPane.setLayout(secPaneLayout);
        secPaneLayout.setHorizontalGroup(
            secPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        secPaneLayout.setVerticalGroup(
            secPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(secPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/angle-small-left.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        adm_nav.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Settings");
        adm_nav.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, 50));

        sessUsn.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        sessUsn.setForeground(new java.awt.Color(204, 204, 204));
        sessUsn.setText("@");
        adm_nav.add(sessUsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, -1));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password reset protection");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 40));

        d1.setBackground(new java.awt.Color(244, 244, 244));
        d1.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d1.setForeground(new java.awt.Color(204, 204, 204));
        d1.setText("Add extra security on your account.");
        jPanel3.add(d1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 40));

        adm_header.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 60));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 990, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 55, 77));
        jLabel17.setText("Two-factor authentication");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 50));

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        d.setForeground(new java.awt.Color(27, 57, 77));
        d.setText("requests, such as requesting to reset password.");
        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 490, 30));

        d4.setBackground(new java.awt.Color(244, 244, 244));
        d4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        d4.setForeground(new java.awt.Color(27, 57, 77));
        d4.setText("Use a security code that will be connected into your account to enable");
        jPanel2.add(d4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 490, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveCode.setBackground(new java.awt.Color(27, 55, 77));
        saveCode.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        saveCode.setForeground(new java.awt.Color(255, 255, 255));
        saveCode.setText("Save code");
        saveCode.setBorder(null);
        saveCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCodeActionPerformed(evt);
            }
        });
        jPanel5.add(saveCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 140, 30));

        a1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel5.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 140, 20));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(27, 55, 77));
        jLabel23.setText("Enter password");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 250, 40));

        hide1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        hide1.setForeground(new java.awt.Color(153, 153, 153));
        hide1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye-crossed.png"))); // NOI18N
        hide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hide1MousePressed(evt);
            }
        });
        jPanel5.add(hide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 87, -1, -1));

        show1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        show1.setForeground(new java.awt.Color(153, 153, 153));
        show1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye.png"))); // NOI18N
        show1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show1MouseClicked(evt);
            }
        });
        jPanel5.add(show1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 87, -1, -1));

        sc.setBackground(new java.awt.Color(242, 242, 242));
        sc.setBorder(null);
        jPanel5.add(sc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 410, 30));

        hide.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        hide.setForeground(new java.awt.Color(153, 153, 153));
        hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye-crossed.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        jPanel5.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 188, -1, -1));

        show.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        show.setForeground(new java.awt.Color(153, 153, 153));
        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel5.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 188, -1, -1));

        cps.setBackground(new java.awt.Color(242, 242, 242));
        cps.setBorder(null);
        jPanel5.add(cps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 410, 30));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(27, 55, 77));
        jLabel24.setText("Security Code");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 50));

        a2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel5.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 140, 20));

        d2.setBackground(new java.awt.Color(244, 244, 244));
        d2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        d2.setForeground(new java.awt.Color(27, 57, 77));
        d2.setText("Input your password to confirm its really you.");
        jPanel5.add(d2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 240, 30));

        d3.setBackground(new java.awt.Color(244, 244, 244));
        d3.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        d3.setForeground(new java.awt.Color(27, 57, 77));
        d3.setText("At least 6 and must contain numbers and letters.");
        jPanel5.add(d3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 40));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(27, 57, 77));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel5.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 30));

        dot.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dot.setForeground(new java.awt.Color(255, 0, 0));
        dot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 20, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 450, 280));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(190, 90, 610, 400);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secure Server-amico (2).png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(790, 230, 230, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseEntered
  
    }//GEN-LAST:event_accPaneMouseEntered

    private void accPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseExited

    }//GEN-LAST:event_accPaneMouseExited

    private void secPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseEntered

    private void secPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
        accPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        accPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashCMouseExited

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
       // secPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
      //  secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked
 
    }//GEN-LAST:event_viewCMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        accPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
          //secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
         // secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

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
               sessUsn.setText("@"+rs.getString("u_usn"));
               
                String code = rs.getString("u_code");
                if(code.equals("")){
                    dot.setText("•");
                }else{
                     dot.setText("");
                     saveCode.setEnabled(false);
                     saveCode.setText("Code already set");
                     cancel.setText("Back");
                     sc.setEnabled(false);
                     cps.setEnabled(false);
                }
           }
           
           }catch(SQLException ex){
                 System.out.println(""+ex);
         
        }
       }
    }//GEN-LAST:event_formWindowActivated

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        accPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked
    
    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Admin_Settings as = new Admin_Settings();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        admin_dashboard ads = new admin_dashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void saveCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCodeActionPerformed

        a1.setText("");
        a2.setText("");

        dbConnector dbc = new dbConnector();
        Session sess = Session.getInstance();
        
        int adminID = sess.getUid();
        PasswordHasher pH = new PasswordHasher();

        try {
            String query = "SELECT * FROM tbl_user WHERE u_id = '" + sess.getUid() + "'";
            ResultSet resultSet = dbc.getData(query);

            if (resultSet.next()) {
                String oldpass = resultSet.getString("u_pass");
                String cpass = pH.hashPassword(cps.getText());

                if (cps.getText().isEmpty() || sc.getText().isEmpty()) {
                    if (cps.getText().isEmpty()) {
                        a2.setText("Field required!");
                    }
                    if (sc.getText().isEmpty()) {
                        a1.setText("Field required!");
                    }
                } else if (!cpass.equals(oldpass)) {
                    a2.setText("Password is incorrect!");

                }else if(sc.getText().length() < 6){
                    a1.setText("At least 6 code");

                } else {
                    String code = pH.hashPassword(sc.getText());
                    dbc.updateData("UPDATE tbl_user SET u_code = '" + code + "' WHERE u_id = '" + sess.getUid() + "'");
                    
                    JOptionPane.showMessageDialog(null, "Security code added successfully!");
                    
                   logEvent(adminID, "ADMIN_ADDED_CODE", "Admin ID: "+adminID+" added security code:  "+ sc.getText()+".");
                    
                    Admin_Settings as = new Admin_Settings();
                    as.setVisible(true);
                    this.dispose();
                }
            }

            resultSet.close();  // Ensure the ResultSet is closed

        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }//GEN-LAST:event_saveCodeActionPerformed

     public void logEvent(int userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
        pstmt.setString(2, event);
        pstmt.setInt(3, userId);
        pstmt.setString(4, description);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        System.out.println("errors");
    }
}
    
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        Admin_Security_Password asp = new Admin_Security_Password();
        asp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        Admin_Security ru = new Admin_Security();
        ru.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        hide.setVisible(false);
        show.setVisible(true);
        cps.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMousePressed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        hide.setVisible(true);
        show.setVisible(false);
        cps.setEchoChar('\u25CF');
    }//GEN-LAST:event_showMouseClicked

    private void hide1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MousePressed
        hide1.setVisible(false);
        show1.setVisible(true);
        sc.setEchoChar((char) 0);
    }//GEN-LAST:event_hide1MousePressed

    private void show1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show1MouseClicked
        hide1.setVisible(true);
        show1.setVisible(false);
        sc.setEchoChar('\u25CF');
    }//GEN-LAST:event_show1MouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Security_Code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Security_Code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Security_Code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Security_Code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Security_Code().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JPanel accPane;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    public javax.swing.JButton cancel;
    private javax.swing.JPasswordField cps;
    public javax.swing.JLabel d;
    public javax.swing.JLabel d1;
    public javax.swing.JLabel d2;
    public javax.swing.JLabel d3;
    public javax.swing.JLabel d4;
    private javax.swing.JPanel dashC;
    private javax.swing.JLabel dot;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel hide1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton saveCode;
    private javax.swing.JPasswordField sc;
    private javax.swing.JPanel secPane;
    public javax.swing.JLabel sessUsn;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show1;
    private javax.swing.JPanel viewC;
    // End of variables declaration//GEN-END:variables
}
