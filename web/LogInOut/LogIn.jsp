<%  
    if(database.DBHandler.getInstance().checkUserExistence(
        request.getParameter("login"), request.getParameter("password")))
    {
        session.setAttribute("User", main.UserManager.createUser(request.getParameter("login")));
    } else {
        session.setAttribute("failedAuth", "true");
    }
    System.out.println(request.getHeader("Referer"));
    //TODO
    response.sendRedirect(request.getHeader("Referer"));
%>