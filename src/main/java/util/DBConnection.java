package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;encrypt=false";  //chỉnh sửa theo tên database phù hợp
    static String user = "sa";
    static String pass = "sa"; //chinh sua mat khau phu hop
    public static Connection getConnection()
    {
        Connection conn=null;
        try {
            //nap driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 2. Kết nối CSDL
             conn = DriverManager.getConnection(url, user, pass);        
        } catch (Exception ex) {
            System.out.println("Loi: " + ex.toString());
        }
        return conn;
    }
    
    public static void main(String[] args) {
        System.out.println(DBConnection.getConnection());
    }
}
