package cc.openhome.controller;

import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kawasumi on 16/1/3.
 */
@WebServlet(
        urlPatterns = {"/login.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW", value = "member.jsp"),
                @WebInitParam(name = "ERROR_VIEW", value = "error.jsp")
        }
)
public class Login extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        if (userService.checkLogin(username, password)) {
            req.getSession().setAttribute("login", username);
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req, resp);
        } else {
            req.setAttribute("eeor", "名称或密码错误");
            resp.sendRedirect(ERROR_VIEW);
        }
    }

}
