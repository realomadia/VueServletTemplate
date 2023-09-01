package kr.co.backend.web.dto;

import java.sql.Date;

public class UserDTO {
    private String userId;
    private String userPassword;
    private String userSalt;
    private String userName;
    private String userNickname;
    private String userEmail;
    private Date userBirth;
    private String userGender;


    public UserDTO(String userId, String userPassword, String userName, String userNickname, String userEmail, Date userBirth, String userGender) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userBirth = userBirth;
        this.userGender = userGender;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String salt) {
        userSalt = salt;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userName='" + userName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirth=" + userBirth +
                ", userGender='" + userGender + '\'' +
                '}';
    }

    public UserDTO() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
