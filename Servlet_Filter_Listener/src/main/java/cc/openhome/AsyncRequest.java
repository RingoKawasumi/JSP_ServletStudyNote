package cc.openhome;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

/**
 * Created by zhujie on 16/1/20.
 */
public class AsyncRequest implements Runnable {

    private AsyncContext ctx;

    public AsyncRequest(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("久等了....XD");
            ctx.complete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
