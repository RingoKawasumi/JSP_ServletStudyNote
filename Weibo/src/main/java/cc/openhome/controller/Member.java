package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by kawasumi on 16/1/3.
 */
@WebServlet("/member.view")
public class Member extends HttpServlet {

    private final String USERS = "/Users/zhujie/Documents/MyTest/users";
    private final String LOGIN_VIEW = "login.html";
    private final String SUCCESS_VIEW = "member.view";
    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();
    private DateComparator comparator = new DateComparator();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") == null) {
            response.sendRedirect(LOGIN_VIEW);
            return;
        }
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
        Map<Date, String> messages = readMessage(username);
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

    private Map<Date, String> readMessage(String username) throws IOException {
        File border = new File(USERS + "/" + username);
        String[] txts = border.list(filenameFilter);

        Map<Date, String> messages = new TreeMap<>(comparator);
        for (String txt : txts) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(USERS + "/" + username + "/" + txt), "UTF-8"));
            String text = null;
            StringBuilder builder = new StringBuilder();
            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
            messages.put(date, builder.toString());
            reader.close();
        }
        return messages;
    }

    private class TxtFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    }

    private class DateComparator implements Comparator<Date> {

        @Override
        public int compare(Date o1, Date o2) {
            return -o1.compareTo(o2);
        }
    }
}
