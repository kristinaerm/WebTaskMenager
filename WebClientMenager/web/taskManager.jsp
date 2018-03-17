<%-- 
    Document   : taskManager
    Created on : 17.03.2018, 21:07:17
    Author     : USER
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
        <h1>Задачи пользователя</h1>
        <table id = "tasklog">
            <tr><th>№</th><th>Время</th><th>Название</th><th>Описание</th><th>Контакты</th><th>Выбрать</th></tr>
            <tr><td></td><td></td><td></td><td>Тут пока пусто</td><td></td><td><input type="radio" name="check" ></td></tr>
        </table>
        <br>
        <table>
            <td>
                <label>Добавить запись:</label> 
                <br>

                <table id = "addRecTable">
                    <tr><td><label>Название</label></td>
                        <td><input type="text" name="total" id = "name"></td></tr>
                    <tr><td><label>Время</label></td>
                        <td><input type="text" name="total" id = "time"></td></tr>
                    <tr><td><label>Описание</label></td>
                        <td><input type="text" name="total" id = "descr"></td></tr>
                    <tr><td><label>Контакты</label></td>
                        <td><input type="text" name="total" id = "cont"></td></tr>
                </table>
                <input type="button" value="Добавить"/>
            </td>
            <td>
                <input type="button" value="Удалить запись"/>
                <br><br>
                <input type="button" value="Изменить запись"/>
                <br><br>
                <input type="button" value="Сохранить журнал"/>
                
            </td>

        </table>
    </body>
</html>
