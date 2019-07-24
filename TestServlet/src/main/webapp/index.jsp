<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <style>
        p{

        }

    </style>

</head>
<body>
<h2>Hello World!</h2>

<%
    for (int i = 0; i < 10; i++) {
         out.println(i);
        System.out.println(i);
    }
        out.println("hello i java");
%>
</body>
</html>

