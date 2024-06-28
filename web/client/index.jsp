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
             <link rel="stylesheet" href="css/style.css">
             <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
              </head>
    <body>
        <% String content = "content/HomeContent.jsp"; %>
<jsp:include page="/client/layout/HomeLayout.jsp" />

    </body>
</html>
