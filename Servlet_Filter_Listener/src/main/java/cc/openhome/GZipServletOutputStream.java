package cc.openhome;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhujie on 16/1/20.
 */
public class GZipServletOutputStream extends ServletOutputStream {

    private GZIPOutputStream gzipOutputStream;

    public GZipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }

    public GZIPOutputStream getGzipOutputStream() {
        return gzipOutputStream;
    }
}
