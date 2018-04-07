<%-- 
    Document   : taskManager
    Created on : 17.03.2018, 21:07:17
    Author     : USER
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="model.Record"%>
<%@page import="java.io.Reader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="notific.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="mainform" action="main" method="post">
            <h1>Задачи пользователя</h1>
            <table id = "tasklog">
                <tr><th>№</th><th>Время</th><th>Название</th><th>Описание</th><th>Контакты</th><th>Выбрать</th></tr>
                <tr><td></td><td></td><td></td><td>Тут пока пусто</td><td></td><td><input type="radio" name="check" ></td></tr>
                        <%
                            LinkedList<Record> rec = (LinkedList<Record>)request.getAttribute("records");
                            String s = "";
                            if (rec!=null){
                                for (int i = 0; i<rec.size(); i++){
                                s+="<tr><td>"+i+"</td><td><td>";
                                s+=rec.get(i).getTimeString()+"</td><td><td>";
                                s+=rec.get(i).getName()+"</td><td><td>";
                                s+=rec.get(i).getDescription()+"</td><td><td>";
                                s+=rec.get(i).getContacts()+"</td><td><td>";
                                s+="<input type=\"radio\" name=\"check"+i+"\"></td></tr>";
                                out.println(s);
                                s = "";
                            }
                            }                            
                        %>
            </table>
            
            <br>
            
            <table>
                <td>
                    <label>Добавить запись:</label> 
                    <br>
                    <table id = "addRecTable">
                        <tr><td><label>Название</label></td>
                            <td><input type="text" name="name"></td></tr>
                        <tr><td><label>Время</label></td>
                            <td><input type="text" name="time"></td></tr>
                        <tr><td><label>Описание</label></td>
                            <td><input type="text" name="descr"></td></tr>
                        <tr><td><label>Контакты</label></td>
                            <td><input type="text" name="cont"></td></tr>
                    </table>
                    <button type="submit" value="a">Добавить</button>
                </td>
                
                <td>
                    <button type="submit" value="d">Удалить запись</button>
                    <br><br>
                    <button type="submit" value="c">Изменить запись</button>
                </td>
            </table>
        </form>

    </body>
</html>
