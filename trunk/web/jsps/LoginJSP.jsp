<%-- 
    Document   : LoginJSP
    Created on : 19.10.2014, 21:57:54
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.util.*" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="mainForm" action="LoginJSP.jsp" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password">
            <input type="submit" value="Submit">
        </form>
        <%@include file="../test/testGetParametersTable.jsp" %>
        <a href="../test/TestJSP.jsp">Follow the rabbit!</a>
        <%-- 
        <jsp:useBean id="loginBean" scope="session" class="main.LoginHandler" />
        <jsp:setProperty name="loginBean" property="login"/>
        <jsp:setProperty name="loginBean" property="password"/>
        <jsp:getProperty name="loginBean" property="login" /><br>
        <jsp:getProperty name="loginBean" property="password" /> 
        --%>
    </body>
</html>
