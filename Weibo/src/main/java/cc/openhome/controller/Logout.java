package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/7.
 */
@WebServlet("/logout.do")
public class Logout extends HttpServlet {

    private final String LOGIN_VIEW = "login.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") == null) {
            req.getSession().invalidate();
        }
        resp.sendRedirect(LOGIN_VIEW);
    }
}
