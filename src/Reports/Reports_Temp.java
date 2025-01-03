/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import certs.*;
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
public class Reports_Temp extends javax.swing.JFrame {

    /**
     * Creates new form PrintUserDets
     */
    public Reports_Temp() {
        initComponents();
         date();
    }

     private void date() {
       
        Date d = new Date();
    
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd,yyyy");
        String dt = sdf.format(d);
        date.setText(dt+"  at Poblacion  Ward II,  Minglanilla,  Cebu.");
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
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        i_t1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        i_dt1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        i_n1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        i_rt1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        i_l1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        i_rb1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        i_rb4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        i_p1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(27, 57, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Incident Report Form");
        page.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        date.setForeground(new java.awt.Color(27, 55, 77));
        date.setText("November 09, 2024 at Poblacion Ward II, MInglanilla Cebu");
        jPanel3.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 350, 20));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("NARRATIVE DETAILS OF INCIDENT");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 320, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_t1.setText("jLabel1");
        jPanel2.add(i_t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 55, 77));
        jLabel3.setText("INCLUSIVE DATE & TIME OF INCIDENT");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 290, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_dt1.setText("jLabel1");
        jPanel7.add(i_dt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_n1.setText("jLabel1");
        i_n1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel5.add(i_n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 50));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 440, 70));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 55, 77));
        jLabel5.setText("EXACT LOCATION OF INCIDENT");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 320, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_rt1.setText("jLabel1");
        jPanel6.add(i_rt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 210, 30));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 510, 10));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setText("TYPE OF INCIDENT");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_l1.setText("jLabel1");
        jPanel8.add(i_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 410, 30));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 440, 30));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 55, 77));
        jLabel9.setText("REPORTED BY");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 40));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_rb1.setText("jLabel1");
        jPanel10.add(i_rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_rb4.setText("jLabel1");
        jPanel11.add(i_rb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 220, 30));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 220, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("REPORTED TO");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 150, 40));

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 55, 77));
        jLabel12.setText("Issued on this");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 80, 20));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 55, 77));
        jLabel6.setText("INVOLVED PERSONS & SPECIFIC PARTICIPATION");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_p1.setText("jLabel1");
        jPanel9.add(i_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 440, 30));

        page.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 550));

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
            java.util.logging.Logger.getLogger(Reports_Temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports_Temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports_Temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports_Temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Reports_Temp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    public javax.swing.JLabel i_dt1;
    public javax.swing.JLabel i_l1;
    public javax.swing.JLabel i_n1;
    public javax.swing.JLabel i_p1;
    public javax.swing.JLabel i_rb1;
    public javax.swing.JLabel i_rb4;
    public javax.swing.JLabel i_rt1;
    public javax.swing.JLabel i_t1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JPanel page;
    // End of variables declaration//GEN-END:variables
}
