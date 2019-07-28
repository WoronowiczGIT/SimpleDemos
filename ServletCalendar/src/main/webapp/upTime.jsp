<%@ page import="java.sql.Time" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.*" %>
<%@ page import="timeConv.TimeConverter" %><%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 28.07.2019
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">

    <title>upTime</title>
</head>
<body>
<%@include file="header.jsp"%>
<%@include file="menu.jsp"%>
<%
    long now = Instant.now().toEpochMilli();

    long start = session.getCreationTime();
    long lastVisit = session.getLastAccessedTime();
    long systemT = System.nanoTime();

    long visitDuration = now - lastVisit;
    long msDuration = now - start;
    long systemDuration = now - systemT;

    long visitS = visitDuration / 1000;
    long sessionS = msDuration / 1000;
    long systemS = systemDuration / 1000;

    TimeConverter tc = new TimeConverter();

    String sessionTime = tc.convert(sessionS);
    String visitTime = tc.convert(visitS);
    String systemTime = tc.convert(systemS);
%>
<ul>
    <li> session time </li>
    <li> <%=sessionTime%> </li>
    <li> time from last visit </li>
    <li> <%=visitTime%> </li>
    <li> system time </li>
    <li> <%=systemTime%> </li>

</ul>
<%@include file="footer.jsp"%>
</body>
</html>
