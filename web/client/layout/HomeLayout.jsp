<%-- 
    Document   : HomeLayout
    Created on : Jun 26, 2024, 10:48:17 PM
    Author     : baokhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bookstore</title>
    <link rel="stylesheet" href="layout/HomeLayout.css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
</head>
<body>
     <%@ include file="/client/header/HeaderHome.jsp" %>
    <%@ include file="/client/content/HomeContent.jsp" %>
   
    <%@ include file="/client/footer/FooterHome.jsp" %>
</body>
</html>
