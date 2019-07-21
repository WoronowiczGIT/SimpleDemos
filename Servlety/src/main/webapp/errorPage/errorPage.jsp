<%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 21.07.2019
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
    <style>
        h3 {
            text-align: center;
            font-size: 50px;
            animation: blink infinite 1s;
        }

        li:nth-child(1){
            overflow: hidden;
            display: block;
            position: absolute;
            font-size: 48px;
            line-height: 50px;
            width: 30vw;
            animation: bounce linear 5s infinite;
        }
        @keyframes blink {
            0%{
                background-color: red;
            }
            50%{
                background-color: yellow;
            }
            100%{
                background-color: blue;
            }
        }

        @keyframes bounce {
            0%{
                top: 0;
                left: 30%;
            }
            20%{
                 top: 50%;
                 left: calc(100% - 30vw);
             }
            40%{
                top: calc(100% - 100px);
                left: 50%;
            }
            80%{
                top: 35%;
                left: 0%;
            }
            100%{
                top: 0;
                left: 30%;
            }
        }
    </style>
</head>
<body>
<h3>Due to following reasons an error has occurred</h3>
<ul>
    <li><%=exception.getClass() %></li>
    <li><%=exception.getMessage() %></li>
</ul>
</body>
</html>
