package kr.co.backend.dao;

import kr.co.backend.config.DbUtil;
import kr.co.backend.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private DbUtil dbUtil;

    public UserDao() {
        this.dbUtil = new DbUtil();
    }


    public List<User> finduser() {
        List<User> users = new ArrayList<User>();
        Connection conn = null;
        String sql = "select * from user ";
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }

            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}