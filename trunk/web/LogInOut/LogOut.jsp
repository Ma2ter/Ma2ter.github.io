<%  session.invalidate();
    
    response.sendRedirect(request.getHeader("Referer"));
%>