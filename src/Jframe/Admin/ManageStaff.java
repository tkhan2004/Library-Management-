/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe.Admin;
import java.sql.PreparedStatement;
import config.ConnectDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dell
 */
public class ManageStaff extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    String staffFullName, staffUsername, staffContact, staffPassword;
    int staffID;
    DefaultTableModel model;

    public ManageStaff() {
        initComponents();
        setLocationRelativeTo(null);
        initialize();
    }

    private void initialize() {
        setStaffDetailsToTable();
    }

    // Load staff details into the table
    public void setStaffDetailsToTable() {
        try {
            Connection con = ConnectDb.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM staffs");

            model = (DefaultTableModel) tbl_staffDetails.getModel();
            model.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                String staffId = rs.getString("staff_id");
                String staffFullName = rs.getString("staff_fullname");
                String staffUsername = rs.getString("staff_username");
                String staffContact = rs.getString("staff_contact");
                String staffPassword = rs.getString("staff_password");

                Object[] obj = {staffId, staffFullName, staffUsername, staffContact, staffPassword};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add a new staff
    public boolean addStaff() {
        boolean isAdded = false;
        staffID = Integer.parseInt(txt_staffId.getText());
        staffFullName = txt_staffName.getText();
        staffUsername = txt_staffUsername.getText();
        staffContact = txt_staffcontact.getText();
        staffPassword = "1";

        try {
            Connection con = ConnectDb.getConnection();
            String sql = "INSERT INTO staffs (staff_id, staff_fullname, staff_username, staff_contact, staff_password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, staffID);
            pst.setString(2, staffFullName);
            pst.setString(3, staffUsername);
            pst.setString(4, staffContact);
            pst.setString(5, staffPassword);

            int rowCount = pst.executeUpdate();
            isAdded = rowCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    // Update an existing staff
    public boolean updateStaff() {
        boolean isUpdated = false;
        staffID = Integer.parseInt(txt_staffId.getText());
        staffFullName = txt_staffName.getText();
        staffUsername = txt_staffUsername.getText();
        staffContact = txt_staffcontact.getText();
        staffPassword = "1";

        try {
            Connection con = ConnectDb.getConnection();
            String sql = "UPDATE staffs SET staff_fullname = ?, staff_username = ?, staff_contact = ?, staff_password = ? WHERE staff_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, staffFullName);
            pst.setString(2, staffUsername);
            pst.setString(3, staffContact);
            pst.setString(4, staffPassword);
            pst.setInt(5, staffID);

            int rowCount = pst.executeUpdate();
            isUpdated = rowCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // Delete a staff member
    public boolean deleteStaff() {
        boolean isDeleted = false;
        staffID = Integer.parseInt(txt_staffId.getText());

        try {
            Connection con = ConnectDb.getConnection();
            String sql = "DELETE FROM staffs WHERE staff_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, staffID);

            int rowCount = pst.executeUpdate();
            isDeleted = rowCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    // Clear the table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_staffDetails.getModel();
        model.setRowCount(0);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_staffId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_staffcontact = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        txt_staffName = new app.bolivia.swing.JCTextField();
        txt_staffUsername = new app.bolivia.swing.JCTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_staffDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Trở lại");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID Nhân Viên :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 140, 30));

        txt_staffId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_staffId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_staffId.setPlaceholder("Nhập id nhân viên...");
        txt_staffId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_staffIdFocusLost(evt);
            }
        });
        txt_staffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_staffIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_staffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 340, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên Nhân Viên :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, 30));

        txt_staffcontact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_staffcontact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_staffcontact.setPlaceholder("Nhập số điện thoại...");
        txt_staffcontact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_staffcontactFocusLost(evt);
            }
        });
        txt_staffcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_staffcontactActionPerformed(evt);
            }
        });
        jPanel1.add(txt_staffcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 340, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tài Khoản nhân viên:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 220, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Số điện thoại");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 160, 30));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle3.setText("XÓA NHÂN VIÊN");
        rSMaterialButtonCircle3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 180, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle4.setText("THÊM NHÂN VIÊN");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 180, 70));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle5.setText("Cập nhật");
        rSMaterialButtonCircle5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 180, 70));

        txt_staffName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_staffName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_staffName.setPlaceholder("Nhập tên nhân viên...");
        txt_staffName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_staffNameFocusLost(evt);
            }
        });
        txt_staffName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_staffNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_staffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 340, -1));

        txt_staffUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_staffUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_staffUsername.setPlaceholder("Nhập tên tài khoản...");
        txt_staffUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_staffUsernameFocusLost(evt);
            }
        });
        txt_staffUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_staffUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_staffUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 340, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 40));

        tbl_staffDetails.setForeground(new java.awt.Color(102, 102, 102));
        tbl_staffDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Nhân Viên", "Họ và Tên", "Tài khoản", "Số điện thoại"
            }
        ));
        tbl_staffDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tbl_staffDetails.setColorBordeFilas(new java.awt.Color(102, 102, 102));
        tbl_staffDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_staffDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_staffDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_staffDetails.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_staffDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_staffDetails.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbl_staffDetails.setRowHeight(40);
        tbl_staffDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_staffDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_staffDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 870, 460));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 100));

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));
        jPanel4.setForeground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 600, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 960, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_staffIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_staffIdFocusLost

    }//GEN-LAST:event_txt_staffIdFocusLost

    private void txt_staffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_staffIdActionPerformed

    }//GEN-LAST:event_txt_staffIdActionPerformed

    private void txt_staffcontactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_staffcontactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffcontactFocusLost

    private void txt_staffcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_staffcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffcontactActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
         if(deleteStaff()==true){
            JOptionPane.showMessageDialog(this,"Nhân viên đã được xóa" );
            clearTable();
            setStaffDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
        if(addStaff()==true){
            JOptionPane.showMessageDialog(this,"Nhân viên đã được thêm" );
            clearTable();
            setStaffDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
         if(updateStaff()==true){
            JOptionPane.showMessageDialog(this,"Đã cập nhật thành công" );
            clearTable();
            setStaffDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        AdminHomePage homeAdmin = new AdminHomePage();
        homeAdmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void tbl_staffDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_staffDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_staffDetails.getSelectedRow();
        TableModel model = tbl_staffDetails.getModel();
        txt_staffId.setText(model.getValueAt(rowNo,0).toString());
        txt_staffName.setText(model.getValueAt(rowNo,1).toString());
        txt_staffUsername.setText(model.getValueAt(rowNo,2).toString());
        txt_staffcontact.setText(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_staffDetailsMouseClicked

    private void txt_staffNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_staffNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffNameFocusLost

    private void txt_staffNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_staffNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffNameActionPerformed

    private void txt_staffUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_staffUsernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffUsernameFocusLost

    private void txt_staffUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_staffUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tbl_staffDetails;
    private app.bolivia.swing.JCTextField txt_staffId;
    private app.bolivia.swing.JCTextField txt_staffName;
    private app.bolivia.swing.JCTextField txt_staffUsername;
    private app.bolivia.swing.JCTextField txt_staffcontact;
    // End of variables declaration//GEN-END:variables
}
