/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Jframe;


import config.ConnectDb;
import java.sql.Connection; 
import java.sql. PreparedStatement; 
import java.sql.ResultSet; 
import javax.swing. JOptionPane; 
import java.sql.SQLException;


/**
 *
 * @author Admin
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form qưeSignUp
     */
    // chèn giá trị người dùng vào bảng
    public SignUp() {
        initComponents();
    }
    public void insertSignupDetails(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        try{
            Connection con = ConnectDb.getConnection();
            String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, pwd);
            pst.setString(3, email);
            pst.setString(4, contact);
           
            int updatedRowCount = pst.executeUpdate();
            if (updatedRowCount > 0) {
                JOptionPane.showMessageDialog(null, "Sign Up Successful");
                LogIn page = new LogIn();
                page.setVisible(true);
                dispose();
            }else {
                JOptionPane.showMessageDialog(null, "Sign Up Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean ValidateSignup() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(this, "Xin nhập tài khoản");
            return false;
        } if(pwd.equals("")){
            JOptionPane.showMessageDialog(this, "Xin nhập mật khẩu");
            return false;
        }if(email.equals("")|| !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Xin nhập email");
            return false;
        }if(contact.equals("")){
            JOptionPane.showMessageDialog(this, "Xin nhập số điện thoại");
            return false;
        }
        return true;
    }
    public boolean checkDuplicateUsername() {
        String name = txt_username.getText();
        boolean isExist = false;
        try{
            Connection con = ConnectDb.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                isExist = true;
            }else {
                isExist = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        txt_email = new app.bolivia.swing.JCTextField();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ĐĂNG KÝ TÀI KHOẢN MỚI TẠI ĐÂY");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 350, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên đăng nhập :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 160, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mật khẩu :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Email :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 160, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Số điện thoại :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 30));

        txt_contact.setBackground(new java.awt.Color(0, 204, 204));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_contact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_contact.setPlaceholder("Số Điện Thoại . . . . .");
        txt_contact.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txt_contact.setSelectionColor(new java.awt.Color(0, 204, 204));
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        txt_password.setBackground(new java.awt.Color(0, 204, 204));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password.setPlaceholder("Mật Khẩu . . . . .");
        txt_password.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txt_password.setSelectionColor(new java.awt.Color(0, 204, 204));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        txt_email.setBackground(new java.awt.Color(0, 204, 204));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_email.setPlaceholder("Email . . . . .");
        txt_email.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txt_email.setSelectionColor(new java.awt.Color(0, 204, 204));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        txt_username.setBackground(new java.awt.Color(0, 204, 204));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_username.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_username.setPlaceholder("Tên Đăng Nhập . . . . .");
        txt_username.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txt_username.setSelectionColor(new java.awt.Color(0, 204, 204));
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("ĐĂNG KÝ");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 320, 70));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle2.setText("ĐĂNG NHẬP");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 320, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 890));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("THƯ VIỆN ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 260, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("CHÀO MỪNG BẠN ĐẾN ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 560, 150));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("X");
        jButton1.setAlignmentX(1.0F);
        jButton1.setAlignmentY(1.0F);
        jButton1.setBorder(null);
        jButton1.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/download.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 590, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 740, 830));

        setSize(new java.awt.Dimension(1233, 652));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
    }//GEN-LAST:event_txt_passwordActionPerformed
    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
    }//GEN-LAST:event_txt_emailActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        LogIn page = new LogIn();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void txt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusLost
    }//GEN-LAST:event_txt_nameFocusLost

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField1ActionPerformed
    }//GEN-LAST:event_jCTextField1ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (ValidateSignup()==true) {
            if (checkDuplicateUsername() == false){
                insertSignupDetails();
            }else {
                JOptionPane.showMessageDialog(this,"Tài khoản đã có người đặt");
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if(checkDuplicateUsername() == true){
            JOptionPane.showMessageDialog(this, "Tên đã tồn tại");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
