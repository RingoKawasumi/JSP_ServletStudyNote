package cc.openhome;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by zhujie on 16/1/11.
 */
@WebListener
public class ContextParameterReader implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String avatars = context.getInitParameter("AVATAR");
        context.setAttribute("avatars", avatars);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
