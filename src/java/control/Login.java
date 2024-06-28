
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.Dao;
import entity.Account;
import entity.Customers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("customer_username");
        String password = request.getParameter("customer_password");
        
        Dao dao = new Dao();
        Customers acc = dao.Login(username, password);
        if (acc == null) {
            request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không hợp lệ");
            request.getRequestDispatcher("DangNhap.jsp").forward(request, response);
//            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
            
        }else{
            HttpSession session = request.getSession();//khai báo session
            session.setAttribute("acc", acc);//đẩy tài khoản login lên session "acc"
            session.setMaxInactiveInterval(60*60*24*365);//set thời gian sống cho session
            request.getRequestDispatcher("/client/index.jsp").forward(request, response);//trường hợp cần đẩy theo dữ liệu lên trang home để xử lý và đòng thời trả kết quả về cho một trang nào đó vd trang login.jsp
//            response.sendRedirect("/client/index.jsp");//trường hợp này được sử dụng khi người dùng có dữ liệu hợp lệ không cần đẩy lên vì nếu dữ liệu hợp lện bản thân servlet home sẽ kiểm tra và load dữ liệu
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public static void main(String[] args) {
        
    }
}
