<%-- 
    Document   : Registration
    Created on : 23.10.2014, 22:40:15
    Author     : Letanir
--%>

<% if(session.getAttribute("RefererPage") == null)
    session.setAttribute("RefererPage", request.getHeader("Referer"));%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String defaultLogin = session.getAttribute("RegistrationErrorLogin") == null ? "" : (String)session.getAttribute("RegistrationErrorLogin");
            String defaultEmail = session.getAttribute("RegistrationErrorEmail") == null ? "" : (String)session.getAttribute("RegistrationErrorEmail");
        %>
        <form name="registrationFrom" action="<%= helpers.ConstantHelper.rootPath%>/LogInOut/Register.jsp" method="POST">
            <p> Login: <input type="text" name="Login" value="<%= defaultLogin %>" />
                <%
                    if (session.getAttribute("RegistrationError") != null) {
                        out.write((String) session.getAttribute("RegistrationError"));
                        session.setAttribute("RegistrationError", null);
                    }
                %>
            <p>Password: <input type="password" name="Password" value="" />
            <p>Password confirmation: <input type="password" name="Password confirmation" value="" />
            <p>E-mail: <input type="text" name="E-mail" value="<%= defaultEmail%>" />
            <p>E-mail confirmation: <input type="text" name="E-mail confirmation" value="<%= defaultEmail%>" /></p>
            <input type="submit" value="Registration!" name="registration" />
        </form>
    </body>
</html>
