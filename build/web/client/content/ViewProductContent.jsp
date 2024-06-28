<%-- 
    Document   : ViewProductContent
    Created on : Jun 28, 2024, 5:23:45 PM
    Author     : baokhanh
--%>
<%@page import="DAO.BooksDAO"%>
<%@page import="entity.Books"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <style>
        .card {
            border: 2px solid #000; /* Đường viền dày và màu đen */
        }
        .card-img-top {
            height: 300px; /* Giảm chiều cao của hình ảnh */
            object-fit: contain; /* Đảm bảo hình ảnh không bị méo và toàn bộ ảnh được hiển thị */
        }
        .book-image {
            width: 100%;
            height: 300px; /* Giảm chiều cao của hình ảnh */
            object-fit: contain; /* Đảm bảo hình ảnh không bị méo và toàn bộ ảnh được hiển thị */
        }
    </style>
   
    </head>
    <body>
   
         <div class="container-fluid py-5 mt-5">
            <div class="container py-5">
                <div class="row g-4 mb-5">
                    <div class="col-lg-8 col-xl-9">
                        <div class="row g-4">
            <div class="container">
        <h2>Book Detail</h2>
        <%
            String bookId = request.getParameter("book_id");
            BooksDAO dao = new BooksDAO();
            Books book = dao.getBookById(bookId);
            if (book != null) {
        %>
        <div class="card">
             <img src="<%= book.getBook_image() %>" class="card-img-top book-image" alt="Book Image">
                            
            <div class="card-body">
                
                <h5 class="card-title"><%= book.getBook_name() %></h5>
                <p class="card-text"><strong>Author:</strong> <%= book.getAuthor_id() %></p>
                <p class="card-text"><strong>Category:</strong> <%= book.getCategory_id() %></p>
                <p class="card-text"><strong>Publisher:</strong> <%= book.getPublish_id() %></p>
                <p class="card-text"><strong>Description:</strong> <%= book.getBook_description() %></p>
                <p class="card-text"><strong>Price:</strong> $<%= book.getBook_price() %></p>
                <p class="card-text"><strong>Quantity Available:</strong> <%= book.getBook_quantity_available() %></p>
                <a href="#" class="btn btn-primary">Add To Cart</a>
            </div>
        </div>
        <% } else { %>
        <p>Book not found!</p>
        <% } %>
    </div> 
                        </div>
                    </div>
                    <div class="col-lg-4 col-xl-3">
                        <div class="row g-4 fruite">
                            <div class="col-lg-12">
                                <div class="input-group w-100 mx-auto d-flex mb-4">
                                    <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                                    <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                                </div>
                                <div class="mb-4">
                                    <h4>Categories</h4>
                                    <ul class="list-unstyled fruite-categorie">
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="#">Apples</a>
                                                <span>(3)</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="#">Oranges</a>
                                                <span>(5)</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="#">Strawbery</a>
                                                <span>(2)</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="#"></i>Banana</a>
                                                <span>(8)</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="#">Pumpkin</a>
                                                <span>(5)</span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <h4 class="mb-4">Featured products</h4>
                                <div class="d-flex align-items-center justify-content-start">
                                    <div class="rounded" style="width: 100px; height: 100px;">
                                        <img src="img/featur-1.jpg" class="img-fluid rounded" alt="Image">
                                    </div>
                                    <div>
                                        <h6 class="mb-2">Big Banana</h6>
                                        <div class="d-flex mb-2">
                                     
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="d-flex mb-2">
                                            <h5 class="fw-bold me-2">2.99 $</h5>
                                            <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex align-items-center justify-content-start">
                                    <div class="rounded" style="width: 100px; height: 100px;">
                                        <img src="img/featur-2.jpg" class="img-fluid rounded" alt="">
                                    </div>
                                    <div>
                                        <h6 class="mb-2">Big Banana</h6>
                                        <div class="d-flex mb-2">
                              
                                   
                                        </div>
                                        <div class="d-flex mb-2">
                                            <h5 class="fw-bold me-2">2.99 $</h5>
                                            <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex align-items-center justify-content-start">
                                    <div class="rounded" style="width: 100px; height: 100px;">
                                        <img src="img/featur-3.jpg" class="img-fluid rounded" alt="">
                                    </div>
                                    <div>
                                        <h6 class="mb-2">Big Banana</h6>
                                        <div class="d-flex mb-2">
                                
                                        </div>
                                        <div class="d-flex mb-2">
                                            <h5 class="fw-bold me-2">2.99 $</h5>
                                            <h5 class="text-danger text-decoration-line-through">4.11 $</h5>
                                        </div>
                                    </div>
                                </div>
                        
                                
                                <div class="d-flex justify-content-center my-4">
                                    <a href="#" class="btn border border-secondary px-4 py-3 rounded-pill text-primary w-100">Vew More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
         </div>
    </body>
</html>
