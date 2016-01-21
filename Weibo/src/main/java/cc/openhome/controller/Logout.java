package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/7.
 */
@WebServlet(
        urlPatterns = {"/logout.do"},
        initParams = {
                @WebInitParam(name = "LOGIN_VIEW", value = "login.html")
        }
)
public class Logout extends HttpServlet {

    private String LOGIN_VIEW = "login.html";

    @Override
    public void init() throws ServletException {
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(LOGIN_VIEW);
    }
}
