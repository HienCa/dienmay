
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class newProductServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(urlPatterns = {"/InsertEmployeeServlet"})
public class InsertEmployeeServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertEmployeeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertEmployeeServlet at " + request.getContextPath() + "</h1>");
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
            String employeeCode = request.getParameter("employeeCode").toUpperCase();
            String fullnameEmployee = request.getParameter("fullnameEmployee").toUpperCase();
            //String thumbnail = request.getParameter("thumbnail");

            String thumbnail = "";
            Part part = request.getPart("thumbnail");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
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

            //insert
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
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (fullnameEmployee.length() < 5 || fullnameEmployee.length() > 200) {

                String CheckFullname = "Vui lòng nhập đủ họ và tên hợp lệ";
                request.setAttribute("CheckFullname", CheckFullname);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } /*if (dateOfBirth.length() < 10 || dateOfBirth.length() > 10) {

                String CheckDate = "Độ dài phải đủ 10 ký tự và đúng format dd/mm/yyyy";
                request.setAttribute("CheckDate", CheckDate);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            }*/else if (cccd.length() < 9 || cccd.length() > 12) {

                String CheckCCCD = "Độ dài từ 9 ký tự, không quá 12 ký tự";
                request.setAttribute("CheckCCCD", CheckCCCD);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (tel.length() < 10 || tel.length() > 50) {

                String CheckTel = "Độ dài phải từ 10-50 ký tự";
                request.setAttribute("CheckTel", CheckTel);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            }  else if (address.length() < 10 || address.length() > 200) {

                String CheckAddress = "Địa chỉ gồm số nhà/ ấp/ xã/ huyện/ tp";
                request.setAttribute("CheckAddress", CheckAddress);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (nation.length() < 2 || nation.length() > 50) {

                String CheckNation = "Độ dài phải đủ 2-50 ký tự ";
                request.setAttribute("CheckNation", CheckNation);
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else if (DBUtils.findMaNVEmployeeBoolean(con, employee)) {
                request.setAttribute("e", "Nhân viên có mã là: " + "'" + employeeCode + "'" + " đã tồn tại.");
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            } else {
                DBUtils.insertEmployee(con, employee);

                request.setAttribute("success", "Successfull Insert!...");
                request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Insert failed!" + ex);
            request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("e", "Insert failed!" + ex);
            request.getRequestDispatcher("/InsertEmployee.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
