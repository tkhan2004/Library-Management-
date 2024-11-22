/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;
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
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    String studentName,course,branch;
    int studentID;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        i2();//gọi phương thức inint để tránh khả năng overriding
    }
    private void i2(){
        setStudentDetailsToTable();
    }
    // thiết lập thông tin của sinh viên vào trong bản
    public void setStudentDetailsToTable(){
        
        try {
             // Lấy kết nối từ lớp ConnectDb
            Connection con = ConnectDb.getConnection();
            Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student_details");
           
           model = (DefaultTableModel) tbl_studentDetails.getModel();
           model.setRowCount(0);
           while(rs.next()){
               String StudentId = rs.getString("student_id");
               String StudentName = rs.getString("name");
               String course = rs.getString("school_year");
               String branch = rs.getString("branch");
               System.out.println("StudentId:" + rs.getString("student_id"));
               Object[] obj = {StudentId,StudentName,course,branch};
               model =(DefaultTableModel) tbl_studentDetails.getModel();
               model.addRow(obj);
               tbl_studentDetails.revalidate();
               tbl_studentDetails.repaint();

           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    // hàm để add Student vào bản
public boolean addStudent(){
    boolean isAdded = false;
    studentID = Integer.parseInt(txt_studentId.getText());
    studentName = txt_studentName.getText();
    course = combo_NumberCourse.getSelectedItem().toString();
    branch = Combo_branch.getSelectedItem().toString();
    
    
    try {
        Connection con = ConnectDb.getConnection();
        if(con == null){
            System.out.println("Error: Unable to connect to the database.");
            return  false;
        }
        String sql = "insert into student_details values (?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,studentID);
        pst.setString(2,studentName);
        pst.setString(3,course);
        pst.setString(4,branch);
        
       
        int rowCount = pst.executeUpdate();
        if(rowCount > 0){
            isAdded = true;
        }
        else{
            isAdded = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isAdded;
}
// Phương thức cập nhập sinh viên
public boolean updateStudent(){
    boolean isUpdated = false;
     studentID = Integer.parseInt(txt_studentId.getText());
    studentName = txt_studentName.getText();
    course = combo_NumberCourse.getSelectedItem().toString();
    branch = Combo_branch.getSelectedItem().toString();
    
    try {
        Connection con = ConnectDb.getConnection();
        String sql = "update student_details set name = ?, school_year = ?, branch = ? where student_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, studentName);
        pst.setString(2, course);
        pst.setString(3, branch);
        pst.setInt(4, studentID);
        
       int rowCount = pst.executeUpdate();
       if(rowCount > 0){
           isUpdated = true;
           
       }else{
           isUpdated = false;
       }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isUpdated;
}
// tạo phương thức xóa
public boolean deleteStudent(){
    boolean isDeleted = false;
    studentID = Integer.parseInt(txt_studentId.getText());
    
    try {
        Connection con = ConnectDb.getConnection();
        String sql = "delete from student_details where student_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, studentID);
        int rowCount = pst.executeUpdate();
        if(rowCount > 0){
            isDeleted = true;
        }else{
            isDeleted = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isDeleted;
}


// phương thức xóa bản
public void clearTable(){
    DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
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
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        Combo_branch = new javax.swing.JComboBox<>();
        combo_NumberCourse = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
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
        jLabel10.setText("ID Sinh Viên :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 140, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_studentId.setPlaceholder("Nhập id sinh viên...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 340, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 156, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên Sinh Viên :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, 30));

        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 10, new java.awt.Color(102, 102, 102)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_studentName.setPlaceholder("Nhập tên sinh viên...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 340, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Niên khóa :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 180, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ngành :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 160, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle3.setText("Xóa sinh viên");
        rSMaterialButtonCircle3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 180, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle4.setText("Thêm sinh viên");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 180, 70));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle5.setText("Cập nhật SV");
        rSMaterialButtonCircle5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 180, 70));

        Combo_branch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CN", "KM", "HT", "CK" }));
        jPanel1.add(Combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 340, 30));

        combo_NumberCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_NumberCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020 - 2024", "2021 - 2025", "2022 - 2026", "2023 - 2027", "2024 - 2028" }));
        combo_NumberCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_NumberCourseActionPerformed(evt);
            }
        });
        jPanel1.add(combo_NumberCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 383, 340, 30));

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

        tbl_studentDetails.setForeground(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 870, 460));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/students.png"))); // NOI18N
        jLabel1.setText(" Manage Students");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 100));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
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

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed

    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
         if(deleteStudent()==true){
            JOptionPane.showMessageDialog(this,"Sinh viên đã được xóa" );
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Không thể xóa sinh viên");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
        if(addStudent()==true){
            JOptionPane.showMessageDialog(this,"Sinh viên đã được thêm" );
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
         if(updateStudent()==true){
            JOptionPane.showMessageDialog(this,"Đã cập nhật thành công" );
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_NumberCourse.setSelectedItem(model.getValueAt(rowNo,2).toString());
        Combo_branch.setSelectedItem(model.getValueAt(rowNo,3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void combo_NumberCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_NumberCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_NumberCourseActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_branch;
    private javax.swing.JComboBox<String> combo_NumberCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
