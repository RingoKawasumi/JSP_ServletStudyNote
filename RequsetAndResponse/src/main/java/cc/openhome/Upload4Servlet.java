package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by kawasumi on 15/12/22.
 */
@MultipartConfig(location = "/Users/kawasumi/Documents/MyTest/upload")
@WebServlet("/upload4.do")
public class Upload4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        for (Part part : req.getParts()) {
            if (part.getName().startsWith("file")) {
                String filename = getFilename(part);
                part.write(filename);
            }
        }
    }

    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return filename;
    }
}
