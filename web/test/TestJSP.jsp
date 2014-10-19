<%-- 
    Document   : newjsp
    Created on : 20.10.2014, 1:18:46
    Author     : Ma2ter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%-- This is JSP comment --%>
        <%-- This comment will not be visible in the page source --%> 
        
        <%-- Объявление переменных происходит именно так. Два варианта записи:
            1)XML запись через тег <jsp:declaration>
            2)<Быстрая запись через тег <%!>.
        Они абсолютно одинаковые для компилятора. --%>
        <jsp:declaration>
            String name = test.testHelper.getRandomString();
        </jsp:declaration>
        <%! java.util.Date date = new java.util.Date(); %>
        
        <%-- A JSP comment. Ignored by the JSP engine. --%>
        <!-- An HTML comment. Ignored by the browser. -->
        
    </head>
    
    <body>
        <%-- А вот я скопировал всё из тела testHeader и запихал сюда
        в виде хеадера страницы. Изи бризи, привет старый добрый PHP--%>
        <%@include file="testHeader.jsp" %>
        
        <%-- Так пишутся скриптлеты. Опять же, 2 формы записи, видны тут,
        расписывать смысла нет --%>
        <h1><% out.println("Welcome to Paradise City."); %></h1>
        <h2>
            <jsp:scriptlet>
                out.println("We have some info about you!");
            </jsp:scriptlet>
        </h2>
        
        <list>
            <%-- Выражения (exspressions). 2 формы записи.--%>
            <ul>"Name": <%= name %> </ul>
            <ul>"IP Adress": <%=request.getRemoteAddr() %> </ul>
            <ul>"Current Date": <jsp:expression>date</jsp:expression></ul>
            <ul>"Your ID:": <%= session.getId() %>;
            </ul>
        </list>
    </body>
</html>
