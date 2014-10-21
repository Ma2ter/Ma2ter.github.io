<%  
    if(database.DBHandler.getInstance().checkUserExistence(
        request.getParameter("login"), request.getParameter("password")))
    {
        database.DBHandler.getInstance().addUser("admin", "admin");
        session.setAttribute("User", main.UserManager.createUser(request.getParameter("login")));
    } else {
        session.setAttribute("failedAuth", "true");
    }
    System.out.println(request.getHeader("Referer"));
    //TODO
    response.sendRedirect(request.getHeader("Referer"));
%>