package kr.co.backend.web.servlet.user.register;

import kr.co.backend.service.user.Userservice;
import kr.co.backend.web.dto.ApiResult;
import kr.co.backend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkIdServlet", urlPatterns = {"/api/checkId"})
public class CheckIdController extends BaseServlet {
    private Userservice service;
    ApiResult result = new ApiResult();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service = new Userservice();
        String id = request.getParameter("id");
        result = service.checkUserId(id);
        this.write(response,result);
    }
}
