package cc.openhome.controller;

import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by kawasumi on 16/1/3.
 */
@WebServlet("/member.view")
public class Member extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("login");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Gossip 微博</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<img src='/images/yingtao.jpg' alt='Gossip 微博' /><br><br>");
        out.println("<a href='logout.do?username=" + username + "'>注销 " + "</a>");

        out.println("<form method='post' action='message.do'>");
        out.println("分享新鲜事...<br>");
        String blabla = request.getParameter("blabla");
        if (blabla == null) {
            blabla = "";
        } else {
            out.println("信息要140字以内<br>");
        }
        out.println("<textarea cols='60' rows='4' name='blabla'>" + blabla + "</textarea>");
        out.println("<button type=\"submit\">送出</button>");
        out.println("</form>");

        out.println("<tbody>");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        Map<Date, String> messages = userService.readMessage(username);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
        for (Date date : messages.keySet()) {
            out.println("<tr><td style='vertical-align: top;'>");
            out.println(username + "<br>");
            out.println(messages.get(date) + "<br>");
            out.println(dateFormat.format(date));
            out.println("<a href='delete.do?message=" + date.getTime() + "'>删除</a>");
            out.println("<hr></td></tr>");
        }
        out.println("</tbody>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
