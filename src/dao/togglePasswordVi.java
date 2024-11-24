package dao;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 * Utility class for password visibility toggle
 */
public class togglePasswordVi {
    public static void togglePasswordVisibility(JCheckBox checkBox, JPasswordField passwordField) {
        if (checkBox.isSelected()) {
            passwordField.setEchoChar((char) 0); // Hiển thị mật khẩu
        } else {
            passwordField.setEchoChar('*'); // Ẩn mật khẩu
        }
    }
}
