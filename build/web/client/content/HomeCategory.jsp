<%-- 
    Document   : HomeCategory
    Created on : Jun 26, 2024, 11:51:28 PM
    Author     : baokhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Books" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books by Category</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <%@ include file="/client/header/HeaderHome.jsp" %>
    </header>
  <main>
        <section class="books">
            <div class="container" >
                <h2>Books idfn Category</h2>
                <ul class="book-list">
                    <%
                        List<Books> books = (List<Books>) request.getAttribute("books");
                        if (books != null) {
                            for (Books book : books) {
                    %>
                        <li>
                            <a href="#">
                      
                                <h3><%= book.getBook_name() %></h3>
                                <p><%= book.getAuthor_id() %></p>
                                <span class="price"><%= book.getBook_price() %> VNĐ</span>
                            </a>
                        </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </div>
        </section>
    </main>
    <footer>
        <%@ include file="/client/footer/FooterHome.jsp" %>
    </footer>
</body>
</html>
