<%-- 
    Document   : newjsp
    Created on : 19.03.2018, 21:07:42
    Author     : Кристина
--%>

<%@ page import="servermenager.Test" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%

    String str = new Test().testic();

%>
<%=str%>
</body>
</html>