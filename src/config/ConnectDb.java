package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
    // Tạo kết nối tĩnh
    private static Connection con = null;
    // Tạo instance theo mô hình Singleton
    private static ConnectDb instance = new ConnectDb();

    // Constructor private để không cho tạo đối tượng từ bên ngoài
    private ConnectDb() {}

    // Phương thức để lấy instance duy nhất
    public static ConnectDb getInstance() {
        return instance;
    }

    // Phương thức kết nối
    public void connect() {
        try {
            // Nạp MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Kết nối với MySQL: cập nhật URL, username và password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3366/library_ms",
                    "root",""
            );

            System.out.println("Kết nối thành công!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Kết nối thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức ngắt kết nối
    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Đã ngắt kết nối!");
            } catch (SQLException e) {
                System.err.println("Lỗi khi ngắt kết nối: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Phương thức lấy kết nối
    public static Connection getConnection() {
        if (con == null) {
            instance.connect();
        }
        return con;
    }
}
