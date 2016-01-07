package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kawasumi on 16/1/3.
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {

    private final String USERS = "/Users/zhujie/Documents/MyTest/users";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "login.html";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (checkLogin(username, password)) {
            req.getSession().setAttribute("login", username);
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req, resp);
        } else {
            resp.sendRedirect(ERROR_VIEW);
        }
    }

    private boolean checkLogin(String username, String password) throws IOException {
        if (username != null && password != null) {
            for (String file : new File(USERS).list()) {
                if (file.equals(username)) {
                    BufferedReader reader = new BufferedReader(new FileReader(USERS + "/" + file + "/profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    if (passwd.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
