package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhujie on 16/1/11.
 */
@WebServlet("/welcome.view")
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>欢迎</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>目前在线人数 " + OnlineUserCounter.getCounter() + " 人</h1>");
        if (session != null) {
//            String user = (String) session.getAttribute("user");
            User user = (User) session.getAttribute("user");
            out.println("<h1>欢迎: " + user.getName() + "</h1>");
            out.println("<h1>详情: " + user.getData() + "</h1>");
            out.println("<a href='logout.do'></a>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
