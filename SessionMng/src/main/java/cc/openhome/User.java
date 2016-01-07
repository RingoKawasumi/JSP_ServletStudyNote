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
 * Created by zhujie on 16/1/5.
 */
@WebServlet("/user.view")
public class User extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        if (request.getAttribute("user") == null) {
//            response.sendRedirect("login.html");
//        }
        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.html");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Servlet User</title>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>" + request.getAttribute("user") + "已登录</h1>");
            out.println("<h1>" + session.getAttribute("login") + "已登录</h1>");
            out.println("<a href='logout.view'>注销</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
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
