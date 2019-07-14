import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "starter",value = "/session")
public class StartSession extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter writer;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        this.request = request;
        this.response = response;

        startSession();
    }
    public void startSession(){
        HttpSession session = request.getSession();
        request.getSession(true);
        session.setAttribute("name","session attribute");
        writer.println("session is on");
    }
}
