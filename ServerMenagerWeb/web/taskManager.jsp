<%@page import="model.LoaderSQL"%>

%-- 
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
        <script>
            function submit() {
                var radios = document.getElementsByName("radio");
                for (var i = 0; i !== radios.length; i++) {
                    var radio = radios[i];
                    if (radio.checked) {
                        if (radio.value === "1") {
                            request.setAttribute("index", i.toString());
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <form name="mainform" action="main" method="post">
            <h1>Задачи пользователя</h1>
            <p><button value="r" name = "submit">Задачи</button></p>
            
            <table id = "tasklog">
                <tr>
                    <th>№</th>
                    <th><th>Время</th>
                    <th>  Название</th>
                    <th>  Описание</th>
                    <th>  Контакты</th>
                    <th>  Delete</th>
                    <th>  Change</th>
                </tr>
                <%
                    LinkedList<Record> r = new LinkedList<>();
                    r = new LoaderSQL().selectInTableTask();
                    String submit = request.getParameter("submit");
                    request.setAttribute("r",r);
                    if (("r".equals(submit))||("a".equals(submit))) {
                %>
                <%
                   
                        for (int i = 0; i < r.size(); i++) { 
                %>
              
                <tr ID = "<%= i%>">
                    <td><%= i+1%><td>
                    <td><a href=""><%= r.get(i).getTimeString()%></a></td>
                    <td><%= r.get(i).getName()%></td>
                    <td><%= r.get(i).getDescription()%></td>
                    <td><%= r.get(i).getContacts()%></td>
                    <td><button value="d<%= r.get(i).getId()%>"  name = "submit">Delete</button></td> 
                    <td><button value="c<%= r.get(i).getId()%>" name = "submit">Change</button></td>
                </tr>
                <%
                    }
                %>
                <%
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
                    <button value="a" name = "submit">Добавить</button>
                </td>

            </table>
        </form>

    </body>
</html>
