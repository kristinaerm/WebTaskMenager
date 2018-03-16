<%-- 
    Document   : notification
    Created on : 16.03.2018, 21:59:43
    Author     : Кристина
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="notific.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form>
<p>Дата и время:
<input type="text" maxlength="25" size="25" id="txt"/></p>
<p>Название:
<input type="text" maxlength="25" size="30" id="txt1"/></p>
<p>Описание:
<input type="text" maxlength="30" size="30" id="txt2"/></p>
<p>Контакты:
<input type="text" maxlength="40" size="40" id="txt3"/></p>
<h3><input type="text" maxlength="40" size="25" id="txt4"/></h3>
<h4><input type="button" id="btn" value="Выполнить"></h4>
<h5><input type="button" id="btn1" value="Отложить на  другое время"></h5>>
</form>
    </body>
</html>
