package cc.openhome;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by zhujie on 16/1/11.
 */
@WebListener
public class SomeContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
//        context.getSessionCookieConfig().setName("caterpillar-sessionId");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
