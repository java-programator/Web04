package pl.altkom.web.servlet;

import pl.altkom.web.SessionCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/hello", "/"},
        initParams = {
                @WebInitParam(name = "key1", value = "value1"),
                @WebInitParam(name = "key2", value = "value2")
            },
        loadOnStartup = 0
        )
public class HelloWorldServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        PrintWriter pw = response.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>Hello World!</H3>");
        pw.println("<h4>Session is new: " + session.isNew() + "</h4>");
        pw.println("<h5>Session counter: " + SessionCounter.getCounter() + "</h5>");
        pw.println("</BODY></HTML>");
    }
}
