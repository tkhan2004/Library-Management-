/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.togglePasswordVi;
import dao.RoundedPasswordField;
import config.ConnectDb;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author dell
 */
public class ChangePass extends javax.swing.JFrame {
    public boolean changePassword(String username, char[] oldPassword, char[] newPassword, char[] confirmPassword) {
    // Kết nối cơ sở dữ liệu
    Connection con = ConnectDb.getConnection();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại!");
        return false;
    }

    try {
        // Kiểm tra mật khẩu cũ
        String query = "SELECT * FROM staffs WHERE staff_username = ? AND staff_password = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username.trim()); // Loại bỏ khoảng trắng không mong muốn
        pst.setString(2, new String(oldPassword).trim()); // Chuyển char[] sang String và loại bỏ khoảng trắng

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            // Mật khẩu cũ đúng, tiếp tục kiểm tra mật khẩu mới
            if (new String(newPassword).equals(new String(confirmPassword))) {
                // Cập nhật mật khẩu mới
                String updateQuery = "UPDATE staffs SET staff_password = ? WHERE staff_username = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setString(1, new String(newPassword).trim());
                updateStmt.setString(2, username.trim());

                int rowCount = updateStmt.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể thay đổi mật khẩu, thử lại sau!");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp với xác nhận!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng!");
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình thay đổi mật khẩu!");
        return false;
    } finally {
        // Dọn sạch mảng mật khẩu để bảo mật
        java.util.Arrays.fill(oldPassword, '\0');
        java.util.Arrays.fill(newPassword, '\0');
        java.util.Arrays.fill(confirmPassword, '\0');
    }
    
    
}
    
    /**
     * 
     * Creates new form ChangePass
     */
    public ChangePass() {
        initComponents();
        
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new RoundedPanel(30);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        newpasscf = new javax.swing.JPasswordField();
        currentpass = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tài khoản nhân viên:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Mật khẩu Mới:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Xác Nhận Lại Mật Khẩu:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setText("Thay Đổi Mật Khẩu");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        newpass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        newpass.setToolTipText("");
        newpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 350, 42));

        newpasscf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        newpasscf.setToolTipText("");
        newpasscf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.add(newpasscf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 350, 42));

        currentpass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        currentpass.setToolTipText("");
        currentpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        currentpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentpassActionPerformed(evt);
            }
        });
        jPanel1.add(currentpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 350, 42));

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCheckBox1.setText("Hiện/Ẩn");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jCheckBox2.setText("Hiện/Ẩn");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCheckBox3.setText("Hiện/Ẩn");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        rSMaterialButtonCircle3.setText("Hủy");
        rSMaterialButtonCircle3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 235, 75));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(168, 211, 255));
        rSMaterialButtonCircle4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rSMaterialButtonCircle4.setText("Lưu");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 235, 75));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 20, 40));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Mật Khẩu Hiện Tại:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        Username.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 350, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        togglePasswordVi.togglePasswordVisibility(jCheckBox3, newpass);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        togglePasswordVi.togglePasswordVisibility(jCheckBox2, currentpass);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        togglePasswordVi.togglePasswordVisibility(jCheckBox1, newpasscf);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void currentpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentpassActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
        String username = Username.getText(); // Lấy từ trường nhập username
        char[] oldPassword = currentpass.getPassword(); // Lấy từ trường nhập mật khẩu cũ
        char[] newPassword = newpass.getPassword(); // Lấy từ trường nhập mật khẩu mới
        char[] confirmPassword = newpasscf.getPassword(); // Lấy từ trường xác nhận mật khẩu mới

        boolean success = changePassword(username, oldPassword, newPassword, confirmPassword);
        if (success) {
            System.out.println("Mật khẩu đã được thay đổi thành công.");
        } else {
            System.out.println("Thay đổi mật khẩu thất bại.");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Username;
    private javax.swing.JPasswordField currentpass;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField newpasscf;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    // End of variables declaration//GEN-END:variables
private static class RoundedPanel extends JPanel {
    private int radius; // Bán kính góc bo

    public RoundedPanel(int radius) {
        this.radius = radius; // Gán giá trị bán kính góc
        setOpaque(false); // Đảm bảo nền trong suốt
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }
    }
}
