<%@page import="javax.servlet.* " %>
<%@page import="java.io.* " %>
<%@page import="java.util.Collections " %>
<html>
<body>
<h2>Hello World!</h2>
<h2>prosty serwlet wyswietlajacy parametry</h2>
//poczatek kodu java
<%
    for (String parameterName : Collections.list(request.getParameterNames())) {
        out.println(parameterName + " -> [");
        String[] values = request.getParameterValues(parameterName);
        for (int i = 0; i < values.length; i++) {
            out.println(values[i]);

            // nie wypisuj przecinka po ostatnim parametrze
            if (i < values.length - 1) {
                out.println(", ");
            }
        }

        out.println("]");

%>
<br/>
<%
//wrzucamy znacznik <br/> pod koniec for aby drukowac kazdy parametr w nowej lini
}
// koniec kodu java
%>
<br/>
</body>
</html>