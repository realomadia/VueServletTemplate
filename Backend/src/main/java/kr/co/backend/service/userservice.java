package kr.co.backend.service;

import kr.co.backend.dao.UserDao;

public class userservice {
    private UserDao userDao;

    public userservice() {
        this.userDao = new UserDao();
    }


}
