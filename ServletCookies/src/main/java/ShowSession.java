import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "showSession",value = "showS")
public class ShowSession extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter writer;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        this.request = request;
        this.response = response;

        showSession();
    }
    public void showSession() throws IOException {
        HttpSession session = request.getSession();
        String attribute = (String)session.getAttribute("name");
        request.getSession(false);

        writer.println(attribute);
    }
}
