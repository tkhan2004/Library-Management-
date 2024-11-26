
import Jframe.Staff.LogIn;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class main {

    public static void main(String[] args) {
        // Đảm bảo rằng GUI được tạo ra trên Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Tạo đối tượng JFrame
                LogIn start = new LogIn();
                start.setVisible(true);  // Hiển thị JFrame
            }
        });
    }
}
