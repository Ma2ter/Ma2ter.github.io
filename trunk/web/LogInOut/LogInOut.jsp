<%@ page import="main.User"%>
<%
    if (session.isNew()){
        session.setAttribute("User", null);
    }
    if (session.getAttribute("User") == null) {
            %>

<form name="logInForm" action="./LogInOut/LogIn.jsp" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password">
    <input type="submit" value="Submit">
</form>
<% } else { out.print(session.getMaxInactiveInterval());
    %>

    <p>Hello <% User curUser = (User)(session.getAttribute("User"));
    out.print(curUser.getLogin());%>
    <form name="logOutForm" action="./LogInOut/LogOut.jsp" method="POST">
        <input type="submit" value="LogOut" name="Exot" />
    </form>
</p>
<% } %>
s