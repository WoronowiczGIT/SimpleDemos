<%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 21.07.2019
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dellotto</title>
</head>
<body>

<% Cookie[] cooks = request.getCookies();
    for (Cookie c: cooks
    ) {
        c.setMaxAge(0);
        response.addCookie(c);
    }
    response.sendRedirect("index.jsp");

%>

</body>
</html>
