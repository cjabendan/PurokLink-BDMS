/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import ADMIN.*;
import bcirs.login_form;
import config.PasswordHasher;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
public class User_Privacy extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public User_Privacy() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        accPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        privacyPane = new javax.swing.JPanel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        secPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sessUsn = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mainDk = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        d = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        privacyPane.setBackground(new java.awt.Color(27, 57, 77));
        privacyPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                privacyPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                privacyPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout privacyPaneLayout = new javax.swing.GroupLayout(privacyPane);
        privacyPane.setLayout(privacyPaneLayout);
        privacyPaneLayout.setHorizontalGroup(
            privacyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        privacyPaneLayout.setVerticalGroup(
            privacyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(privacyPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        purokC.setBackground(new java.awt.Color(255, 255, 255));
        purokC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purokCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purokCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purokCMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 55, 77));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/shield-check (1).png"))); // NOI18N
        jLabel6.setText(" Privacy");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout purokCLayout = new javax.swing.GroupLayout(purokC);
        purokC.setLayout(purokCLayout);
        purokCLayout.setHorizontalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purokCLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        purokCLayout.setVerticalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purokCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

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
        viewC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock (1).png"))); // NOI18N
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
        viewC.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 0, 85, 38));

        dot.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dot.setForeground(new java.awt.Color(255, 0, 0));
        viewC.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 30, 20));

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        secPane.setBackground(new java.awt.Color(255, 255, 255));
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

        sessUsn.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        sessUsn.setForeground(new java.awt.Color(204, 204, 204));
        sessUsn.setText("@");
        adm_nav.add(sessUsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Settings");
        adm_nav.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 450);

        mainDk.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 55, 77));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user-key.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Manage user roles and permissions.");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 30));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(27, 55, 77));
        jLabel23.setText("Access Control");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 30));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Learn more about ARQUSTAT's policy and its terms and conditions.");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(27, 55, 77));
        jLabel25.setText("Privacy Policy");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 30));

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(27, 55, 77));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info (2).png"))); // NOI18N
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 20, 30));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(27, 55, 77));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exchange.png"))); // NOI18N
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Allow sharing of additional information with ARQUSTAT's business partners.");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 30));

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(27, 55, 77));
        jLabel28.setText("Data Sharing");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 670, 190));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 55, 77));
        jLabel19.setText("Account Deletion");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 55, 77));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/heart-crack (2).png"))); // NOI18N
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 55, 77));
        jLabel18.setText("Deactivate Account");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Find out how can you can deactivate your account.");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 670, 70));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(27, 55, 77));
        jLabel24.setText("Additional Settings");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 40));

        mainDk.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainDkLayout = new javax.swing.GroupLayout(mainDk);
        mainDk.setLayout(mainDkLayout);
        mainDkLayout.setHorizontalGroup(
            mainDkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainDkLayout.setVerticalGroup(
            mainDkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainDkLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(mainDk);
        mainDk.setBounds(180, 60, 720, 360);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d.setForeground(new java.awt.Color(204, 204, 204));
        d.setText("Manage your information and account access.");
        jPanel3.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Privacy");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        adm_header.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 60));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 730, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseEntered
  
    }//GEN-LAST:event_accPaneMouseEntered

    private void accPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseExited

    }//GEN-LAST:event_accPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
        accPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        accPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashCMouseExited

    private void privacyPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_privacyPaneMouseEntered
     //   privacyPane.setBackground(Panecolor);
    }//GEN-LAST:event_privacyPaneMouseEntered

    private void privacyPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_privacyPaneMouseExited
     //   privacyPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_privacyPaneMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
       //  privacyPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
     //    privacyPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        accPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
 
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
      //  privacyPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
       //  privacyPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

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
        User_Settings as = new User_Settings();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void purokCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseClicked

    }//GEN-LAST:event_purokCMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        User_Security as = new User_Security();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        secPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked

    }//GEN-LAST:event_viewCMouseClicked

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        secPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void secPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseEntered

    private void secPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        user_dashboard ads = new user_dashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(User_Privacy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Privacy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Privacy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Privacy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new User_Privacy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accPane;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    public javax.swing.JLabel d;
    private javax.swing.JPanel dashC;
    private javax.swing.JLabel dot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JDesktopPane mainDk;
    private javax.swing.JPanel privacyPane;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel secPane;
    public javax.swing.JLabel sessUsn;
    private javax.swing.JPanel viewC;
    // End of variables declaration//GEN-END:variables
}
