<%@ page import="main.User"%>
<%! helpers.CommonHelper commonHelper = helpers.CommonHelper.getInstance();%>
<%! database.DBHandler dbHandler = database.DBHandler.getInstance();%>
<%
    if (session.isNew()) {
        session.setAttribute("User", null);
    }
    if (session.getAttribute("User") == null) {
%>

<form name="logInForm" action="<%= helpers.ConstantHelper.rootPath %>/LogInOut/LogIn.jsp" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Submit">
</form>
<form name="registrationForm" action="<%= helpers.ConstantHelper.rootPath %>/LogInOut/Registration.jsp" method="POST">
    <input type="submit" value="registration button" name="Registration!" />
</form>
<%     if (session.getAttribute("failedAuth") == "true") {
        out.println("<p>Authorization failed </p>");
        session.setAttribute("failedAuth", "false");
    }
} else {
    out.print(session.getMaxInactiveInterval());
%>

<p>Hello <% User curUser = (User) (session.getAttribute("User"));
    out.print(curUser.getLogin());%>
<form name="logOutForm" action="<%= helpers.ConstantHelper.rootPath %>/LogInOut/LogOut.jsp" method="POST">
    <input type="submit" value="LogOut" name="Exot" />
</form>

</p>
<% }%>