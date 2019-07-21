<%@ page import="java.util.Random" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 21.07.2019
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lotto</title>

</head>
<body>
<%!  List<Integer> randomize() {
    List<Integer> list = new ArrayList<>();
    int length = 6;
    int[] result = new int[length];
    while (list.size() < length){
        int num = new Random().nextInt(48)+1;
        if(!list.contains(num)){
            list.add(num);
        }
    }
    return list;
}

     String resToString(List<Integer> numbers) {
        String out = "";
        for (int n : numbers) {
            out += n + "|";
        }
        return out;
    }
%>

<p> Old numbers </p>
<%
    Cookie[] cookies = request.getCookies();
    int counter =0;
    if (cookies != null && cookies.length > 0) {

        for (Cookie c : cookies) {
            if (c.getName().contains("number")) {
                out.println(c.getValue());
                response.addCookie(new Cookie("number"+counter,c.getValue()));
                counter++;
                %><br><%
            }
        }
    }
    %><p> new numbers</p><%

    String newNumbers = resToString(randomize());
    out.println(newNumbers);
    response.addCookie(new Cookie("number"+counter, newNumbers));
%>

<form>
    <br>
    <button> LOSUJ NOWE </button>
</form>
<form action="dellotto.jsp">
    <button> delete cookies</button>
</form>

</body>
</html>
