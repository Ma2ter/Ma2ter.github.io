<%  out.print("Login" + request.getParameter("login"));
    session.setAttribute("User", main.UserManager.createUser(request.getParameter("login")));
    response.sendRedirect(request.getHeader("Referer"));
%>