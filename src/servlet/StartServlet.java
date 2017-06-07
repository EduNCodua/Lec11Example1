package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Fallback on 07.06.2017.
 */
@WebServlet(name = "StartServlet", urlPatterns = "/StartPage")
public class StartServlet extends HttpServlet {

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            printWriter.print("<html>\n" +
                    "  <head>\n" +
                    "    <title>Title</title>\n" +
                    "  </head>\n" +
                    "  <body> Hello World \n" +
                    "    <p> <img src=\"image\">\n" +
                    "  </body>\n" +
                    "</html>");
        } finally {
            printWriter.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
