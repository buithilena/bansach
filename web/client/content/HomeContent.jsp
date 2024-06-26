<%-- 
    Document   : MainContent
    Created on : Jun 26, 2024, 10:49:21 PM
    Author     : baokhanh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="hero">
    <div class="container">
        <h2>Welcome to Bookstore</h2>
        <p>Explore our wide collection of books and find your next favorite read.</p>
        <a href="#" class="btn">Shop Now</a>
    </div>
</section>

<section class="categories">
    <div class="container">
        <h2>Browse by Category</h2>
     <ul class="category-list">
    <c:forEach var="category" items="${categories}">
        <li><a href="category?id=${category.category_id}">${category.category_name}</a></li>
    </c:forEach>
</ul>

    </div>
</section>

<section class="featured-books">
    <div class="container">
        <h2>Featured Books</h2>
        <ul class="book-list">
            <li>
                <a href="#">
                    <img src="book1.jpg" alt="Book Title">
                    <h3>Vết Củ</h3>
                    <p>Đoàn Hiệu Lương</p>
                    <span class="price">50,000 VNĐ</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="book2.jpg" alt="Book Title">
                    <h3>BUY ONE, GET ONE 50% OFF</h3>
                    <p>Romance</p>
                    <span class="price">100,000 VNĐ</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="book3.jpg" alt="Book Title">
                    <h3>Vết Củ</h3>
                    <p>Đoàn Hiệu Lương</p>
                    <span class="price">50,000 VNĐ</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="book4.jpg" alt="Book Title">
                    <h3>Vết Củ</h3>
                    <p>Đoàn Hiệu Lương</p>
                    <span class="price">50,000 VNĐ</span>
                </a>
            </li>
        </ul>
    </div>
</section>
