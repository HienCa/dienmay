/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.File;
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
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String employeeCode = request.getParameter("employeeCode").toUpperCase();

        //update
        request.setAttribute("employeeCode", employeeCode);
        request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);

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
            String employeeCode = request.getParameter("employeeCode").toUpperCase();
            String fullnameEmployee = request.getParameter("fullnameEmployee").toUpperCase();
            //String thumbnail = request.getParameter("thumbnail");

            String thumbnail ="";
            Part part = request.getPart("thumbnail");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            String path1 = request.getContextPath();
            System.out.println(path1);
            part.write("C:/Users/PC/Documents/NetBeansProjects/CuaHangDienMayCVG/build/web/images" + fileName);
            thumbnail = fileName;

            String gender = request.getParameter("gender");
            String cccd = request.getParameter("cccd");
            String dateOfBirth = request.getParameter("date");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String nation = request.getParameter("nation");

            Employee employee = new Employee(employeeCode, fullnameEmployee, thumbnail, dateOfBirth, gender, cccd, tel, email, address, nation);

            //update
            request.setAttribute("employeeCode", employeeCode);
            request.setAttribute("fullnameEmployee", fullnameEmployee);
            request.setAttribute("thumbnail", thumbnail);
            request.setAttribute("cccd", cccd);
            request.setAttribute("date", dateOfBirth);
            request.setAttribute("address", address);
            request.setAttribute("nation", nation);
            request.setAttribute("tel", tel);
            request.setAttribute("email", email);

            if (employeeCode.length() < 4 || employeeCode.length() > 10) {

                String CheckEmployeeCode = "Độ dài phải đủ 4-10 ký tự và đúng format NV**";
                request.setAttribute("CheckEmployeeCode", CheckEmployeeCode);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            } else if (fullnameEmployee.length() < 5 || fullnameEmployee.length() > 200) {

                String CheckFullname = "Vui lòng nhập đủ họ và tên hợp lệ";
                request.setAttribute("CheckFullname", CheckFullname);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            } /*if (dateOfBirth.length() < 10 || dateOfBirth.length() > 10) {

                String CheckDate = "Độ dài phải đủ 10 ký tự và đúng format dd/mm/yyyy";
                request.setAttribute("CheckDate", CheckDate);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            }*/ else if (tel.length() < 10 || tel.length() > 20) {

                String CheckTel = "Độ dài phải từ 10-20 ký tự";
                request.setAttribute("CheckTel", CheckTel);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            } else if (cccd.length() < 9 || cccd.length() > 20) {

                String CheckCCCD = "Độ dài từ 9 ký tự, không quá 20 ký tự";
                request.setAttribute("CheckCCCD", CheckCCCD);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            } else if (address.length() < 10 || address.length() > 200) {

                String CheckAddress = "Địa chỉ gồm số nhà/ ấp/ xã/ huyện/ tp";
                request.setAttribute("CheckAddress", CheckAddress);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            } else if (nation.length() < 4 || nation.length() > 10) {

                String CheckNation = "Độ dài phải đủ 4-10 ký tự và đúng format NV**";
                request.setAttribute("CheckNation", CheckNation);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
            }  else if (DBUtils.findMaNVEmployeeBoolean(con, employee)) {
                DBUtils.updateEmployee(con, employee);

                request.setAttribute("success", "Successfull Update!...");
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);

            } else {
                request.setAttribute("e", "Update failed!... Không tìm thấy nhân viên có mã là " + employeeCode);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);

            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Update failed!" + ex);
            request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Update failed!" + ex);
            request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        processRequest(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
