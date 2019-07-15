import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "cookieAdd",value = "/add")
public class AddCookie extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter writer;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        this.request = request;
        this.response = response;

        addCookies();
    }

    public void addCookies(){
        List<String> names = Collections.list(request.getParameterNames());
        if(names != null){
            for (String name: names) {
                String value = request.getParameter(name);
                if(value != null){
                    response.addCookie(new Cookie(name,value));
                }
            }
        }
    }
}
