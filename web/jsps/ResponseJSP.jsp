<%-- 
    Document   : ResponseJSP
    Created on : 19.10.2014, 22:20:35
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:useBean id="loginBean" scope="session" class="main.LoginHandler" />

        <jsp:setProperty name="loginBean" property="login"/>
        <jsp:setProperty name="loginBean" property="password"/>
        <jsp:getProperty name="loginBean" property="login" /><br>
        <jsp:getProperty name="loginBean" property="password" />
    </body>
</html>
