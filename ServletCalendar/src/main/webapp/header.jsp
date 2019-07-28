<%@ page import="java.time.DayOfWeek" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 28.07.2019
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  String currentDay="";
    DayOfWeek today = LocalDate.now().getDayOfWeek();

    for (DayOfWeek dayOfWeek: DayOfWeek.values()) {
        if(dayOfWeek.equals(today)){
            currentDay = "current ";
        }
        if(dayOfWeek.equals(DayOfWeek.SATURDAY)){
            currentDay += "sat";
        }else if(dayOfWeek.equals(DayOfWeek.SUNDAY)){
            currentDay += "sun";
        }

    %><span class="<%=currentDay%>">
    <%=dayOfWeek.toString()%>
</span><%
    }
%>
