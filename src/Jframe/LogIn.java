/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Jframe;


import config.ConnectDb;

import javax.swing.*;
import java.sql.*;
import dao.ValidateLogin;
/**
 *
 * @author Admin
 */
public class LogIn extends javax.swing.JFrame {
    public static String currentUsername; // Biến lưu tài khoản đang đăng nhập

    /**
     * Creates new form qưeSignUp
     */
    // chèn giá trị người dùng vào bảng
    public LogIn() {
        initComponents();
    }
    public boolean validateLoginForm() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        return ValidateLogin.validateLogin(name, pwd);
    }
    public void login(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        Connection con = ConnectDb.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM staffs where staff_username = ? and staff_password = ?");
            pst.setString(1,name);
            pst.setString(2,pwd);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Đăng nhập hoàn tất");
                
                // lưu staff user name
                currentUsername = name;
                
                HomePage home = new HomePage();
                home.setVisible(true);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/download.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ĐĂNG NHẬP DÀNH CHO NHÂN VIÊN");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 440, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Chúc bạn ngày mới tốt lành, sẵn sàng để làm việc chưa");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 400, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên đăng nhập :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mật khẩu :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 110, 30));

        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password.setPlaceholder("Mật Khẩu . . . . .");
        txt_password.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        txt_password.setSelectionColor(new java.awt.Color(0, 204, 204));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

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
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle2.setText("ĐĂNG NHẬP");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 320, 70));

        jButton2.setBackground(new java.awt.Color(102, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ĐĂNG NHẬP VỚI TƯ CÁCH ADMIN");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 890));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 51));
        jLabel5.setText("GIỚI THIỆU VỀ THƯ VIỆN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 490, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 0, 51));
        jTextArea1.setRows(5);
        jTextArea1.setText("Thư viện trường Đại học Công nghệ Giao thông Vận tải (UTH) là một trong những đơn vị hỗ trợ học tập và nghiên cứu hàng đầu, đóng vai trò quan trọng trong việc cung cấp tri thức và tạo dựng môi trường học thuật hiện đại cho sinh viên, giảng viên và cán bộ nhà trường.\n\nCơ sở vật chất hiện đại\nThư viện UTH được xây dựng với không gian rộng rãi, trang bị hiện đại, đảm bảo đáp ứng mọi nhu cầu của người dùng. Khu vực đọc sách được bố trí khoa học, ánh sáng phù hợp, tạo không gian học tập thoải mái. Ngoài ra, thư viện còn trang bị các phòng tự học, khu vực nghiên cứu nhóm và máy tính kết nối Internet tốc độ cao.\n\nNguồn tài liệu phong phú\nThư viện sở hữu một nguồn tài nguyên đa dạng, bao gồm:\n\nSách chuyên ngành: Tập trung vào các lĩnh vực kỹ thuật, công nghệ giao thông vận tải, kinh tế và quản lý.\nTài liệu điện tử: Bao gồm các cơ sở dữ liệu học thuật, tài liệu số hóa, và bài báo khoa học quốc tế.\nTạp chí và báo cáo: Các ấn phẩm định kỳ cập nhật những nghiên cứu mới nhất và các xu hướng công nghệ hiện đại.\nLuận văn, luận án: Các nghiên cứu khoa học và đồ án tốt nghiệp của sinh viên, giảng viên.\nDịch vụ hỗ trợ đa dạng\nHỗ trợ mượn/trả tài liệu: Thư viện cung cấp dịch vụ mượn sách nhanh chóng, tiện lợi với hệ thống quản lý bằng mã vạch.\nTư vấn tìm kiếm thông tin: Đội ngũ cán bộ thư viện sẵn sàng hỗ trợ sinh viên, giảng viên trong việc tìm kiếm và sử dụng tài liệu.\nTổ chức hội thảo, chuyên đề: Định kỳ, thư viện tổ chức các buổi giao lưu, chia sẻ kinh nghiệm học tập, nghiên cứu khoa học.\nHỗ trợ tài nguyên trực tuyến: Truy cập tài liệu qua hệ thống thư viện số hiện đại, mọi lúc, mọi nơi.\nĐịnh hướng phát triển\nThư viện UTH không ngừng nâng cấp hệ thống quản lý, mở rộng nguồn tài liệu và cải thiện các dịch vụ nhằm đáp ứng tốt hơn nhu cầu học tập, nghiên cứu của sinh viên. Mục tiêu là xây dựng một thư viện thông minh, trở thành trung tâm tri thức hiện đại, góp phần nâng cao chất lượng đào tạo và nghiên cứu tại trường.\n\nVới vai trò là cầu nối tri thức, thư viện Đại học UTH luôn đồng hành cùng sinh viên và giảng viên, thúc đẩy sự sáng tạo và đổi mới trong học tập cũng như nghiên cứu.");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 700, 340));

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

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void txt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusLost
    }//GEN-LAST:event_txt_nameFocusLost

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AdminLogin AL = new AdminLogin();
        AL.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed

        if(validateLoginForm()){
            login();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
