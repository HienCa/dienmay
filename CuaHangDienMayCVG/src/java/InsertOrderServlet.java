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
@WebServlet(urlPatterns = {"/InsertOrderServlet"})
public class InsertOrderServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertOrderServlet at " + request.getContextPath() + "</h1>");
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
            //String orderCode = request.getParameter("orderCode").toUpperCase();
            String productName = request.getParameter("productName");
            String customerName = request.getParameter("customerName");

            String employeeName = request.getParameter("employeeName");
            String orderDate = request.getParameter("orderDate");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            String paymentMethod = request.getParameter("paymentMethod");

            //Order order = new Order(orderCode, employeeName, customerName, productCode, orderDate, amount, quantity, paymentMethod);
            Order order = new Order( employeeName, customerName, productName, orderDate, amount, quantity, paymentMethod);

            //insert
            //request.setAttribute("orderCode", orderCode);
            request.setAttribute("productName", productName);
            request.setAttribute("employeeName", employeeName);
            request.setAttribute("orderDate", orderDate);
            request.setAttribute("quantity", quantity);
            request.setAttribute("amount", amount);
            request.setAttribute("customerName", customerName);
            request.setAttribute("paymentMethod", paymentMethod);

            /*if (orderCode.length() < 4 || orderCode.length() > 10) {

                String CheckOrderCode = "Độ dài phải đủ 4-10 ký tự và đúng format MA**";
                request.setAttribute("CheckOrderCode", CheckOrderCode);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else */if (productName.length() < 4 || productName.length() > 200) {

                String CheckProductCode = "Độ dài phải đủ 4-10 ký tự ";
                request.setAttribute("CheckProductCode", CheckProductCode);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else if (customerName.length() < 4 || customerName.length() > 200) {

                String CheckCustomerCode = "Độ dài phải đủ 4-200 ký tự ";
                request.setAttribute("CheckCustomerCode", CheckCustomerCode);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else if (employeeName.length() < 4 || employeeName.length() > 200) {

                String CheckEmployeeCode = "Độ dài phải đủ 4-200 ký tự ";
                request.setAttribute("CheckEmployeeCode", CheckEmployeeCode);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else if (quantity < 1 || quantity > 1000) {

                String CheckQuantity = "Vui lòng số lượng hợp lệ";
                request.setAttribute("CheckQuantity", CheckQuantity);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else if (amount < 1000000 || amount > 999999999) {

                String CheckQuantity = "Vui lòng số lượng hợp lệ";
                request.setAttribute("CheckQuantity", CheckQuantity);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } else if (paymentMethod.length() < 2 || paymentMethod.length() > 20) {

                String CheckPaymentMethod = "Nhập phương thức thanh toán hợp lệ";
                request.setAttribute("CheckPaymentMethod", CheckPaymentMethod);
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            } /*else if (DBUtils.findOrderCodeBoolean(con, order)) {
                request.setAttribute("e", "Đơn đặt hàng có mã là: " + "'" + orderCode + "'" + " đã tồn tại.");
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            }*/ else {
                DBUtils.insertOrder(con, order);

                request.setAttribute("success", "Successfull Insert!...");
                request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Insert failed!" + ex);
            request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Insert failed!" + ex);
            request.getRequestDispatcher("/InsertOrder.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
