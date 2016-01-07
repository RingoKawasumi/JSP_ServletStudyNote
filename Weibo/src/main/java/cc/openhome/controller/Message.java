package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * Created by zhujie on 16/1/7.
 */
@WebServlet("/message.do")
public class Message extends HttpServlet {

    private final String USERS = "/Users/zhujie/Documents/MyTest/users";
    private final String LOGIN_VIEW = "login.html";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "member.view";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") == null) {
            resp.sendRedirect(LOGIN_VIEW);
            return;
        }

        req.setCharacterEncoding("UTF-8");
        String blabla = req.getParameter("blabla");
        if (blabla != null && blabla.length() != 0) {
            if (blabla.length() < 140) {
                String username = (String) req.getSession().getAttribute("login");
                addMessage(username, blabla);
                resp.sendRedirect(SUCCESS_VIEW);
            } else {
                req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
            }
        } else {
            resp.sendRedirect(ERROR_VIEW);
        }
    }

    private void addMessage(String username, String blabla) throws IOException {
        String file = USERS + "/" + username + "/" + new Date().getTime() + ".txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        writer.write(blabla);
        writer.close();
    }
}
