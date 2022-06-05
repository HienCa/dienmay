/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/FindProductServlet"})
public class FindProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String findProduct = request.getParameter("findProduct");
        Connection con = null;
        try {
            con = MySQLConntUtils.getMySQLConnection();
            ArrayList<Product> list = DBUtils.AllProduct(con, findProduct);
            
            if (list != null) {

                request.setAttribute("list", list);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            } 
            else{
                request.setAttribute("findEmpty", "Không tìm thấy sản phẩm có thông tin liên quan...");
                request.setAttribute("note", "Để tìm được kết quả chính xác hơn, bạn vui lòng:");
                request.setAttribute("note1", "**** Kiểm tra lỗi chính tả của từ khóa đã nhập.");
                request.setAttribute("note2", "*** Thử lại bằng từ khóa có độ chính xác cao.");
                request.setAttribute("note3", "** Thử lại bằng những từ khóa tổng quát hơn.");
                request.setAttribute("note4", "* Thử lại bằng những từ khóa ngắn gọn hơn.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", ex);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", ex);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
