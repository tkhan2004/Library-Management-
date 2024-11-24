package dao;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedPasswordField extends JPasswordField {
    private int radius;

    public RoundedPasswordField(int radius) {
        this.radius = radius;
        setOpaque(false);  // Đảm bảo nền trong suốt
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Loại bỏ viền mặc định
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Vẽ nền bo góc
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);  // Vẽ văn bản của mật khẩu
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Vẽ viền cho trường mật khẩu
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);  // Chọn màu viền
        g2.setStroke(new BasicStroke(1));  // Đặt độ dày của viền
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
