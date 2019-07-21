<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 21.07.2019
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>try session</title>
</head>
<body>
<h2> session id</h2>
<br/>
Session Id : <%= session.getId() %>
<br/>
created : <%= session.getCreationTime() %> seconds ago;
<br>
<%
    String basicName = "";
    List<String> names = Collections.list(session.getAttributeNames());
    if (names != null && names.size() > 0) {
        basicName = names.get(0);
    }
%>
<%= basicName%>
<br>
<%= "handwritten string"%>
<%! String spitString() {
    return "string from method";
}%>
<br>
<%= spitString()%>

</body>
</html>
