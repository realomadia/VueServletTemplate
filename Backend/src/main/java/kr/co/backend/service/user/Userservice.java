package kr.co.backend.service.user;

import kr.co.backend.config.SHA256Util;
import kr.co.backend.config.SaltUtil;
import kr.co.backend.dao.UserDao;
import kr.co.backend.web.dto.ApiResult;
import kr.co.backend.web.dto.UserDTO;

public class Userservice {
    ApiResult result = null;
    private UserDao userDao;

    public Userservice() {
        this.userDao = new UserDao();
    }

    public ApiResult checkUserId(String id) {
        int count = userDao.getUserCountById(id);
        result = new ApiResult();
        if(count == 0){
            result.setCode("200");
            result.setMessage("사용 가능한 아이디 입니다.");
        } else if (count == 1) {
            result.setCode("400");
            result.setMessage("이미 사용중인 아이디 입니다.");
        }else{
            result.setCode("500");
            result.setMessage("서버에 문제가 발생 했습니다. 관리자 에게 문의 하세요.");
        }
        return result;
    }

    public ApiResult register(UserDTO userInfo) {
        result = new ApiResult();
        String salt = SaltUtil.generateSalt();
        String saltedPassword = SHA256Util.encrypt(userInfo.getUserPassword(), salt);

        userInfo.setUserSalt(salt);
        userInfo.setUserPassword(saltedPassword);
        int count = userDao.register(userInfo);
        if(count == 1){
            result.setCode("200");
            result.setMessage("회원가입 성공");
        }else if(count == 0){
            result.setCode("400");
            result.setMessage("입력값이 유효하지 않습니다.");
        }else{
            result.setCode("500");
            result.setMessage("서버에 문제가 발생 했습니다. 관리자 에게 문의 하세요.");
        }
        return result;
    }
}
