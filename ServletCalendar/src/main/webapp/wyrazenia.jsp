<%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 28.07.2019
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>wyrazenia</title>
</head>
<body>
<%--<%@include file="menu.jsp"%>--%>
<%--<jsp:include page="menu.jsp"></jsp:include>--%>
<div class="dblock">
    <p> wyrazenie</p>

        <% request.setAttribute("countries",new String[]{"Polska","niemce","francja"});%>

    <c:forEach items="${countries}" var="country">
    <p>poza coutem ${country}

        <c:out value="country"></c:out></p>

    </c:forEach>

    <p>Ten latwiejszy</p>
    <c:forEach var = "i" begin = "1" end = "5">
    Item <c:out value = "${i}"/><p>
    </c:forEach>

</body>
</div>
</html>
