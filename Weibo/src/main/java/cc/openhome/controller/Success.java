package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kawasumi on 16/1/3.
 */
//@WebServlet("/success.view")
public class Success extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>新增会员成功</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>会员 " + req.getParameter("username") + " 注册成功</h1>");
        out.println("<a href='login.html'>回首页登录</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
