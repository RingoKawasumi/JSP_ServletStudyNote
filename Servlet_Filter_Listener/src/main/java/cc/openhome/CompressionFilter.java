package cc.openhome;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhujie on 16/1/20.
 */
@WebFilter(filterName = "CompressionFilter", urlPatterns = {"/*"})
public class CompressionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String encodings = req.getHeader("accept-encoding");
        if ((encodings != null) && (encodings.indexOf("gzip") > -1)) {
            CompressionWrapper compressionWrapper = new CompressionWrapper(res);
            compressionWrapper.setHeader("content-encoding", "gzip");
            chain.doFilter(request, compressionWrapper);
            GZIPOutputStream gzipOutputStream = compressionWrapper.getGZIPOutputStream();
            if (gzipOutputStream != null) {
                gzipOutputStream.finish();
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
