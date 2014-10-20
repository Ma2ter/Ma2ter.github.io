<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
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
            <h1>Page1!</h1>
            <%@ include file = "./LogInOut/LogInOut.jsp" %>
            <a href="Page2.jsp">Good page</a>

            <sql:setDataSource var="DataBase" driver="org.apache.derby.jdbc.ClientDriver"
                               url="jdbc:derby://localhost:1527/DataBase_1"
                               user="Letanir"  password="1qaz@WSX"/>
            <sql:query var="userList" dataSource="DataBase">
                SELECT * FROM LETANIR.USERS;
            </sql:query>
            <c:forEach var="row" items="${userList.rows}">
            <tr>
                <td><c:out value="${row.id}"/></td>
                <td><c:out value="${row.login}"/></td>
            </tr>
           </c:forEach>
    </body>
</html>
