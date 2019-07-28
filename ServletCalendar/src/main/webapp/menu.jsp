<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 28.07.2019
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String currentPage = request.getServletPath();%>
<h2>MENU</h2>

<% List<String> links = new ArrayList<>();
    links.add("index.jsp");
    links.add("upTime.jsp");
    links.add("json.jsp");
    links.add("wyrazenia.jsp");
    out.print(request.getContextPath());

    for (String address : links) {
        String name = address.replace(".jsp","");
        if (currentPage.equals("/"+address)) {
        %><a class="<%="current"%>" href="<%=address%>"><%=name%></a><%
        } else {
        %><a href="<%=address%>"><%=name%></a><%
        }
    }
%>


