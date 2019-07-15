package session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "killer",value = "/kill")
public class KillSession extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter writer;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        this.request = request;
        this.response = response;

        writer.println("killed session");
        kill();
    }

    public void kill(){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
}
