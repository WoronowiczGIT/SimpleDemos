<%--
  Created by IntelliJ IDEA.
  User: m1rage
  Date: 21.07.2019
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>Title</title>
        <style>
            p{
                background-color: coral;
            }
        </style>
    </head>
<body>
    <p>totally visible text</p>
    <p><!-- html comment--></p>
    <p><%-- jsp comment--%></p>
    <p>/** java comment 1 */</p>
    <p>/* java comment 2 */</p>
    <p>// java comment 3 */</p>
    <p>
        <%= "not a"
                // comment
        %>
    </p>
</body>
</html>
