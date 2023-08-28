package kr.co.backend.web.servlet.user;

import kr.co.backend.web.dto.ApiResult;
import kr.co.backend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userServlet", urlPatterns = {"/api/register"})
    public class UserServlet extends BaseServlet {
        ApiResult result = new ApiResult();
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        result.setCode("200");
        this.write(resp,result);
    }
}
