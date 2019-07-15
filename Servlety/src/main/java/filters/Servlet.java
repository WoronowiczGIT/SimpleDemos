package filters;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuperServlet", value = "/start")
public class Servlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        this.request = servletRequest;
        this.response = servletResponse;
        response.setContentType("text/html");

        String[] fetchedValues = request.getParameterValues("parametr1");
        PrintWriter writer = response.getWriter();

        writer.println(fetchedValues[0]);
    }
    @Override
    public void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        this.request = servletRequest;
        this.response = servletResponse;
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        writer.println("it works!");
    }

}
