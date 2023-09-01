package kr.co.backend.dao;

import kr.co.backend.config.DbUtil;
import kr.co.backend.web.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private DbUtil dbUtil;
    Connection con = null;

    public UserDao() {
        this.dbUtil = new DbUtil();
    }

    public int getUserCountById(String id) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM USER WHERE USER_ID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = dbUtil.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
             rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
            dbUtil.close(con, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
        return count;
    }

    public int register(UserDTO userInfo) {
        int count = 0;
        String sql = "INSERT INTO USER(USER_ID, USER_PASSWORD, USER_SALT, USER_NAME, USER_NICKNAME, USER_EMAIL, USER_BIRTH, USER_GENDER) " +
                " VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = dbUtil.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userInfo.getUserId());
            pstmt.setString(2, userInfo.getUserPassword());
            pstmt.setString(3, userInfo.getUserSalt());
            pstmt.setString(4, userInfo.getUserName());
            pstmt.setString(5, userInfo.getUserNickname());
            pstmt.setString(6, userInfo.getUserEmail());
            pstmt.setDate(7, userInfo.getUserBirth());
            pstmt.setString(8, userInfo.getUserGender());
            count = pstmt.executeUpdate();
            dbUtil.close(con, pstmt);
        } catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
        return count;
    }
}