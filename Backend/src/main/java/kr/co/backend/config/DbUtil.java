package kr.co.backend.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
    private final String url;
    private final String driver;
    private final String user;
    private final String password;
    private Connection conn = null;


    public DbUtil() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/vuetest?characterEncoding=utf8&serverTimezone=UTC";
        this.user = "admin";
        this.password = "1234";
    }

    public Connection getConn() throws Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void close(Connection conn, Statement stmt) throws Exception {
        this.close(conn, stmt, null);
    }
}