package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhujie on 16/1/11.
 */
//@WebServlet(
//        urlPatterns = {"/avatar.view"},
//        initParams = {
//                @WebInitParam(name = "AVATAR_DIR", value = "/avatars")
//        }
//)
@WebServlet("/avatar.view")
public class Avatar extends HttpServlet {

    private String AVATAR_DIR;

    @Override
    public void init() throws ServletException {
//        AVATAR_DIR = getInitParameter("AVATAR_DIR");
        AVATAR_DIR = (String) getServletContext().getAttribute("avatars");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>头像显示</title>");
        out.println("</head>");
        out.println("<body>");
        for (String avatar : getServletContext().getResourcePaths(AVATAR_DIR)) {
            avatar = avatar.replaceFirst("/", "");
            out.println("<img src='" + avatar + "'>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
