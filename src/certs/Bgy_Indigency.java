/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certs;

import ADMIN.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author chris
 */
public class Bgy_Indigency extends javax.swing.JFrame {

    /**
     * Creates new form PrintUserDets
     */
    public Bgy_Indigency() {
        initComponents();
         date();
    }

     private void date() {
       
        Date d = new Date();
    
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd,yyyy");
        String dt = sdf.format(d);
        date.setText(dt);
    }

    
        Timer t;
        SimpleDateFormat st;
    
    private void time(){

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tm = st.format(dt);              
            }
        });
        
        t.start();
        
    }
    
    
    public ImageIcon resizeImage(ImageIcon originalIcon, int targetWidth, int targetHeight) {
        Image originalImage = originalIcon.getImage();

        // Calculate the appropriate height based on the aspect ratio
        int newHeight = getHeightFromWidth(originalImage, targetWidth);

        // Create a new BufferedImage with the desired dimensions
        BufferedImage resizedImage = new BufferedImage(targetWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        // Get the graphics context of the resized image
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, targetWidth, newHeight, null);

        // Convert the resized BufferedImage back to an ImageIcon
        return new ImageIcon(resizedImage);
}

// Function to calculate height from width maintaining aspect ratio
    public int getHeightFromWidth(Image image, int desiredWidth) {
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        return (int) ((double) desiredWidth / originalWidth * originalHeight);
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
        page = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lable1 = new javax.swing.JLabel();
        purpose = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        lable8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        purok = new javax.swing.JLabel();
        lable10 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lable9 = new javax.swing.JLabel();
        lable11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lable12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        lable6 = new javax.swing.JLabel();
        lable = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        purok2 = new javax.swing.JLabel();
        lable3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(27, 57, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Untitled design (2).png"))); // NOI18N
        page.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 120, 110));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OFFICE OF BARANGAY WARD II");
        page.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 530, 60));

        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 260, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Untitled design (1).png"))); // NOI18N
        page.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 110));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Republic of the Philippines");
        page.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 530, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Region VII");
        page.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 530, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Province of Cebu, Minglanilla");
        page.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 530, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CERTIFICATE OF INDIGENCY");
        page.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 530, 70));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 430, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Punong Barangay");
        page.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 260, 40));

        lable1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable1.setText("TO WHOM IT MAY CONCERN;");
        page.add(lable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        purpose.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        purpose.setText("Resident issue of certifcation amd its purpose.");
        page.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, -1));

        fullname.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        fullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname.setText("RESIDENT'S FULL NAME");
        page.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 170, -1));

        status.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("civil status");
        page.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 50, -1));

        lable8.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable8.setText("THIS CERTIFICATION");
        page.add(lable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("is herby issued upon the request of the above-mentioned name for the");
        page.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 290, -1));

        purok.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        purok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purok.setText("Purok Name");
        page.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 70, -1));

        lable10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable10.setText("Minglanilla, Cebu. They are one of the members of the ultra-poor families residing in this barangay.");
        page.add(lable10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 410, -1));

        age.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        age.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        age.setText("age");
        page.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 40, -1));

        age1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        age1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        age1.setText("years of age,");
        page.add(age1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 60, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(" and permanently residung at Purok");
        page.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 150, -1));

        lable9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable9.setText("THIS IS TO CERTIFY");
        page.add(lable9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        lable11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable11.setText(", at Barangay");
        page.add(lable11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("that");
        page.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 20, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("the purpose of: ");
        page.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 70, -1));

        lable12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable12.setText("Pobalcion Ward II,");
        page.add(lable12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 160, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("this");
        page.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 20, 20));

        date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("date issued");
        page.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 130, 20));

        lable6.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable6.setText("ISSUED");
        page.add(lable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, 20));

        lable.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable.setText("Cebu.");
        page.add(lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 60, 20));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("at Purok");
        page.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 40, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(", Poblacion Ward II, ");
        page.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 90, 20));

        purok2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        purok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purok2.setText("Purok Name");
        page.add(purok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 60, 20));

        lable3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable3.setText("Minglanilla, ");
        page.add(lable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 60, 20));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Disclaimer: This document is prefilled for convenience purposes and is not considered official without the");
        page.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 450, 40));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(" barangay seal  and the signature/specimen of an authorized barangay official.");
        page.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 330, 40));

        jPanel1.add(page, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 530, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Bgy_Indigency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bgy_Indigency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bgy_Indigency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bgy_Indigency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bgy_Indigency().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel age;
    public javax.swing.JLabel age1;
    public javax.swing.JLabel date;
    public javax.swing.JLabel fullname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lable;
    public javax.swing.JLabel lable1;
    public javax.swing.JLabel lable10;
    public javax.swing.JLabel lable11;
    public javax.swing.JLabel lable12;
    public javax.swing.JLabel lable3;
    public javax.swing.JLabel lable6;
    public javax.swing.JLabel lable8;
    public javax.swing.JLabel lable9;
    public javax.swing.JPanel page;
    public javax.swing.JLabel purok;
    public javax.swing.JLabel purok2;
    public javax.swing.JLabel purpose;
    public javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
