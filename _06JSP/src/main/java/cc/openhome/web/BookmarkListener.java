package cc.openhome.web;

import cc.openhome.model.BookmarService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by zhujie on 16/1/21.
 */
@WebListener
public class BookmarkListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("bookmarkService", new BookmarService());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
