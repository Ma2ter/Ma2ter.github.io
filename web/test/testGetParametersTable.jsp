<%-- 
    Document   : testGetParametersTable
    Created on : 20.10.2014, 12:13:48
    Author     : Ma2ter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@page import="java.util.*" %>

    </head>
    <body>
        <h2>HTTP Parameter Request Example</h2>
        <table width="100%" border="1" align="center">
            <tr bgcolor="#949494">
                <th>Header Name</th><th>Header Value(s)</th>
            </tr>
            <%
                Enumeration headerNames = request.getParameterNames();
                while (headerNames.hasMoreElements()) {
                    String paramName = (String) headerNames.nextElement();
                    out.print("<tr><td>" + paramName + "</td>\n");
                    String paramValue = request.getParameter(paramName);
                    out.println("<td> " + paramValue + "</td></tr>\n");
                }
            %>
        </table>
    </body>
</html>
