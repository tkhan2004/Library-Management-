/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

/**
 *
 * @author dong1
 */
import config.ConnectDb;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement; 
import java.util.Date;


public class DefaulterList extends javax.swing.JFrame {

    /**
     * Creates new form IssuebookDetails
     */
    DefaultTableModel model;
    public DefaulterList() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    //to set the book details into the table    
    public void setIssueBookDetailsToTable() {
    long l = System.currentTimeMillis();
    Date todaysDate = new Date(l);
    
    try {
        Connection con = ConnectDb.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from issue_book_details where due_date < ? and status = ?");
        
        // Convert java.util.Date to java.sql.Date
        pst.setDate(1, new java.sql.Date(todaysDate.getTime()));
        pst.setString(2, "pending");
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            String id = rs.getString("id");
            String bookName = rs.getString("book_name");
            String studentName = rs.getString("student_name");
            String issueDate = rs.getString("issue_date");
            String dueDate = rs.getString("due_date");
            String status = rs.getString("status");

            Object[] obj = {id, bookName, studentName, issueDate, dueDate, status};
            model = (DefaultTableModel) tbl_IssuebookDetails.getModel();
            model.addRow(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_IssuebookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 230, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Edit_Property_50px.png"))); // NOI18N
        jLabel2.setText("Defaulter List");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("   X");
        jLabel14.setToolTipText("");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 50, 40));

        tbl_IssuebookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "BookName", "StudentName", "Issuse Date", "Due Date", "Status"
            }
        ));
        tbl_IssuebookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        tbl_IssuebookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 102));
        tbl_IssuebookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_IssuebookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_IssuebookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_IssuebookDetails.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_IssuebookDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_IssuebookDetails.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbl_IssuebookDetails.setRowHeight(40);
        tbl_IssuebookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_IssuebookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_IssuebookDetails);
        if (tbl_IssuebookDetails.getColumnModel().getColumnCount() > 0) {
            tbl_IssuebookDetails.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 890, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 530));

        setSize(new java.awt.Dimension(892, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void tbl_IssuebookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_IssuebookDetailsMouseClicked
  
    }//GEN-LAST:event_tbl_IssuebookDetailsMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_IssuebookDetails;
    // End of variables declaration//GEN-END:variables
}
