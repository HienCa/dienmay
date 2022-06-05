/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/UpdateCustomerServlet"})
public class UpdateCustomerServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCustomer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String CustomerCode = request.getParameter("CustomerCode");

        try {
            Connection conn = MySQLConntUtils.getMySQLConnection();
            Customer customer = DBUtils.OneCustomer(conn, CustomerCode);

            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
        }
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
        Connection con = null;
        try {
            con = MySQLConntUtils.getMySQLConnection();
            request.setCharacterEncoding("UTF-8");
            String CustomerCode = request.getParameter("CustomerCode").toUpperCase();
            String Fullname = request.getParameter("Fullname");
            String DateOfBirth = request.getParameter("DateOfBirth");
            String Gender = request.getParameter("gender");
            String Tel = request.getParameter("Tel");
            String Email = request.getParameter("Email");
            String CCCD = request.getParameter("CCCD");
            String Address = request.getParameter("Address");

            Customer customer = new Customer(CustomerCode, Fullname, DateOfBirth, Gender, Email, Tel, CCCD, Address);

            //update
            request.setAttribute("CustomerCode", CustomerCode);
            request.setAttribute("Fullname", Fullname);
            request.setAttribute("DateOfBirth", DateOfBirth);
            request.setAttribute("gender", Gender);
            request.setAttribute("Tel", Tel);
            request.setAttribute("Email", Email);
            request.setAttribute("CCCD", CCCD);
            request.setAttribute("Address", Address);

            if (CustomerCode.length() < 4 || CustomerCode.length() > 10) {

                String CheckCustomerCode = "Độ dài phải đủ 4-10 ký tự và đúng format KH**";
                request.setAttribute("CheckCustomerCode", CheckCustomerCode);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            } /*if (DateOfBirth.length() < 10 || DateOfBirth.length() > 10) {

                String CheckDateOfBirth = "Độ dài phải đủ 10 ký tự và đúng format dd/mm/yyyy";
                request.setAttribute("CheckDateOfBirth", CheckDateOfBirth);
                request.getRequestDispatcher("/InsertCustomer.jsp").forward(request, response);
            }*/ else if (Fullname.length() < 4 || Fullname.length() > 200) {

                String CheckTel = "Vui lòng nhập đúng họ tên";
                request.setAttribute("CheckTel", CheckTel);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            }/* else if (CCCD.length() < 9 || CCCD.length() > 12) {

                String CheckCCCD = "Độ dài từ 9 ký tự, không quá 12 ký tự";
                request.setAttribute("CheckCCCD", CheckCCCD);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            }*/ else if (Tel.length() < 9 || Tel.length() > 50) {

                String CheckTel = "Độ dài phải từ 9-50 ký tự ";
                request.setAttribute("CheckTel", CheckTel);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            } else if (Address.length() < 5 || Address.length() > 200) {

                String CheckAddress = "Địa chỉ gồm số nhà/ ấp/ xã/ huyện/ tp";
                request.setAttribute("CheckAddress", CheckAddress);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            } else if (DBUtils.findCustomerCodeBoolean(con, customer)) {

                DBUtils.UpdateCustomer(con, customer);
                request.setAttribute("success", "Successfull Update!...");
                request.getRequestDispatcher("/Customers.jsp").forward(request, response);
            } else {
                request.setAttribute("e", "Update failed!... Không tìm thấy khách hàng có mã là " + CustomerCode);
                request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Update failed!" + ex);
            request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Update failed!" + ex);
            request.getRequestDispatcher("/UpdateCustomer.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
