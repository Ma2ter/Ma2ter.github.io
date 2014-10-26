<%@page import="interfaces.Entity"%>
<%@page import="managers.EntityManager"%>
<%
    String param = String.format("login=%s,password=%s", request.getParameter("Login"), request.getParameter("Password"));
    main.User newUser = EntityManager.getInstance().createUser(param);
    if (newUser == null) {
        session.setAttribute("RegistrationError", "User with this login already exists");
        session.setAttribute("RegistrationErrorLogin", request.getParameter("Login"));
        session.setAttribute("RegistrationErrorEmail", request.getParameter("E-mail"));
        
        response.sendRedirect(request.getHeader("Referer"));
    } else {
        if (session.getAttribute("User") != null) {
            EntityManager.getInstance().removeUser((main.User) session.getAttribute("User"));
        }
        session.setAttribute("User", newUser);
        response.sendRedirect((String) session.getAttribute("RefererPage"));
        session.setAttribute("RefererPage", null);
    }

%>