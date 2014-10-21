<%@ page import="java.sql.*"%>



<%-- 
Document   : Page1
Created on : 20.10.2014, 18:40:13
Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is bad page</h1>
        <%@ include file = "/LogInOut/LogInOut.jsp" %>
        <a href="<%= commonHelper.getInitParam("rootPath") %>/test/Page2.jsp">Good page</a>
        <%! ResultSet rs = dbHandler.query("select * from USERS");%>
    </body>
</html>
