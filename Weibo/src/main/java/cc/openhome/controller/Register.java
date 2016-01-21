package cc.openhome.controller;

import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kawasumi on 16/1/3.
 */
@WebServlet(
        urlPatterns = {"/register.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW", value = "success.view"),
                @WebInitParam(name = "ERROR_VIEW", value = "error.view")
        }
)
public class Register extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPasswd = req.getParameter("confirmedPasswd");

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        List<String> errors = new ArrayList<String>();
        if (isInvalidEmail(email)) {
            errors.add("未填写邮件或邮件格式不正确");
        }
        if (userService.isInvalidUsername(username)) {
            errors.add("用户名称为空或已存在");
        }
        if (isInvalidPassword(password, confirmPasswd)) {
            errors.add("请确认密码符合格式并再次确认密码");
        }
        String resultPage = ERROR_VIEW;
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
        } else {
            resultPage = SUCCESS_VIEW;
            userService.createUserData(email, username, password);
        }
        req.getRequestDispatcher(resultPage).forward(req, resp);

    }

    private boolean isInvalidEmail(String email) {
//        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$]");
        return false;
    }

    private boolean isInvalidPassword(String password, String confirmPasswd) {
        return password == null || password.length() < 6 || password.length() > 16 || !password.equals(confirmPasswd);
    }

}
