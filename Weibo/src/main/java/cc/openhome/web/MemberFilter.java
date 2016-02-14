package cc.openhome.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/21.
 */
@WebFilter(
        urlPatterns = {"/delete.do", "/logout.do",
                "/message.do", "/member.jsp"},
        initParams = {
                @WebInitParam(name = "LOGIN_VIEW", value = "login.html")
        }
)
public class MemberFilter implements Filter {

    private String LOGIN_VIEW;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.LOGIN_VIEW = filterConfig.getInitParameter("LOGIN_VIEW");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getSession().getAttribute("login") != null) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect(LOGIN_VIEW);
        }
    }

    @Override
    public void destroy() {

    }
}
