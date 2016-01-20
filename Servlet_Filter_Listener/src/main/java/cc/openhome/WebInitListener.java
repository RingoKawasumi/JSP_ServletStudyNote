package cc.openhome;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujie on 16/1/20.
 */
@WebListener
public class WebInitListener implements ServletContextListener {

    private List<AsyncContext> asyncs = new ArrayList<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("asyncs", asyncs);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep((int) (Math.random() * 10000));
                        double num = Math.random() * 10;
                        synchronized (asyncs) {
                            for (AsyncContext ctx : asyncs) {
                                ctx.getResponse().getWriter().println(num);
                                ctx.complete();
                            }
                            asyncs.clear();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
