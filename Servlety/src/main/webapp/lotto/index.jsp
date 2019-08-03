<%@ page import="lottoHandler.NumberParser" %>
<%@ page import="lottoHandler.FetchJSON" %>
<%@ page import="java.util.*" %>

<%--
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
    <style>
        div {
            display: block;
            position: absolute;
            top: 0;
            left: 30%;
        }

        * {
            font-size: 22px;
        }

        p {
            font-size: 32px;
        }

        span {
            text-decoration: underline;
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<%

    FetchJSON fetcher = new FetchJSON();
    NumberParser np = new NumberParser();
    String numbers = np.extractNumbers(fetcher.getJSON());
    Set<Integer> result = np.parseNumbers(numbers);
%>
<body>
<%! List<Integer> randomize() {
    List<Integer> list = new ArrayList<>();
    int length = 6;
    int[] result = new int[length];
    while (list.size() < length) {
        int num = new Random().nextInt(48) + 1;
        if (!list.contains(num)) {
            list.add(num);
        }
    }
    return list;
}

    String numbersToString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(n + "|");
        }
        return sb.toString();
    }
%>
<p> real result </p>

<%= result%>
<div>
    <p> Old numbers </p>
    <%
        Cookie[] cookies = request.getCookies();
        int counter = 0;
        if (cookies != null && cookies.length > 0) {

            for (Cookie c : cookies) {
                if (c.getName().contains("number")) {
                    Set<Integer> current = np.parseNumbers(c.getValue());
                    Iterator<Integer> iterator = current.iterator();
                    while (iterator.hasNext()) {
                        int n = iterator.next();
                        if (result.contains(n)) {
    %><span><%out.println(n);%></span><%
        } else {
            out.println(n);
        }
    }

    response.addCookie(new Cookie("number" + counter, c.getValue()));
    counter++;
%><br><%
            }
        }
    }
%>
</div>
<p> new numbers</p>
<%
    String newNumbers = numbersToString(randomize());
    out.println(newNumbers);
    response.addCookie(new Cookie("number" + counter, newNumbers));
%>

<form>
    <br>
    <button> LOSUJ NOWE</button>
</form>
<form action="dellotto.jsp">
    <button> delete cookies</button>
</form>

</body>
</html>
