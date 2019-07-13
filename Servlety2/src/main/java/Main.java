import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static java.time.LocalDate.now;

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
        include();
//        forward();
//        printParamsCol();
//        printParamsEnum();
//        printParamValue();
//        calculateBirthDay();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;
        out = response.getWriter();


    }

    private void redirect() throws IOException {
        // code 302 -> chaneg url
        response.sendRedirect("index2.jsp");
    }
    // forward and include operates only on server resources
    private void forward() throws ServletException, IOException {
        // code 200 -> still connected to same servlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
        dispatcher.forward(request, response);
    }
    // it sticks responses together
    private void include() throws ServletException, IOException {
        //stacks declared html responses on top of each other
        // this return core 500 ->
        // RequestDispatcher dispatcher = request.getRequestDispatcher("www.google.pl");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index3.html");
        dispatcher.include(request, response);
        dispatcher.include(request, response);
    }

    private void calculateBirthDay() {
        String[] bd = request.getParameterValues("birthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = now();
        LocalDate birthday = LocalDate.parse(bd[0], formatter);

        out.println("<br>you have :" + Period.between(birthday, today).getYears() + " years</br>");
    }

    private void printParamValue() {
        out.println("<br>-- names and values --</br>");
        List<String> list = Collections.list(request.getParameterNames());

        for (String name : list) {
            String[] values = request.getParameterValues(name);
            int number = 0;

            for (String parameter : values) {
                out.println("<br>" +
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
        out.println("<br>get parameter Names - by collection</br>" + "names: ");
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
            out.println("<br>" + myEnum.nextElement() + "</br>");
        }
    }

}
