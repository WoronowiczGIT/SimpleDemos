import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "cookieShow", value = "/showC")
public class ShowCookie extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter writer;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        this.request = request;
        this.response = response;
        showCookies();
    }

    public void showCookies(){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c: cookies) {
                writer.println("<p>"+c.getName()+" "+c.getValue()+"</p>");
            }
        }
    }
}
