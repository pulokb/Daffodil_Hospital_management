
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pulok
 */
public class Channel extends javax.swing.JFrame {

    private String id;

    /**
     * Creates new form Channel
     */
    public Channel() {
        initComponents();
        connect ();
        AutoID();
         LoadDoctor();
         LoadPatient();
         channel_table();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String chno;
    
    public class Doctor
    {
        
        String  id;
        String  name;
        
        
    
    public Doctor (String id, String name)
    {
         
        this.id = id;
        this.name =name;
        
    }
    
    public String toString()
    {
        return name;
    }
    
    }
    
    
    
    
    
    
      public class Patient
    {
        
        String  id;
        String  name;
        
        
    
    public Patient (String id, String name)
    {
         
        this.id = id;
        this.name =name;
        
    }
    
    public String toString()
    {
        return name;
    }
    
    }
      
      
      
       public void LoadPatient()
   {
       
        try {
            pst = con.prepareStatement("select * from Patient");
            rs = pst.executeQuery();
            txtp.removeAll();
            
            while (rs.next())
            {
               txtp.addItem(new Patient(rs.getString(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
      
      
      
      
    
    
   public void LoadDoctor()
   {
       
        try {
            pst = con.prepareStatement("select * from Doctor");
            rs = pst.executeQuery();
            txtdoc.removeAll();
            
            while (rs.next())
            {
                txtdoc.addItem(new Doctor(rs.getString(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
    
    
    public void connect ()
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root" , ""); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
     public void AutoID(){
    
    
        try {
            Statement s = con.createStatement();
            
            rs = s.executeQuery("select MAX(channelno) from channel");
            rs.next();
            rs.getString("MAX(channelno)");
            
            if(rs.getString("MAX(channelno)") == null){
            
            lblchno.setText("CH001");
            
            }
            else{
            
            long id = Long.parseLong(rs.getString("MAX(channelno)").substring(2,rs.getString("MAX(channelno)").length()));
            id++;
             lblchno.setText("CH"+String.format("%03d", id));
             
            
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     
     
     
         
      public void channel_table()
    {
        
        try {
            pst = con.prepareStatement("select * from channel");
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            
            
            while (rs.next())
            {
                Vector v2 = new Vector ();
                
                for(int i =1; i<= c; i++)
                {
                
                v2.add(rs.getString("channelno"));
                v2.add(rs.getString("doctorname"));
                v2.add(rs.getString("patientname"));
                v2.add(rs.getString("roomno"));
                v2.add(rs.getString("date"));        
                }
                
                df.addRow(v2);
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblchno = new javax.swing.JLabel();
        txtroom = new javax.swing.JSpinner();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtp = new javax.swing.JComboBox();
        txtdoc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Channel  Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Channel No :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doctor Name :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patient Name :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room No :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Channel Date :");

        lblchno.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblchno.setForeground(new java.awt.Color(255, 255, 255));
        lblchno.setText("jLabel7");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Channel No", "Doctor Name", "Patient Name", "Room No", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(144, 144, 144)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txtroom)
                    .addComponent(lblchno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblchno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Daffodil International Hospital");

        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Go Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(907, 907, 907)
                .addComponent(jLabel7)
                .addGap(20, 21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(468, 468, 468)
                .addComponent(jButton1)
                .addGap(166, 166, 166)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String chno = lblchno.getText();
        Doctor d = (Doctor) txtdoc.getSelectedItem();
        Patient p = (Patient) txtp.getSelectedItem();
        String room = txtroom.getValue().toString();
        SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
       String date = dateformat.format(txtdate.getDate());
        
        try {
            pst = con.prepareStatement("insert into channel (channelno, doctorname, patientname ,roomno ,date ) values (?,?,?,?,?)");
            pst.setString (1, chno);
            pst.setString (2, d.id);
            pst.setString (3, p.id);
            pst.setString (4, room);
            pst.setString (5, date);
            
           
            
            pst.executeUpdate();
            
           JOptionPane.showMessageDialog(this, "Channel Created.......!");
           
           AutoID();
       
           txtdoc.setSelectedIndex(-1);
            txtp.setSelectedIndex(-1);
            txtroom.setValue(0);
          
 
           
         
           channel_table();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel d1 = (DefaultTableModel)  jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
         chno = d1.getValueAt(selectIndex, 0) .toString();
        
        JOptionPane.showMessageDialog(this, chno);
         jButton1.setEnabled(false);
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
     
        try {
            pst = con.prepareStatement("delete from channel where channelno = ? ");
            pst.setString (1, chno);
            
           
            
            pst.executeUpdate();
            
           JOptionPane.showMessageDialog(this, "Channel Deleted.......!");
           
           AutoID();
       
           txtdoc.setSelectedIndex(-1);
            txtp.setSelectedIndex(-1);
            txtroom.setValue(0);
          
          
           
         
           channel_table();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
                                   
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

    
         this.setVisible(false);
      

    }//GEN-LAST:event_jLabel7MouseClicked

    
    
    
    
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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Channel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblchno;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox txtdoc;
    private javax.swing.JComboBox txtp;
    private javax.swing.JSpinner txtroom;
    // End of variables declaration//GEN-END:variables
}
