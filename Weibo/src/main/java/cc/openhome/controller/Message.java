package cc.openhome.controller;

import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/7.
 */
@WebServlet(
        urlPatterns = {"/message.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW", value = "member.view"),
                @WebInitParam(name = "ERROR_VIEW", value = "member.view")
        }
)
public class Message extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blabla = req.getParameter("blabla");
        if (blabla != null && blabla.length() != 0) {
            if (blabla.length() < 140) {
                String username = (String) req.getSession().getAttribute("login");
                UserService userService = (UserService) getServletContext().getAttribute("userService");
                userService.addMessage(username, blabla);
                resp.sendRedirect(SUCCESS_VIEW);
            } else {
                req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
            }
        } else {
            resp.sendRedirect(ERROR_VIEW);
        }
    }

}
