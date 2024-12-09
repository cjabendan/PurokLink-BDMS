/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import Reports.Reports_Temp;
import config.PanelPrinter;
import config.Session;
import config.dbConnector;
import enhancer.NoBorderDialog;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
    public class User_Reports_View extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public User_Reports_View() {
        initComponents();
    
    }
    
   
    Color Red = new Color(255,0,0);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
      public static String email, usname;
      
      public String destination = "";
      File selectedFile;
      public String path;
      public String oldpath;
      
 

         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        houseAdd = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cancel3 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        addHouse = new javax.swing.JButton();
        purok = new javax.swing.JComboBox<>();
        address1 = new javax.swing.JTextField();
        hname = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        a12 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        update = new javax.swing.JButton();
        PRINT = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        i_rb1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        i_rt1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        i_s1 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        i_t1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        i_l1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        i_p1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        i_dt1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        i_n1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        houseAdd.setBackground(new java.awt.Color(255, 255, 255));
        houseAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        houseAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        houseAdd.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 480, 20));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(27, 57, 77));
        jLabel33.setText("Address");
        houseAdd.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 60, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(27, 57, 77));
        jLabel34.setText("Purok");
        houseAdd.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 70, 20));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(27, 57, 77));
        jLabel36.setText("Household");
        houseAdd.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 20));

        jPanel8.setBackground(new java.awt.Color(27, 57, 77));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel3.setBackground(new java.awt.Color(255, 0, 0));
        cancel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel3.setForeground(new java.awt.Color(255, 255, 255));
        cancel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel3.setBorder(null);
        cancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel3MouseExited(evt);
            }
        });
        cancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel3ActionPerformed(evt);
            }
        });
        jPanel8.add(cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 30, 30));

        jLabel37.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Register New Household");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        houseAdd.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        addHouse.setBackground(new java.awt.Color(27, 57, 77));
        addHouse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addHouse.setForeground(new java.awt.Color(255, 255, 255));
        addHouse.setText("Register");
        addHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouseActionPerformed(evt);
            }
        });
        houseAdd.add(addHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 30));

        purok.setBackground(new java.awt.Color(245, 246, 248));
        purok.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        purok.setForeground(new java.awt.Color(100, 115, 122));
        purok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Select", "Tambis", "Mahogany", "Guyabano", "Ipil-Ipil" }));
        purok.setBorder(null);
        purok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purokActionPerformed(evt);
            }
        });
        houseAdd.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 170, 24));

        address1.setBackground(new java.awt.Color(245, 246, 248));
        address1.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        address1.setForeground(new java.awt.Color(100, 115, 122));
        address1.setBorder(null);
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });
        houseAdd.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 230, 24));

        hname.setBackground(new java.awt.Color(245, 246, 248));
        hname.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        hname.setForeground(new java.awt.Color(100, 115, 122));
        hname.setBorder(null);
        hname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hnameActionPerformed(evt);
            }
        });
        houseAdd.add(hname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, 24));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 55, 77));
        jLabel31.setText(" Household cannot be edited nor be deleted once registered.");
        houseAdd.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, 20));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(27, 55, 77));
        jLabel35.setText("Note: ");
        houseAdd.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        a11.setForeground(new java.awt.Color(255, 0, 0));
        a11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a11.setText("*");
        houseAdd.add(a11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, 30));

        a12.setForeground(new java.awt.Color(255, 0, 0));
        a12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a12.setText("*");
        houseAdd.add(a12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 140, 30));

        a13.setForeground(new java.awt.Color(255, 0, 0));
        a13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a13.setText("*");
        houseAdd.add(a13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(27, 55, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel.setBackground(new java.awt.Color(27, 55, 77));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/undo-alt.png"))); // NOI18N
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
        jPanel6.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 33, 30));

        update.setBackground(new java.awt.Color(0, 102, 255));
        update.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UDPATE REPORT");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel6.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 140, 33));

        PRINT.setBackground(new java.awt.Color(27, 55, 77));
        PRINT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        PRINT.setForeground(new java.awt.Color(255, 255, 255));
        PRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file-download.png"))); // NOI18N
        PRINT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PRINTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PRINTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PRINTMouseExited(evt);
            }
        });
        PRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTActionPerformed(evt);
            }
        });
        jPanel6.add(PRINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 33, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Incident Report Form");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 55, 77));
        jLabel2.setText("INVOLVED PERSONS & SPECIFIC PARTICIPATION");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 220, 370, 50));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 55, 77));
        jLabel6.setText("TYPE OF INCIDENT");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 70, 150, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 55, 77));
        jLabel3.setText("INCLUSIVE DATE & TIME OF INCIDENT");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 70, 290, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 55, 77));
        jLabel5.setText("NARRATIVE DETAILS OF INCIDENT");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 330, 260, 50));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 55, 77)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("REPORTED BY");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 40));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 55, 77));
        jLabel9.setText("REPORT STATUS");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("REPORTED TO");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 40));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_rb1.setText("jLabel1");
        jPanel11.add(i_rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, 30));

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_rt1.setText("jLabel1");
        jPanel12.add(i_rt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 300, 30));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_s1.setText("jLabel1");
        jPanel13.add(i_s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 30));

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 300, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 340, 240));

        d1.setBackground(new java.awt.Color(244, 244, 244));
        d1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        d1.setForeground(new java.awt.Color(27, 57, 77));
        d1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info (2).png"))); // NOI18N
        d1.setText(" Describe the incident in detail, including all actions and exchanges that took place. Include all the physical, emotional, mental damges and etc....");
        jPanel3.add(d1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 790, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setText("EXACT LOCATION OF INCIDENT");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 140, 240, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_t1.setText("jLabel1");
        jPanel2.add(i_t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, 30));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_l1.setText("jLabel1");
        jPanel4.add(i_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 670, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 690, 30));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_p1.setText("jLabel1");
        i_p1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel5.add(i_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 50));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 690, 60));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_dt1.setText("jLabel1");
        jPanel7.add(i_dt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 390, 30));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_n1.setText("jLabel1");
        i_n1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel10.add(i_n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1040, 110));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1060, 120));

        id.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 100, 20));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 20, 1120, 520);

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseClicked

    }//GEN-LAST:event_cancel3MouseClicked

    private void cancel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseEntered

    }//GEN-LAST:event_cancel3MouseEntered

    private void cancel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseExited

    }//GEN-LAST:event_cancel3MouseExited

    private void cancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel3ActionPerformed

        Window window = SwingUtilities.getWindowAncestor(houseAdd);
        window.dispose();
    }//GEN-LAST:event_cancel3ActionPerformed

    private void addHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHouseActionPerformed

        Session sess = Session.getInstance();

        int userID = sess.getUid();

      
    }//GEN-LAST:event_addHouseActionPerformed

    private void purokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purokActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void hnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hnameActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        User_Reports au = new User_Reports();
        au.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_cancelActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

           User_Reports_Update ru = new User_Reports_Update(); 
           ru.id.setText(id.getText());
           ru.i_t.setText(i_t1.getText());
           ru.i_dt.setText(i_dt1.getText());
           ru.i_l.setText(i_l1.getText());
           ru.i_p.setText(i_p1.getText());
           ru.i_n.setText(i_n1.getText());
           ru.i_rb.setText(i_rb1.getText());
           ru.i_rt.setText(i_rt1.getText());
           ru.i_s.setSelectedItem(i_s1.getText());
           ru.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_updateActionPerformed

    private void PRINTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PRINTMouseClicked

    private void PRINTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PRINTMouseEntered

    private void PRINTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PRINTMouseExited

    private void PRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTActionPerformed
        
        Session sess = Session.getInstance();
        
        int userID = sess.getUid();
        
        Reports_Temp ru = new Reports_Temp();
       
        ru.i_t1.setText(i_t1.getText());
        ru.i_dt1.setText(i_dt1.getText());
        ru.i_l1.setText(i_l1.getText());
        ru.i_p1.setText(i_p1.getText());
        ru.i_n1.setText(i_n1.getText());
        ru.i_rb1.setText(i_rb1.getText());
        ru.i_rt1.setText(i_rt1.getText());
    
        PanelPrinter pPrint = new PanelPrinter(ru.page);
        pPrint.printPanel();
         
        JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

          logEvent(userID, "INCIDENT_REPORT_DOWNLOAD", "Incident Report ID: "+id.getText()+" is downloaded by user.");
    }//GEN-LAST:event_PRINTActionPerformed

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
            java.util.logging.Logger.getLogger(User_Reports_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Reports_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Reports_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Reports_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Reports_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton PRINT;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JLabel a13;
    private javax.swing.JButton addHouse;
    public javax.swing.JTextField address1;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel3;
    public javax.swing.JLabel d1;
    public javax.swing.JTextField hname;
    private javax.swing.JPanel houseAdd;
    public javax.swing.JLabel i_dt1;
    public javax.swing.JLabel i_l1;
    public javax.swing.JLabel i_n1;
    public javax.swing.JLabel i_p1;
    public javax.swing.JLabel i_rb1;
    public javax.swing.JLabel i_rt1;
    public javax.swing.JLabel i_s1;
    public javax.swing.JLabel i_t1;
    public javax.swing.JLabel id;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JComboBox<String> purok;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
