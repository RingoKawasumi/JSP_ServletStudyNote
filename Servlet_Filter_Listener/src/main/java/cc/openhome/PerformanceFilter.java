package cc.openhome;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhujie on 16/1/19.
 */
//@WebFilter(filterName = "performance",
//        urlPatterns = {"/*"},
//        servletNames = {""},
//        initParams = {
//                @WebInitParam(name = "PARAM1", value = "VALUE1"),
//                @WebInitParam(name = "PARAM2", value = "VALUE2")
//        },
//        dispatcherTypes = {
//                DispatcherType.FORWARD,
//                DispatcherType.INCLUDE,
//                DispatcherType.REQUEST,
//                DispatcherType.ERROR,
//                DispatcherType.ASYNC
//        })
public class PerformanceFilter implements Filter {

    private FilterConfig config;
    private String PARAM1;
    private String PARAM2;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        PARAM1 = config.getInitParameter("PARAM1");
        PARAM2 = config.getInitParameter("PARAM2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        chain.doFilter(request, response);
        config.getServletContext().log("Request process in " + (System.currentTimeMillis() - begin) + " milliseconds");
    }

    @Override
    public void destroy() {

    }
}
