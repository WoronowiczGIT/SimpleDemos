import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

// value - to co wpisujemy w przegladarce
// name - ?
@WebServlet(name = "SayMyName", value = "/hello")
public class Main extends HttpServlet {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        this.request = request;
        this.response = response;
        out = response.getWriter();

        print();
        printParamsCol();
        printParamsEnum();
        printParamValue();

    }

    private void printParamValue() {
        out.println("<br>-- names and values --</br>");
        List<String> list = Collections.list(request.getParameterNames());

        for (String name : list) {
            String[] values = request.getParameterValues(name);
            int number = 0;
            for (String parameter : values) {
                out.println(
                        "<br>" +
                        "name: " + name +
                        " value: " + parameter +
                        " number: " + number++ +
                        "</br>");
            }
        }
    }

    private void print() {
        int code = response.getStatus();
        out.println("Hello my little World");
        out.println("<p><strong><font size:\"45\"> funny text </font></strong></p>");
        out.println(code);
    }

    private void printParamsCol() {
        // localhost:7070/main/servlet/hello?parameter_name=value
        // collection approach for recieving names
        out.println("<br>get parameter Names - by collection</br>"+"names: ");
        List<String> list = Collections.list(request.getParameterNames());
        for (String name : list) {
            out.println(name);
        }
    }

    private void printParamsEnum() {
        // iterator approach for recieving names
        out.println("<br> -- print with enumerations -- </br>");
        Enumeration myEnum = request.getParameterNames();
        while (myEnum.hasMoreElements()) {
            out.println("<br>"+myEnum.nextElement()+"</br>");
        }
    }

}
