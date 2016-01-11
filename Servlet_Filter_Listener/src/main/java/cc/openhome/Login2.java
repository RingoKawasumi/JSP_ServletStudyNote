package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhujie on 16/1/11.
 */
@WebServlet("/login2.do")
public class Login2 extends HttpServlet {

    private Map<String, String> users;

    public Login2() {
        users = new HashMap<>();
        users.put("caterpillar", "123456");
        users.put("momor", "98765");
        users.put("hamimi", "13579");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");

        String page = "login.html";
        if (users.containsKey(name) && users.get(name).equals(passwd)) {
//            req.getSession().setAttribute("user", name);
            User user = new User(name);
            req.getSession().setAttribute("user", user);
            page = "welcome.view";
        }
        resp.sendRedirect(page);
    }
}
