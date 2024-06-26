<%-- 
    Document   : index
    Created on : Jun 26, 2024, 10:44:12 PM
    Author     : baokhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="layout/HomeLayout.css">
    </head>
    <body>
        <% String content = "content/HomeContent.jsp"; %>
<jsp:include page="/client/layout/HomeLayout.jsp" />

    </body>
</html>
