package cc.openhome;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kawasumi on 15/12/23.
 */
@WebServlet("/some.view")
public class Some extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Some do one...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("other.view");
        dispatcher.include(req, resp);
        out.println("Some do two...");
        out.close();
    }
}
