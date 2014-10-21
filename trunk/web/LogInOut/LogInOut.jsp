<%@ page import="main.User"%>
<%! helpers.CommonHelper commonHelper = helpers.CommonHelper.getInstance();%>
<%! database.DBHandler dbHandler = database.DBHandler.getInstance();%>
<%
    if (session.isNew()) {
        session.setAttribute("User", null);
    }
    if (session.getAttribute("User") == null) {
%>

<form name="logInForm" action="<%= commonHelper.getInitParam("rootPath")%>/LogInOut/LogIn.jsp" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password">
    <input type="submit" value="Submit">
</form>
<%--TODO --%>
<%     if (session.getAttribute("failedAuth") == "true") {
        out.println("<p>Authorization failed </p>");
        session.setAttribute("failedAuth", "false");
    }
} else {
    out.print(session.getMaxInactiveInterval());
%>

<p>Hello <% User curUser = (User) (session.getAttribute("User"));
    out.print(curUser.getLogin());%>
<form name="logOutForm" action="<%= commonHelper.getInitParam("rootPath")%>/LogInOut/LogOut.jsp" method="POST">
    <input type="submit" value="LogOut" name="Exot" />
</form>

</p>
<% }%>