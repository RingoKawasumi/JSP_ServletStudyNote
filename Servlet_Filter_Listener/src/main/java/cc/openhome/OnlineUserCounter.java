package cc.openhome;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by zhujie on 16/1/11.
 */
@WebListener
public class OnlineUserCounter implements HttpSessionListener {
    private static int counter;

    public static int getCounter() {
        return counter;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        OnlineUserCounter.counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        OnlineUserCounter.counter--;
    }
}
