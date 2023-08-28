package kr.co.backend.entity;

public class User {
    private String userid;
    private String fullName;
    private String password;
    private String depId;
    private String phone;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User() {

    }

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public User(String userid, String fullName, String password, String depId, String phone, String type) {
        this.userid = userid;
        this.fullName = fullName;
        this.password = password;
        this.depId = depId;
        this.phone = phone;
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "user{" + "userid='" + userid + '\'' + ", fullName='" + fullName + '\'' + ", password='" + password + '\'' + ", depId='" + depId + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
