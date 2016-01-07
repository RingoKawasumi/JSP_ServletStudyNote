package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/7.
 */
@WebServlet("/delete.do")
public class Delete extends HttpServlet {

    private final String USERS = "/Users/zhujie/Documents/MyTest/users";
    private final String LOGIN_VIEW = "login.html";
    private final String SUCCESS_VIEW = "member.view";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") == null) {
            resp.sendRedirect(LOGIN_VIEW);
            return;
        }
        String username = (String) req.getSession().getAttribute("login");
        String message = req.getParameter("message");
        File file = new File(USERS + "/" + username + "/" + message + ".txt");
        if (file.exists()) {
            file.delete();
        }
        resp.sendRedirect(SUCCESS_VIEW);
    }
}
