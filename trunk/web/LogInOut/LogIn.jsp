<%  
    if(database.DBHandler.getInstance().checkUserExistence(
        request.getParameter("login"), request.getParameter("password")))
    {
        session.setAttribute("User", new main.User("login=" + request.getParameter("login")));
    } else {
        session.setAttribute("failedAuth", "true");
    }
    response.sendRedirect(request.getHeader("Referer"));
%>