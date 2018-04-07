<%-- 
    Document   : change
    Created on : 17.03.2018, 22:30:39
    Author     : Кристина
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Изменить запись:</p>
        <form action="change" method="post">
            <p>id task <input type="text" maxlength="25" size="25" id="txt" name="id"/></p>
            <p>Дата и время:
                <input type="text" maxlength="25" size="25" id="txt" name="time"/></p>
            <p>Название:
                <input type="text" maxlength="25" size="30" id="txt1" name="name"/></p>
            <p>Описание:
                <input type="text" maxlength="30" size="30" id="txt2" name="desc"/></p>
            <p>Контакты:
                <input type="text" maxlength="40" size="40" id="txt3" name="conc"/></p>
            <h4><input type="submit" id="btn" value="Сохранить изменения"></h4>
        </form>
    </body>
</html>
