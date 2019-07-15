package session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "shower",value = "/showS")
public class ShowSession extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter w;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;
        w = response.getWriter();

        showSession();
    }

    public void showSession(){
        HttpSession session = request.getSession(false);
        if(session != null){
            String attribute = (String)session.getAttribute("name");
            w.println(attribute);
        }

    }
}
