package qlns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QLNS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = getConnection();
        if (con != null) {
            System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
           
             Dangnhap dangnhap = new Dangnhap();
                dangnhap.setVisible(true);
                
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            // Đảm bảo rằng bạn đã import thư viện Driver của MySQL vào dự án.
            // Tùy chỉnh chuỗi kết nối phù hợp với cấu hình máy chủ MySQL của bạn.
            String url = "jdbc:mysql://localhost/dulieu?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Lỗi khi kết nối cơ sở dữ liệu: " + ex.getMessage());
        }

        return con;
    }
}
