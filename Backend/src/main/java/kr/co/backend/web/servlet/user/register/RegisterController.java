package kr.co.backend.web.servlet.user.register;

import kr.co.backend.service.user.Userservice;
import kr.co.backend.web.dto.ApiResult;
import kr.co.backend.web.dto.UserDTO;
import kr.co.backend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "registerServlet", urlPatterns = {"/api/register"})
public class RegisterController extends BaseServlet {
    ApiResult result = new ApiResult();
    Userservice service = new Userservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        Date birth = Date.valueOf(request.getParameter("birth"));
        String gender = request.getParameter("gender");
        UserDTO userInfo = new UserDTO(id,password,name,nickname,email,birth,gender);
        result = service.register(userInfo) ;
        this.write(response,result);
    }

}
