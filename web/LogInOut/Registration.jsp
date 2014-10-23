<%-- 
    Document   : Registration
    Created on : 23.10.2014, 22:40:15
    Author     : Letanir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="registrationFrom" action="<%= helpers.ConstantHelper.rootPath %>/LogInOut/Register.jsp" method="POST">
            <p> Login: <input type="text" name="Login" value="" />
            <p>Password: <input type="password" name="Password" value="" />
            <p>Password confirmation: <input type="password" name="Password confirmation" value="" />
            <p>E-mail: <input type="text" name="E-mail" value="" />
            <p>E-mail confirmation: <input type="text" name="E-mail confirmation" value="" /></p>
            <input type="submit" value="Registration!" name="registration" />
        </form>
    </body>
</html>
