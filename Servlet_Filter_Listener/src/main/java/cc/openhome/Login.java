package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/9.
 */
@WebServlet(
        name = "Login",
        urlPatterns = {"/login.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS", value = "success.view"),
                @WebInitParam(name = "ERROR", value = "error.view")
        }
)
public class Login extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS");
        ERROR_VIEW = getInitParameter("ERROR");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        if ("caterpillar".equals(name) && "123456".equals(passwd)) {
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req, resp);
        } else {
            req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
        }
    }
}
