/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import bcirs.login_form;
import certs.Bgy_Clearance;
import certs.Bgy_Indigency;
import certs.Bgy_Residency;
import certs.Bgy_Senior;
import certs.Bgy_Solo_parent;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.PanelPrinter;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import enhancer.CenterCellRenderer;
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Christian James Abendan
 */
public class Admin_Barangay extends javax.swing.JFrame {

    
    DefaultListModel listModel = new DefaultListModel();
   
    
    public Admin_Barangay() {
        initComponents();
        barangayPanel();
        countDis();
        displayData();
        searchField.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(Color.GRAY), // Optional: if you want a line border
        BorderFactory.createEmptyBorder(0, 10, 0, 0) ));
        resname.setBorder(new EmptyBorder(0, 10, 0, 0));
        purpose.setBorder(new EmptyBorder(0, 10, 0, 0));
    }
    
     private void barangayPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 940, 120);
        barangayPanel.setLayout(null); 
        barangayPanel.add(rounded);
        barangayPanel.repaint();
        barangayPanel.revalidate();
 
  }
  private void countDis() {
    try {
        dbConnector dbc = new dbConnector();

        String query = "SELECT " +
                       "(SELECT COUNT(*) FROM tbl_household) AS total_household_count, " +
                       "(SELECT COUNT(*) FROM tbl_residents WHERE r_sex = 'Male' AND r_status = 'Active') AS total_male, " +
                       "(SELECT COUNT(*) FROM tbl_residents WHERE r_sex = 'Female' AND r_status = 'Active') AS total_female, " +
                       "(SELECT COUNT(*) FROM tbl_residents WHERE r_status = 'Archived') AS total_archived, " +
                       "(SELECT COUNT(*) FROM tbl_reports WHERE inc_status = 'Open') AS total_reps";

        ResultSet rs = dbc.getData(query);

        if (rs.next()) {


            int totalHousehold = rs.getInt("total_household_count");
            int totalMale = rs.getInt("total_male");
            int totalFemale = rs.getInt("total_female");
            int totalArchived = rs.getInt("total_archived");
            int totalReps = rs.getInt("total_reps");
            
            
           DecimalFormat formatter = new DecimalFormat("#,###");

            // Set text fields with formatted values
            ttl_household.setText(formatter.format(totalHousehold));
            male.setText(formatter.format(totalMale));
            fem.setText(formatter.format(totalFemale));
            arch.setText(formatter.format(totalArchived));
            reps.setText(formatter.format(totalReps));
            populationCount.setText(formatter.format(totalMale + totalFemale));
       
            
        }

        rs.close(); // Close the result set
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

  
    
    
        
   public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT r.r_id, r.r_fname, r.r_lname, "
                     + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                     + "r.r_sex, h.h_name "
                     + "FROM tbl_residents r "
                     + "JOIN tbl_household h ON r.h_id = h.h_id "
                     + "WHERE r.r_status = 'Active' "
                     + "ORDER BY r.r_id DESC";
        ResultSet rs = dbc.getData(query);
        userTbl.setModel(DbUtils.resultSetToTableModel(rs));

        JTableHeader th = userTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc0 = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
        TableColumn tc4 = tcm.getColumn(4);
        TableColumn tc5 = tcm.getColumn(5);

        tc0.setHeaderValue("ID");
        tc1.setHeaderValue("First Name");
        tc2.setHeaderValue("Last Name");
        tc3.setHeaderValue("Age");
        tc4.setHeaderValue("Sex");
        tc5.setHeaderValue("Household");
        
           CenterCellRenderer centerRenderer = new CenterCellRenderer();
            for (int i = 0; i < tcm.getColumnCount(); i++) {
                tcm.getColumn(i).setCellRenderer(centerRenderer);
            }


        th.setDefaultRenderer(new CustomHeaderRenderer());
        th.repaint();

        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
    
          public ImageIcon resizeImage(ImageIcon originalIcon, int targetWidth, int targetHeight) {
        Image originalImage = originalIcon.getImage();

      
        int newHeight = getHeightFromWidth(originalImage, targetWidth);

       
        BufferedImage resizedImage = new BufferedImage(targetWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

     
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, targetWidth, newHeight, null);

        
        return new ImageIcon(resizedImage);
}


    public int getHeightFromWidth(Image image, int desiredWidth) {
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        return (int) ((double) desiredWidth / originalWidth * originalHeight);
    }

   public void populateHouseholdComboBox(JComboBox<String> householdComboBox) {
    try {
        dbConnector dbc = new dbConnector();
        ResultSet rsHousehold = dbc.getData("SELECT h_name FROM tbl_household");

        Vector<String> householdNames = new Vector<>();
        householdNames.add("Select household");

        while (rsHousehold.next()) {
            householdNames.add(rsHousehold.getString("h_name"));
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(householdNames);
        householdComboBox.setModel(model);

        rsHousehold.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
            public void setDateAutomatically(Bgy_Solo_parent bsp) {
            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Format the day of the month
            int dayOfMonth = currentDate.getDayOfMonth();
            String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
            String dayString = dayOfMonth + dayOfMonthSuffix;

            // Format the month
            String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            // Format the year
            int year = currentDate.getYear();

            // Combine them into the desired format
            String formattedDate = dayString + " day of " + month + " " + year;

            // Set the date text field
            bsp.date.setText(formattedDate);
        }

        private String getDayOfMonthSuffix(final int day) {
            if (day >= 11 && day <= 13) {
                return "th";
            }
            switch (day % 10) {
                case 1: return "st";
                case 2: return "nd";
                case 3: return "rd";
                default: return "th";
            }
        }

        public void setDateAutomatically1(Bgy_Senior bs) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bs.date.setText(formattedDate);
       }

        public void setDateAutomatically2(Bgy_Clearance bc) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bc.date.setText(formattedDate);
       }
        
           public void setDateAutomatically3(Bgy_Indigency bi) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bi.date.setText(formattedDate);
       }

          public void setDateAutomatically4(Bgy_Residency br) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           br.date.setText(formattedDate);
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

        popUp = new javax.swing.JPopupMenu();
        view = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        viewPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cancel1 = new javax.swing.JButton();
        household = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        ocu = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        stats1 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        purok = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        gendoc = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        cancel2 = new javax.swing.JButton();
        print1 = new javax.swing.JButton();
        docs = new javax.swing.JComboBox<>();
        purpose = new javax.swing.JTextField();
        a2 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        resname = new javax.swing.JTextField();
        download = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        cancel3 = new javax.swing.JButton();
        print2 = new javax.swing.JButton();
        dl = new javax.swing.JComboBox<>();
        a3 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        download1 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        cancel4 = new javax.swing.JButton();
        print3 = new javax.swing.JButton();
        dl1 = new javax.swing.JComboBox<>();
        a5 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dashPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        viewPane = new javax.swing.JPanel();
        purokPane = new javax.swing.JPanel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        logoff = new javax.swing.JPanel();
        logoffbg = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logsPane = new javax.swing.JPanel();
        settingsBg = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        settingsPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barangayPanel = new javax.swing.JPanel();
        populationCount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        housePanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ttl_household = new javax.swing.JLabel();
        housePanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        male = new javax.swing.JLabel();
        housePanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fem = new javax.swing.JLabel();
        housePanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        fem1 = new javax.swing.JLabel();
        housePanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        reps = new javax.swing.JLabel();
        housePanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        fem3 = new javax.swing.JLabel();
        housePanel6 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        arch = new javax.swing.JLabel();
        housePanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        fem4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        sa1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        view.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye (1).png"))); // NOI18N
        view.setText(" View Data");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        popUp.add(view);

        editItem.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        editItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pen-circle (1).png"))); // NOI18N
        editItem.setText(" Edit Data");
        editItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemActionPerformed(evt);
            }
        });
        popUp.add(editItem);

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        viewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        viewPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 10));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 57, 77));
        jLabel15.setText("Name:");
        viewPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 20));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setText("Address:");
        viewPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(27, 57, 77));
        jLabel22.setText("Resident ID:");
        viewPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(27, 57, 77));
        id.setText("Id number");
        viewPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, 30));

        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        imagePanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        viewPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 170));

        jPanel7.setBackground(new java.awt.Color(27, 57, 77));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" View Resident Details");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        cancel1.setBackground(new java.awt.Color(255, 0, 0));
        cancel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel1.setForeground(new java.awt.Color(255, 255, 255));
        cancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel1.setBorder(null);
        cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel1MouseExited(evt);
            }
        });
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        jPanel7.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        viewPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        household.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        household.setForeground(new java.awt.Color(27, 57, 77));
        household.setText("house id");
        viewPanel.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(27, 57, 77));
        jLabel24.setText("Purok:");
        viewPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(27, 57, 77));
        jLabel25.setText("Civil Status:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        stats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats.setForeground(new java.awt.Color(27, 57, 77));
        stats.setText("Occupation:");
        jPanel5.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        ocu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ocu.setForeground(new java.awt.Color(27, 57, 77));
        ocu.setText("ocu");
        jPanel5.add(ocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, 20));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(27, 57, 77));
        jLabel26.setText("Age:");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 20));

        sex.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sex.setForeground(new java.awt.Color(27, 57, 77));
        sex.setText("sex");
        jPanel5.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, 20));

        dob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(27, 57, 77));
        dob.setText("User ID:");
        jPanel5.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 20));

        fullname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fullname.setForeground(new java.awt.Color(27, 57, 77));
        fullname.setText("User ID:");
        jPanel5.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 20));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(27, 57, 77));
        jLabel29.setText("Date of Birth:");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        age.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(27, 57, 77));
        age.setText("age");
        jPanel5.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(27, 57, 77));
        jLabel30.setText("Sex:");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, 20));

        address.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(27, 57, 77));
        address.setText("User ID:");
        jPanel5.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 20));

        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(27, 57, 77));
        status.setText("User ID:");
        jPanel5.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        stats1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats1.setForeground(new java.awt.Color(27, 57, 77));
        stats1.setText("Religion:");
        jPanel5.add(stats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 20));

        reg.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reg.setForeground(new java.awt.Color(27, 57, 77));
        reg.setText("reg");
        jPanel5.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, 20));

        viewPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 350, 170));

        type1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type1.setForeground(new java.awt.Color(27, 57, 77));
        type1.setText("User ID:");
        viewPanel.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, 20));

        purok.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        purok.setForeground(new java.awt.Color(27, 57, 77));
        purok.setText("Purok");
        viewPanel.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 57, 77));
        jLabel31.setText("House No:");
        viewPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 30));

        print.setBackground(new java.awt.Color(27, 57, 77));
        print.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Generate Document");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        viewPanel.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 150, 30));

        gendoc.setBackground(new java.awt.Color(255, 255, 255));
        gendoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        gendoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gendoc.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 380, 10));

        jPanel10.setBackground(new java.awt.Color(27, 57, 77));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Generate Document");
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

        cancel2.setBackground(new java.awt.Color(255, 0, 0));
        cancel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel2.setForeground(new java.awt.Color(255, 255, 255));
        cancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel2.setBorder(null);
        cancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel2MouseExited(evt);
            }
        });
        cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel2ActionPerformed(evt);
            }
        });
        jPanel10.add(cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        gendoc.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 50));

        print1.setBackground(new java.awt.Color(27, 57, 77));
        print1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print1.setForeground(new java.awt.Color(255, 255, 255));
        print1.setText("GENERATE");
        print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print1ActionPerformed(evt);
            }
        });
        gendoc.add(print1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 110, 30));

        docs.setBackground(new java.awt.Color(245, 246, 248));
        docs.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        docs.setForeground(new java.awt.Color(27, 57, 77));
        docs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "Barangay Clearance", "Barangay Residency", "Certifcate of Indigency", "Certificate of Solo Parent", "Certificate of Senior Citizen" }));
        docs.setBorder(null);
        docs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docsActionPerformed(evt);
            }
        });
        gendoc.add(docs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 30));

        purpose.setBackground(new java.awt.Color(245, 246, 248));
        purpose.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        purpose.setForeground(new java.awt.Color(100, 115, 122));
        purpose.setBorder(null);
        purpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purposeActionPerformed(evt);
            }
        });
        gendoc.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 30));

        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a2.setText("*");
        gendoc.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 110, 30));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(27, 57, 77));
        jLabel34.setText("Document");
        gendoc.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 70, 30));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(27, 57, 77));
        jLabel37.setText("Issued to:");
        gendoc.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 40));

        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a1.setText("*");
        gendoc.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 170, 40));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(27, 57, 77));
        jLabel38.setText("Purpose");
        gendoc.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 40));

        resname.setBackground(new java.awt.Color(245, 246, 248));
        resname.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        resname.setForeground(new java.awt.Color(27, 57, 77));
        resname.setBorder(null);
        resname.setEnabled(false);
        resname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resnameActionPerformed(evt);
            }
        });
        gendoc.add(resname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 320, 30));

        download.setBackground(new java.awt.Color(255, 255, 255));
        download.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        download.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        download.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 380, 10));

        jPanel11.setBackground(new java.awt.Color(27, 57, 77));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Download Residents Data");
        jPanel11.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

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
        jPanel11.add(cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        download.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 50));

        print2.setBackground(new java.awt.Color(27, 57, 77));
        print2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print2.setForeground(new java.awt.Color(255, 255, 255));
        print2.setText("GENERATE");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });
        download.add(print2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 30));

        dl.setBackground(new java.awt.Color(245, 246, 248));
        dl.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        dl.setForeground(new java.awt.Color(27, 57, 77));
        dl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "All Residents", "Tambis Residents", "Mahogany Residents", "Guyabano Residents", "Ipil-ipil Residents", "Minsinitas Residents", "Tugas Residents", "Lubi Residents" }));
        dl.setBorder(null);
        dl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlActionPerformed(evt);
            }
        });
        download.add(dl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, 30));

        a3.setForeground(new java.awt.Color(255, 0, 0));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a3.setText("*");
        download.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 30, 30));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(27, 57, 77));
        jLabel43.setText("Select data to download");
        download.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));

        a4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 0, 0));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a4.setText("*");
        download.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, 20));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(27, 57, 77));
        jLabel32.setText("File name:");
        download.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 20));
        download.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 320, 30));

        download1.setBackground(new java.awt.Color(255, 255, 255));
        download1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        download1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        download1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 380, 10));

        jPanel12.setBackground(new java.awt.Color(27, 57, 77));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Download Residents Data");
        jPanel12.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

        cancel4.setBackground(new java.awt.Color(255, 0, 0));
        cancel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel4.setForeground(new java.awt.Color(255, 255, 255));
        cancel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel4.setBorder(null);
        cancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel4MouseExited(evt);
            }
        });
        cancel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel4ActionPerformed(evt);
            }
        });
        jPanel12.add(cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        download1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 50));

        print3.setBackground(new java.awt.Color(27, 57, 77));
        print3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print3.setForeground(new java.awt.Color(255, 255, 255));
        print3.setText("GENERATE");
        print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print3ActionPerformed(evt);
            }
        });
        download1.add(print3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 30));

        dl1.setBackground(new java.awt.Color(245, 246, 248));
        dl1.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        dl1.setForeground(new java.awt.Color(27, 57, 77));
        dl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "All Residents", "Tambis Residents", "Mahogany Residents", "Guyabano Residents", "Ipil-ipil Residents", "Minsinitas Residents", "Tugas Residents", "Lubi Residents" }));
        dl1.setBorder(null);
        dl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dl1ActionPerformed(evt);
            }
        });
        download1.add(dl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, 30));

        a5.setForeground(new java.awt.Color(255, 0, 0));
        a5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a5.setText("*");
        download1.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 30, 30));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(27, 57, 77));
        jLabel46.setText("Select data to download");
        download1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));

        a6.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a6.setForeground(new java.awt.Color(255, 0, 0));
        a6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a6.setText("*");
        download1.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, 20));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(27, 57, 77));
        jLabel47.setText("File name:");
        download1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 20));
        download1.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 320, 30));

        download.add(download1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        dashPane.setBackground(new java.awt.Color(255, 255, 255));
        dashPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout dashPaneLayout = new javax.swing.GroupLayout(dashPane);
        dashPane.setLayout(dashPaneLayout);
        dashPaneLayout.setHorizontalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        dashPaneLayout.setVerticalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(dashPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dash_F.png"))); // NOI18N
        jLabel3.setText(" Dashboard");
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
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png"))); // NOI18N
        jLabel5.setText(" Users");
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

        viewPane.setBackground(new java.awt.Color(255, 255, 255));
        viewPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout viewPaneLayout = new javax.swing.GroupLayout(viewPane);
        viewPane.setLayout(viewPaneLayout);
        viewPaneLayout.setHorizontalGroup(
            viewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        viewPaneLayout.setVerticalGroup(
            viewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(viewPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        purokPane.setBackground(new java.awt.Color(27, 57, 77));
        purokPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purokPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purokPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout purokPaneLayout = new javax.swing.GroupLayout(purokPane);
        purokPane.setLayout(purokPaneLayout);
        purokPaneLayout.setHorizontalGroup(
            purokPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        purokPaneLayout.setVerticalGroup(
            purokPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(purokPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

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
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house-building.png"))); // NOI18N
        jLabel6.setText(" Barangay");
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

        logoff.setBackground(new java.awt.Color(255, 255, 255));
        logoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoffMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffLayout = new javax.swing.GroupLayout(logoff);
        logoff.setLayout(logoffLayout);
        logoffLayout.setHorizontalGroup(
            logoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        logoffLayout.setVerticalGroup(
            logoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(logoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        logoffbg.setBackground(new java.awt.Color(255, 255, 255));
        logoffbg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoffbgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoffbgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoffbgMouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(57, 55, 77));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit (3).png"))); // NOI18N
        jLabel28.setText(" Log out");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffbgLayout = new javax.swing.GroupLayout(logoffbg);
        logoffbg.setLayout(logoffbgLayout);
        logoffbgLayout.setHorizontalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoffbgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logoffbgLayout.setVerticalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoffbgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        logs.setBackground(new java.awt.Color(255, 255, 255));
        logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(57, 55, 77));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder-open (1).png"))); // NOI18N
        jLabel9.setText("  Logs");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logsLayout = new javax.swing.GroupLayout(logs);
        logs.setLayout(logsLayout);
        logsLayout.setHorizontalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logsLayout.setVerticalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        logsPane.setBackground(new java.awt.Color(255, 255, 255));
        logsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logsPaneLayout = new javax.swing.GroupLayout(logsPane);
        logsPane.setLayout(logsPaneLayout);
        logsPaneLayout.setHorizontalGroup(
            logsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        logsPaneLayout.setVerticalGroup(
            logsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(logsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        settingsBg.setBackground(new java.awt.Color(255, 255, 255));
        settingsBg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBgMouseExited(evt);
            }
        });
        settingsBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(57, 55, 77));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings (4).png"))); // NOI18N
        jLabel27.setText(" Settings");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        settingsBg.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 96, 38));

        dot.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dot.setForeground(new java.awt.Color(255, 0, 0));
        settingsBg.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 40, 20));

        adm_nav.add(settingsBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, -1));

        settingsPane.setBackground(new java.awt.Color(255, 255, 255));
        settingsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout settingsPaneLayout = new javax.swing.GroupLayout(settingsPane);
        settingsPane.setLayout(settingsPaneLayout);
        settingsPaneLayout.setHorizontalGroup(
            settingsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        settingsPaneLayout.setVerticalGroup(
            settingsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(settingsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 10, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 55, 77));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mini_logo-removebg-preview (1).png"))); // NOI18N
        jLabel2.setText("Purok Link");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 12, 180, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Barangay, Pob. Ward II ");
        adm_header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 60));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 720, 60);

        barangayPanel.setBackground(new java.awt.Color(27, 57, 77));
        barangayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        populationCount.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        populationCount.setForeground(new java.awt.Color(255, 255, 255));
        populationCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        populationCount.setText(" 0");
        barangayPanel.add(populationCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 90));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Residents");
        barangayPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        barangayPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 3, 100));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reports");
        barangayPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 300, 40));

        housePanel.setBackground(new java.awt.Color(255, 255, 255));
        housePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 57, 77));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Total Household");
        housePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        ttl_household.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ttl_household.setForeground(new java.awt.Color(27, 57, 77));
        ttl_household.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ttl_household.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home (2).png"))); // NOI18N
        ttl_household.setText(" 0");
        housePanel.add(ttl_household, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 120, 30));

        barangayPanel.add(housePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 120, 70));

        housePanel1.setBackground(new java.awt.Color(255, 255, 255));
        housePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 57, 77));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Male Resident");
        housePanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        male.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        male.setForeground(new java.awt.Color(27, 57, 77));
        male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        male.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/avatar.png"))); // NOI18N
        male.setText(" 0");
        housePanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        barangayPanel.add(housePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 140, 70));

        housePanel2.setBackground(new java.awt.Color(255, 255, 255));
        housePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 57, 77));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Female Resident");
        housePanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        fem.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        fem.setForeground(new java.awt.Color(27, 57, 77));
        fem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem.setText(" 0");
        housePanel2.add(fem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        housePanel3.setBackground(new java.awt.Color(255, 255, 255));
        housePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 57, 77));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Female Resident");
        housePanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        fem1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        fem1.setForeground(new java.awt.Color(27, 57, 77));
        fem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem1.setText(" 0");
        housePanel3.add(fem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 30));

        housePanel2.add(housePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, 70));

        barangayPanel.add(housePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 140, 70));

        housePanel4.setBackground(new java.awt.Color(255, 255, 255));
        housePanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 57, 77));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Incidents Reports");
        housePanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        reps.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        reps.setForeground(new java.awt.Color(27, 57, 77));
        reps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/newspaper (1).png"))); // NOI18N
        reps.setText(" 0");
        housePanel4.add(reps, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        housePanel5.setBackground(new java.awt.Color(255, 255, 255));
        housePanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 57, 77));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Female Resident");
        housePanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        fem3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        fem3.setForeground(new java.awt.Color(27, 57, 77));
        fem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem3.setText(" 0");
        housePanel5.add(fem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 30));

        housePanel4.add(housePanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, 70));

        barangayPanel.add(housePanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 160, 70));

        housePanel6.setBackground(new java.awt.Color(255, 255, 255));
        housePanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(27, 57, 77));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Archived Resident");
        housePanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        arch.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        arch.setForeground(new java.awt.Color(27, 57, 77));
        arch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/member-list.png"))); // NOI18N
        arch.setText(" 0");
        housePanel6.add(arch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 30));

        housePanel7.setBackground(new java.awt.Color(255, 255, 255));
        housePanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(27, 57, 77));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Female Resident");
        housePanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        fem4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        fem4.setForeground(new java.awt.Color(27, 57, 77));
        fem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem4.setText(" 0");
        housePanel7.add(fem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 30));

        housePanel6.add(housePanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, 70));

        barangayPanel.add(housePanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 110, 70));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        barangayPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 10, 3, 100));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Barangay Data Overview");
        barangayPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 300, 40));

        jPanel1.add(barangayPanel);
        barangayPanel.setBounds(200, 60, 940, 120);

        userTbl.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        userTbl.setGridColor(new java.awt.Color(136, 136, 136));
        userTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTblMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTblMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(userTbl);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png")));

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 240, 940, 300);

        sa1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa1.setForeground(new java.awt.Color(27, 55, 77));
        sa1.setText("All Residents");
        jPanel1.add(sa1);
        sa1.setBounds(200, 180, 120, 60);

        searchField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(204, 204, 204));
        searchField.setText(" Search resident....");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchField.setHighlighter(null);
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchFieldMousePressed(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(searchField);
        searchField.setBounds(710, 200, 310, 30);

        jPanel2.setBackground(new java.awt.Color(27, 57, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(674, 200, 30, 30);

        jButton3.setBackground(new java.awt.Color(0, 118, 245));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ANALYTICS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1030, 200, 110, 30);

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

    private void dashPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseEntered
      dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashPaneMouseEntered

    private void dashPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseExited
      dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashPaneMouseExited

    private void viewPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseEntered

    private void viewPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
       dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        
    }//GEN-LAST:event_dashCMouseExited

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void purokPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseEntered
     //   purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokPaneMouseEntered

    private void purokPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseExited
    //    purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokPaneMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
        // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
      //   purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked
       Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewCMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
          viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
          viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       //Admin_Barangay ab = new Admin_Barangay();
      // ab.setVisible(true);
      // this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
       // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
       //  purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
            try {
             dbConnector dbc = new dbConnector();
             ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + sess.getUid() + "'");
            
             
             if (rs.next()) {
                 String code = rs.getString("u_code");

                 if (code.equals("")) {
                     dot.setText("•");
                 } else {
                     dot.setText("");
                 }
             }

             rs.close();
            
         } catch (SQLException ex) {
             System.out.println("Errors: " + ex.getMessage());
         }
         
       }
       
    }//GEN-LAST:event_formWindowActivated

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void purokCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseClicked
 
    }//GEN-LAST:event_purokCMouseClicked

    private void logoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseEntered

    private void logoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Session sess = Session.getInstance();
        
        int userId = sess.getUid();
        
        logEvent(userId, "LOGOUT", "User logged out");

       
        login_form ads = new login_form();
        JOptionPane.showMessageDialog(null, "Log out successfully!");
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel28MouseExited

    private void logoffbgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffbgMouseClicked

    private void logoffbgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_logoffbgMouseEntered

    private void logoffbgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_logoffbgMouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Admin_Logs al = new Admin_Logs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        logsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        logsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        Admin_Logs al = new Admin_Logs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void logsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseEntered
        logsPane.setBackground(Panecolor);
    }//GEN-LAST:event_logsMouseEntered

    private void logsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseExited
        logsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_logsMouseExited

    private void logsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logsPaneMouseEntered

    private void logsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logsPaneMouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        Admin_Settings as = new Admin_Settings();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        settingsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        settingsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel27MouseExited

    private void settingsBgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsBgMouseClicked

    private void settingsBgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseEntered
        settingsPane.setBackground(Panecolor);
    }//GEN-LAST:event_settingsBgMouseEntered

    private void settingsBgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseExited
        settingsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_settingsBgMouseExited

    private void settingsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsPaneMouseEntered

    private void settingsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsPaneMouseExited

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTblMouseClicked

    private void userTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(userTbl, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_userTblMousePressed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed

        String rid = userTbl.getValueAt(userTbl.getSelectedRow(), 0).toString();

        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT r.*, h.h_name, p.p_name, "
            + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age "
            + "FROM tbl_residents r "
            + "JOIN tbl_household h ON r.h_id = h.h_id "
            + "JOIN tbl_purok p ON h.p_id = p.p_id "
            + "WHERE r.r_id = ?";
            PreparedStatement pst = dbc.connect.prepareStatement(query);
            pst.setString(1, rid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);
                image.setIcon(resizedIcon);

                id.setText(rs.getString("r_id"));
                fullname.setText(rs.getString("r_fname") + " " + rs.getString("r_mname") + " " + rs.getString("r_lname"));
                resname.setText(rs.getString("r_lname") + " " + rs.getString("r_fname") + " " + rs.getString("r_mname"));
                address.setText(rs.getString("r_address"));
                dob.setText(rs.getString("r_dob"));
                age.setText(rs.getString("r_age"));
                status.setText(rs.getString("r_civilstatus"));
                sex.setText(rs.getString("r_sex"));
                ocu.setText(rs.getString("r_occupation"));
                reg.setText(rs.getString("r_religion"));
                household.setText(rs.getString("h_name"));
                purok.setText(rs.getString("p_name"));
            }

            Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, viewPanel);
            dialog.setVisible(true);

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_viewActionPerformed

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked

    }//GEN-LAST:event_cancel1MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered

    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited

    }//GEN-LAST:event_cancel1MouseExited

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed

        Window window = SwingUtilities.getWindowAncestor(viewPanel);
        window.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, gendoc);
        dialog.setVisible(true);
    }//GEN-LAST:event_printActionPerformed

    private void cancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel2MouseClicked

    private void cancel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel2MouseEntered

    private void cancel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel2MouseExited

    private void cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel2ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(gendoc);
        window.dispose();
    }//GEN-LAST:event_cancel2ActionPerformed

    private void print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print1ActionPerformed

        Session sess = Session.getInstance();
        
        int userID = sess.getUid();
        
        a1.setText("");
        a2.setText("");

        if (purpose.getText().isEmpty() || docs.getSelectedIndex() == 0) {
            if (purpose.getText().isEmpty()) {
                a1.setText("Field required");
            }
            if (docs.getSelectedIndex() == 0) {
                a2.setText("Field required");
            }
        } else {
            switch (docs.getSelectedIndex()) {
                case 1:
                {
                    Bgy_Clearance bc = new Bgy_Clearance();
                    bc.fullname.setText(fullname.getText()+",");
                    bc.purok.setText(purok.getText());
                    setDateAutomatically2(bc);
                    bc.age.setText(age.getText());

                    String dobText = dob.getText();
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy");
                    try {
                        Date dateOfBirth = inputFormat.parse(dobText);
                        String formattedDOB = outputFormat.format(dateOfBirth);
                        bc.dob.setText(formattedDOB);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                    bc.purpose.setText(purpose.getText());
                    bc.purok2.setText(purok.getText());
                    PanelPrinter pPrint = new PanelPrinter(bc.page);
                    pPrint.printPanel();
                    
                    JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Window window = SwingUtilities.getWindowAncestor(gendoc);
                    window.dispose();
                    
                    purpose.setText("");
                    docs.setSelectedIndex(0);
                    
                   
                   
                    break;
                }

                case 2:
                {
                    Bgy_Residency br = new Bgy_Residency();
                    br.fullname.setText(fullname.getText()+",");
                    br.purok.setText(purok.getText());
                    setDateAutomatically4(br);
                    br.purpose.setText(purpose.getText());
                    br.purok2.setText(purok.getText());
                    PanelPrinter pPrint = new PanelPrinter(br.page);
                    pPrint.printPanel();
                    
                    JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Window window = SwingUtilities.getWindowAncestor(gendoc);
                    window.dispose();
                    
                    purpose.setText("");
                    docs.setSelectedIndex(0);
                    break;
                }

                case 3:
                {
                    Bgy_Indigency bi = new Bgy_Indigency();
                    bi.fullname.setText(fullname.getText()+",");
                    bi.purok.setText(purok.getText());
                    bi.status.setText(status.getText());
                    bi.age.setText(age.getText());
                    setDateAutomatically3(bi);
                    bi.purpose.setText(purpose.getText());
                    bi.purok2.setText(purok.getText());
                    PanelPrinter pPrint = new PanelPrinter(bi.page);
                    pPrint.printPanel();
                    
                    JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Window window = SwingUtilities.getWindowAncestor(gendoc);
                    window.dispose();
                    
                    purpose.setText("");
                    docs.setSelectedIndex(0);
                    break;

                }

                case 4:
                {
                    Bgy_Solo_parent bsp = new Bgy_Solo_parent();
                    bsp.fullname.setText(fullname.getText()+",");
                    bsp.purok.setText(purok.getText());
                    setDateAutomatically(bsp);
                    bsp.purpose.setText(purpose.getText());
                    bsp.purok2.setText(purok.getText());
                    PanelPrinter pPrint = new PanelPrinter(bsp.page);
                    pPrint.printPanel();
                    
                    JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Window window = SwingUtilities.getWindowAncestor(gendoc);
                    window.dispose();
                    
                    purpose.setText("");
                    docs.setSelectedIndex(0);
                    break;
                }
                default:
                {
                    Bgy_Senior bs = new Bgy_Senior();
                    bs.fullname.setText(fullname.getText()+",");
                    bs.purok.setText(purok.getText());
                    bs.age.setText(age.getText());
                    String dobText = dob.getText();
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy");
                    try {
                        Date dateOfBirth = inputFormat.parse(dobText);
                        String formattedDOB = outputFormat.format(dateOfBirth);
                        bs.dob.setText(formattedDOB);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                    setDateAutomatically1(bs);
                    bs.purpose.setText(purpose.getText());
                    bs.purok2.setText(purok.getText());
                    PanelPrinter pPrint = new PanelPrinter(bs.page);
                    pPrint.printPanel();
                    
                    JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Window window = SwingUtilities.getWindowAncestor(gendoc);
                    window.dispose();
                    
                    purpose.setText("");
                    docs.setSelectedIndex(0);
                    break;
                }
            }
             logEvent(userID, "RESIDENT_DOCUMENT_DOWNLOAD", "Resident ID: "+id.getText()+" document is downloaded by user.");
        }
        
    }//GEN-LAST:event_print1ActionPerformed

    private void docsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docsActionPerformed

    private void purposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purposeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purposeActionPerformed

    private void resnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resnameActionPerformed

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        if (searchField.getText().equals(" Search resident....")){
            searchField.setText("");
            searchField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        if (searchField.getText().equals("")){
            searchField.setText(" Search resident....");
            searchField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed

    }//GEN-LAST:event_searchFieldMousePressed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased

        try {
            dbConnector dbc = new dbConnector();
            String searchText = searchField.getText().trim();
            String query;

            if (searchText.isEmpty()) {
                query = "SELECT r.r_id, r.r_fname, r.r_lname, "
                + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                + "r.r_sex, h.h_name "
                + "FROM tbl_residents r "
                + "JOIN tbl_household h ON r.h_id = h.h_id "
                + "WHERE r.r_status = 'Active' "
                + "ORDER BY r.r_id DESC";
                displayData();

            } else {
                query = "SELECT r.r_id, r.r_fname, r.r_lname, "
                + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                + "r.r_sex, h.h_name "
                + "FROM tbl_residents r "
                + "JOIN tbl_household h ON r.h_id = h.h_id "
                + "WHERE r.r_status = 'Active' "
                + "AND (r.r_lname LIKE '%" + searchText + "%' "
                + "OR r.r_fname LIKE '%" + searchText + "%' "
                + "OR r.r_id LIKE '%" + searchText + "%') "
                + "ORDER BY r.r_id DESC";

                ResultSet rs = dbc.getData(query);
                userTbl.setModel(DbUtils.resultSetToTableModel(rs));
            }

            // Set table headers
            JTableHeader th = userTbl.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();

            tcm.getColumn(0).setHeaderValue("ID");
            tcm.getColumn(1).setHeaderValue("First Name");
            tcm.getColumn(2).setHeaderValue("Last Name");
            tcm.getColumn(3).setHeaderValue("Age");
            tcm.getColumn(4).setHeaderValue("Sex");
            tcm.getColumn(5).setHeaderValue("Household");

            CenterCellRenderer centerRenderer = new CenterCellRenderer();
            for (int i = 0; i < tcm.getColumnCount(); i++) {
                tcm.getColumn(i).setCellRenderer(centerRenderer);
            }

            th.setDefaultRenderer(new CustomHeaderRenderer());
            th.repaint();

        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      Admin_Barangay_Charts abc = new Admin_Barangay_Charts();
      abc.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlActionPerformed

    private void print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2ActionPerformed

        Session sess = Session.getInstance();

        int userID = sess.getUid();

        a3.setText("");
        a4.setText("");

        if (dl.getSelectedIndex() == 0 || nameField.getText().isEmpty()) {
            a3.setText("*");
            a4.setText("*");
            JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = nameField.getText() + ".pdf";
            String location = System.getProperty("user.home") + "/Documents/";

            try {
                dbConnector dbc = new dbConnector();

                String selectedCategory = dl.getSelectedItem().toString(); // Assume a dropdown
                String query;

                switch (selectedCategory) {
                    case "All Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Tambis Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Tambis' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Mahogany Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Mahogany' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Guyabano Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Guyabano' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Ipil-ipil Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r.civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Ipil-ipil' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Minsinitas Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Minsinitas' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Tugas Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Tugas' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Lubi Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Lubi' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Invalid selection!");
                    return;
                }

                ResultSet resultSet = dbc.getData(query);

                com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A5.rotate());
                PdfWriter.getInstance(document, new FileOutputStream(location + name));
                document.open();

                PdfPTable pdfPTable = new PdfPTable(9); // Adjusted to 9 columns (removed Actions column)
                pdfPTable.setWidthPercentage(100); // Make table width span the entire page
                pdfPTable.setSpacingBefore(10f);
                pdfPTable.setSpacingAfter(10f);
                Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
                PdfPCell cell;

                // Add table headers with design improvements
                String[] headers = {"ID", "FIRST", "MIDDLE", "LAST", "AGE", "SEX", "CS", "OCC.", "Purok"};

                float[] columnWidths = {15f, 20f, 20f, 20f, 15f, 15f, 20f, 20f, 20f}; // Adjust these values to fit the columns properly
                pdfPTable.setWidths(columnWidths);

                // Loop through each header and set cell properties
                for (String header : headers) {
                    cell = new PdfPCell(new Phrase(header, headerFont));
                    cell.setBackgroundColor(BaseColor.DARK_GRAY);  // Set background color for headers
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center align the text
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Vertically center the text
                    cell.setPadding(20f); // Set padding for header to fit better
                    cell.setNoWrap(true); // Disable text wrapping for the header
                    pdfPTable.addCell(cell);
                }

                // Populate table with data from ResultSet
                while (resultSet.next()) {
                    pdfPTable.addCell(resultSet.getString("r_id"));
                    pdfPTable.addCell(resultSet.getString("r_fname"));
                    pdfPTable.addCell(resultSet.getString("r_mname"));
                    pdfPTable.addCell(resultSet.getString("r_lname"));
                    pdfPTable.addCell(resultSet.getString("r_age"));
                    pdfPTable.addCell(resultSet.getString("r_sex"));
                    pdfPTable.addCell(resultSet.getString("r_civilstatus"));
                    pdfPTable.addCell(resultSet.getString("r_occupation"));
                    pdfPTable.addCell(resultSet.getString("r_purok"));
                }

                // Add the table to the document
                document.add(pdfPTable);
                document.close();

                JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                Window window = SwingUtilities.getWindowAncestor(download);
                window.dispose();

                // Log the event
                logEvent(userID, "RESIDENT_DOCUMENT_DOWNLOAD", "Data: " + selectedCategory + " is downloaded by user.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_print2ActionPerformed

    private void cancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel3ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(download);
        window.dispose();
    }//GEN-LAST:event_cancel3ActionPerformed

    private void cancel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseExited

    private void cancel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseEntered

    private void cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseClicked

    private void cancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseClicked

    private void cancel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseEntered

    private void cancel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseExited

    private void cancel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4ActionPerformed

    private void print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print3ActionPerformed

    private void dl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dl1ActionPerformed

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed

        try {
            String rid = userTbl.getValueAt(userTbl.getSelectedRow(), 0).toString();

            dbConnector dbc = new dbConnector();
            String query = "SELECT r.*, h.h_name, p.p_name, "
            + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age "
            + "FROM tbl_residents r "
            + "JOIN tbl_household h ON r.h_id = h.h_id "
            + "JOIN tbl_purok p ON h.p_id = p.p_id "
            + "WHERE r.r_id = ?";

            PreparedStatement pst = dbc.connect.prepareStatement(query);
            pst.setString(1, rid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

                Admin_Residents_Update uru = new Admin_Residents_Update();

                uru.image.setIcon(resizedIcon);

                uru.id.setText(rs.getString("r_id"));
                uru.ln.setText(rs.getString("r_lname"));
                uru.fn.setText(rs.getString("r_fname"));
                uru.mn.setText(rs.getString("r_mname"));
                uru.address.setText(rs.getString("r_address"));
                uru.ACCOUNT_NAME.setText(rs.getString("r_fname") + " " + rs.getString("r_lname"));
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("r_dob"));
                uru.dob.setDate(date);
                uru.house.setText(rs.getString("h_name"));
                uru.status.setSelectedItem(rs.getString("r_civilstatus"));
                uru.sex.setSelectedItem(rs.getString("r_sex"));
                uru.occupation.setText(rs.getString("r_occupation"));
                uru.religion.setText(rs.getString("r_religion"));

                uru.setVisible(true);
                this.dispose();
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Admin_Residents_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editItemActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Barangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Admin_Barangay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel address;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    private javax.swing.JLabel age;
    private javax.swing.JLabel arch;
    private javax.swing.JPanel barangayPanel;
    public javax.swing.JButton cancel1;
    public javax.swing.JButton cancel2;
    public javax.swing.JButton cancel3;
    public javax.swing.JButton cancel4;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    public javax.swing.JComboBox<String> dl;
    public javax.swing.JComboBox<String> dl1;
    private javax.swing.JLabel dob;
    public javax.swing.JComboBox<String> docs;
    private javax.swing.JLabel dot;
    private javax.swing.JPanel download;
    private javax.swing.JPanel download1;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JLabel fem;
    private javax.swing.JLabel fem1;
    private javax.swing.JLabel fem3;
    private javax.swing.JLabel fem4;
    private javax.swing.JLabel fullname;
    private javax.swing.JPanel gendoc;
    private javax.swing.JPanel housePanel;
    private javax.swing.JPanel housePanel1;
    private javax.swing.JPanel housePanel2;
    private javax.swing.JPanel housePanel3;
    private javax.swing.JPanel housePanel4;
    private javax.swing.JPanel housePanel5;
    private javax.swing.JPanel housePanel6;
    private javax.swing.JPanel housePanel7;
    private javax.swing.JLabel household;
    private javax.swing.JLabel id;
    public javax.swing.JLabel image;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel logsPane;
    private javax.swing.JLabel male;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameField1;
    private javax.swing.JLabel ocu;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JLabel populationCount;
    private javax.swing.JButton print;
    private javax.swing.JButton print1;
    private javax.swing.JButton print2;
    private javax.swing.JButton print3;
    private javax.swing.JLabel purok;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    public javax.swing.JTextField purpose;
    private javax.swing.JLabel reg;
    private javax.swing.JLabel reps;
    public javax.swing.JTextField resname;
    private javax.swing.JLabel sa1;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel stats1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel ttl_household;
    private javax.swing.JLabel type1;
    private javax.swing.JTable userTbl;
    private javax.swing.JMenuItem view;
    private javax.swing.JPanel viewC;
    private javax.swing.JPanel viewPane;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
