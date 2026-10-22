package com.longtam.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Thay đổi thông tin CSDL của bạn ở đây
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyKhoThuocLongTam";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Nhập mật khẩu MySQL của bạn nếu có

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy Driver JDBC!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL!");
            e.printStackTrace();
        }
        return conn;
    }

    // Hàm main dùng để kiểm thử kết nối
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println(">>> KẾT NỐI CSDL THÀNH CÔNG! <<<");
        } else {
            System.out.println(">>> KẾT NỐI CSDL THẤT BẠI! <<<");
        }
    }
}