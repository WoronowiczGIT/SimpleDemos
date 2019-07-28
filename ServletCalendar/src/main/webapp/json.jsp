<%@ page import="jsonModel.JsonModel" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="org.json.JSONObject" %>

<%@ page contentType="mime" pageEncoding="UTF-8"%>
<% JsonModel jan = new JsonModel(
        "jan",
        "kowalski",
        54,
        LocalDate.now().getDayOfWeek());

        JSONObject mappedObject = new JSONObject(jan);
        String myJson = JSONObject.valueToString(mappedObject);
        out.print(myJson);
%>